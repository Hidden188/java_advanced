package oop;

public class Mouse extends Anmials {

	/**
	 * ��д����:
	 * �����б������ȫ�뱻��д��������ͬ�� 
	 * �������ͱ�����ȫ�뱻��д�����ķ���������ͬ��
	 * ����Ȩ�޲��ܱȸ����б���д�ķ����ķ���Ȩ�޸��͡����磺��������һ������������Ϊpublic��
	 * ��ô����������д�÷����Ͳ�������Ϊprotected�� 
	 * ����ĳ�Ա����ֻ�ܱ�����������д�� 
	 * ����Ϊfinal�ķ������ܱ���д��
	 * ����Ϊstatic�ķ������ܱ���д�������ܹ����ٴ�������
	 * ����͸�����ͬһ�����У���ô���������д�������з�������������Ϊprivate��final�ķ�����
	 * ����͸��಻��ͬһ�����У���ô����ֻ�ܹ���д���������Ϊpublic��protected�ķ�final������
	 * ��д�ķ����ܹ��׳��κη�ǿ���쳣�����۱���д�ķ����Ƿ��׳��쳣�����ǣ���д�ķ��������׳��µ�ǿ�����쳣�����߱ȱ���д���������ĸ��㷺��ǿ�����쳣����֮����ԡ� 
	 * ���췽�����ܱ���д��
	 * ������ܼ̳�һ��������������д���������
	 * 
	 * ���ع���:
	 * �����صķ�������ı�����б�(�������������Ͳ�һ��)��
	 * �����صķ������Ըı䷵�����ͣ� 
	 * �����صķ������Ըı�������η���
	 * �����صķ������������µĻ����ļ���쳣�� 
	 * �����ܹ���ͬһ�����л�����һ�������б����ء� 
	 * �޷��Է���ֵ������Ϊ���غ��������ֱ�׼��
	 * 
	 * �����	���ط���	��д����
		�����б�	�����޸�	һ�������޸�
		��������	�����޸�	һ�������޸�
		�쳣	�����޸�	���Լ��ٻ�ɾ����һ�������׳��µĻ��߸�����쳣
		����	�����޸�	һ�����������ϸ�����ƣ����Խ������ƣ�
	 * 
	 * �ܽ�:
	 * ��������д(Overriding)������(Overloading)��java��̬�ԵĲ�ͬ���֣���д�Ǹ���������֮���̬�Ե�һ�ֱ��֣����ؿ������ɶ�̬�ľ��������ʽ��
	 */
	
	
	
	public Mouse(int thisId) {
		super(thisId);
	}
	
	public static void main(String[] args) {
		int id = 111;
		String food = "sugar";
		Anmials a = new Anmials(id);
		a.eat(food);
		//a.myowner();
		Mouse m = new Mouse(id);
		m.eat(food);
		sleep();
		//m.surg();
		//m.myowner();
	}
	
	public String eat(String food) {
		super.sleep();
		System.out.println("mouse : eat");
		return "mouse eat";
	}
	
	public int eat(String food, String food2) {
		return 111;
	}
	
	public void surg() {
		System.out.println("mouse can surg");
	}
	
	public static void sleep() {
		System.out.println("mouse sleep");
	}
	
	/*public void myowner() {
		System.out.println("mouse owner");
	}*/

}
