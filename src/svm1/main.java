package svm1;



import java.io.IOException;

public class main {

/**

* @param args

* @throws IOException

*/

public static void main(String[] args) throws IOException {

// TODO Auto-generated method stub

String[] arg = { "D:\\aa\\JDT11.txt", // ���SVMѵ��ģ���õ����ݵ�·��

"D:\\aa\\model_r.txt" }; // ���SVMͨ��ѵ������ѵ/ //��������ģ�͵�·��

String[] parg = { "D:\\aa\\PDE.txt", // ����Ǵ�Ų�������

"D:\\aa\\model_r.txt", // ���õ���ѵ���Ժ��ģ��

"D:\\aa\\out.txt" }; // ���ɵĽ�����ļ���·��

System.out.println("........SVM���п�ʼ..........");

// ����һ��ѵ������

svm_train t = new svm_train();

// ����һ��Ԥ����߷���Ķ���

svm_predict p = new svm_predict();

t.main(arg); // ����

p.main(parg); // ����

}

}
