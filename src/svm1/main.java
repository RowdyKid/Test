package svm1;



import java.io.IOException;

public class main {

/**

* @param args

* @throws IOException

*/

public static void main(String[] args) throws IOException {

    // TODO Auto-generated method stub
    String train="D:\\aa\\JDT11.txt";
    String model="D:\\aa\\model_r.txt";
    String test="D:\\aa\\PDE.txt";
    String out="D:\\aa\\out.txt";
    int buggy=0;
    file f=new file();
    String[] arg = { train, model }; // ���SVMͨ��ѵ������ѵ/ //��������ģ�͵�·��

    String[] parg = { test, model, out}; // ���ɵĽ�����ļ���·��

    System.out.println("........SVM���п�ʼ..........");

    // ����һ��ѵ������

    svm_train t = new svm_train();

    // ����һ��Ԥ����߷���Ķ���

    svm_predict p = new svm_predict();

    t.main(arg); // ����

    p.main(parg); // ����

    buggy=f.readFile02(out);

    System.out.println("��Ԥ�⼯ȱ�ݸ���Ϊ"+buggy);

    }

}
