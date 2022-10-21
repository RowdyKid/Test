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
    String[] arg = { train, model }; // 存放SVM通过训练数据训/ //练出来的模型的路径

    String[] parg = { test, model, out}; // 生成的结果的文件的路径

    System.out.println("........SVM运行开始..........");

    // 创建一个训练对象

    svm_train t = new svm_train();

    // 创建一个预测或者分类的对象

    svm_predict p = new svm_predict();

    t.main(arg); // 调用

    p.main(parg); // 调用

    buggy=f.readFile02(out);

    System.out.println("该预测集缺陷个数为"+buggy);

    }

}
