package com.cms.contractmanagementsystem.web;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cms.contractmanagementsystem.utils.*;
import com.cms.contractmanagementsystem.dao.*;


/**
 * Servlet implementation class ClientInfoManage
 */
@WebServlet("/ClientManage")
public class ClientManage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientManage() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        Integer operatorNo=(Integer)request.getSession().getAttribute("id");

        String type=request.getParameter("type");
        if(type==null){
            ClientDAO clientdao=new ClientDAO();
            Client client=new Client();
            ArrayList<IEntity> arr = clientdao.GetEntitySet(client);
            ArrayList<Client> clients = new ArrayList<Client>();

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Client client1=(Client)(new ClientDAO().GetOneEntity(((Client) arr.get(i)).GetId()));
                    //Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    clients.add(client1);
                }
            }
            request.setAttribute("clients",clients);
            request.getRequestDispatcher("ad_SearchCustomer.jsp").forward(request, response);


        }

        else if(type.equals("search")){
            //从数据库读取所有合同,默认显示第一页
            ClientDAO clientdao=new ClientDAO();
            Client client=new Client();

            //查找
            if (request.getParameter("clientName") != null) {
                client.SetName(request.getParameter("clientName"));
            }
            ;
            ArrayList<IEntity> arr = clientdao.GetEntitySet(client);
            ArrayList<Client> clients = new ArrayList<Client>();

            if (arr != null) {
                for (int i = 0; i < arr.size(); i++) {
                    Client client1=(Client)(new ClientDAO().GetOneEntity(((Client) arr.get(i)).GetId()));
                    //Contract contract = (Contract) (new ContractDAO().GetOneEntity(((OperateFlow) arr.get(i)).getContractNo()));
                    clients.add(client1);
                }
            }
            request.setAttribute("clients",clients);
            request.getRequestDispatcher("ad_SearchCustomer.jsp").forward(request, response);


   }else if(type.equals("modify_submit")){
            Integer id=Integer.parseInt(request.getParameter("id"));
            String NewClientName=request.getParameter("customerName");
            String NewTel=request.getParameter("phone");
            String NewFax=request.getParameter("fax");
            String NewAddress=request.getParameter("address");
           // String NewPostCode=request.getParameter("NewPostCode");
            String NewBankName=request.getParameter("bankName");
            String NewBankAccount=request.getParameter("bankAccount");
            if(id!=null){
                ClientDAO clientDao=new ClientDAO();
                Client client=(Client)clientDao.GetOneEntity(id);

                client.SetName(NewClientName);
                client.SetTel(NewTel);
                client.SetFax(NewFax);
               // client.SetPostCode(NewPostCode);
                client.SetBankName(NewBankName);
                client.SetBankAccount(NewBankAccount);
                client.SetAddress(NewAddress);

                if(clientDao.UpdateEntity(client)){
                    SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

                    out.write("修改成功");
                }else
                    out.write("修改失败");

            }else
                out.write("修改失败");
        }else if(type.equals("delete")){
            //注意：删除客户时  我们只删除客户本身，不删除其他，跟我们之前说的不太一样
            Integer id=Integer.parseInt(request.getParameter("id"));
            ClientDAO clientDao=new ClientDAO();
            Client client=(Client)clientDao.GetOneEntity(id);
            if(clientDao.DeleteEntity(client)){
                SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
               out.write("删除成功!");
            }else{
                out.write("删除失败!");
            }

        }else if(type.equals("add")){


            String NewClientName=request.getParameter("NewClientName");
            String NewTel=request.getParameter("NewTel");
            String NewFax=request.getParameter("NewFax");
           // String NewPostCode=request.getParameter("NewPostCode");
            String NewBankName=request.getParameter("NewBankName");
            String NewBankAccount=request.getParameter("NewBankAccount");
            String NewAddress=request.getParameter("NewAddress");

            ClientDAO clientDao=new ClientDAO();
            Client client=new Client();
            client.SetName(NewClientName);
            if(clientDao.GetOneEntity(client)==null){

                client.SetName(NewClientName);
                client.SetTel(NewTel);
                client.SetFax(NewFax);
                client.SetAddress(NewAddress);
                // client.SetPostCode(NewPostCode);
                client.SetBankName(NewBankName);
                client.SetBankAccount(NewBankAccount);

                if(clientDao.AddEntity(client)){
                    SimpleDateFormat currTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    out.write("添加客户成功!");
                }else{
                    out.write("添加客户失败!");
                }

            }else{
                out.write("客户已存在！");
            }
        }
    }

}
