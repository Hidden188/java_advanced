package oop;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AdvanceTest {
	static String classVariable = "���������";
	String instanceVaribale = "����ʵ������";

	public static void main(String[] args) throws IOException  {
		AdvanceTest adTest = new AdvanceTest();
		//dataType();
		//adTest.variableAndConstant();
		//variableAndConstant();
		//classNumber();
		//stringType();
		//arrary();
		//dateType();
		//javaSkills();
		//regularExpression();
		iOBuffer();
	}
	
	/**********************************2 ��������**********************************/
	static void dataType() {	
		System.out.println(Long.SIZE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println((double)Long.MAX_VALUE );
		System.out.println("==========================");
		System.out.println(012);
		System.out.println(0x12);
	}
	
	/**********************************3 �����ͳ���**********************************/
	private static void variableAndConstant() {
		int a, b, c;         // ��������int��������a�� b��c
		int d = 3, e = 4, f = 5; // �������������������ֵ
		byte z = 22;         // ��������ʼ�� z
		String s = "runoob";  // ��������ʼ���ַ��� s
		double pi = 3.14159; // ������˫���ȸ����ͱ��� pi
		char x = 'x';        // �������� x ��ֵ���ַ� 'x'��
		/** kinds of variable
		 *  ������������ڷ���֮�⣬��static����
		 *  ʵ�������������ڷ���֮�⣬û��staic���Σ�static���ͷ�������ֱ��ʹ��
		 *  �ֲ��������෽���еı���
		 */
		AdvanceTest adTest = new AdvanceTest();
		String localVariable = "���Ǿֲ�����";
		System.out.println("�����" + classVariable);
		System.out.println("ʵ������" + adTest.instanceVaribale);
		System.out.println("�ֲ�����" + localVariable);
	}
	
	/**********************************4���η�**********************************/
	final String finalVariable = "���ǳ���";
	private static void modifier() {
		/** kinds of modifier
		 * 1 �������η�
		 * public���������඼�ɼ����ࡢ�ӿڡ�����������
		 * default��ͬһ���������е���ɼ����ࡢ�ӿڡ�����������
		 * protected��ͬһ����������ɼ������������������������ࡣ���˽�Ŀ�http://www.runoob.com/w3cnote/java-protected-keyword-detailed-explanation.html
		 * private��ͬһ�����ڿɼ�������ʹ��getter�������ⲿ����ʡ�����������������������
		 * �̳�֮�󣬷�����������ֻ�ܸ��ӿ��������ܸ�����
		 * 
		 * 2 �Ƿ������η�
		 * static�����γ����ͷ���
		 * final��ֻ�ܱ���ʼ��һ�Σ������޸ģ�����staticһ�������ೣ�������η���ʱ���Ա�����̳У��������޸ģ�������ʱ���ܱ��̳�
		 * abstract�������࣬����ʵ�������������������ΨһĿ����Ϊ�˶Ը���������䣬���ܺ�finalͬʱʹ�ã����η���ʱ��������ʵ�֣���������Ϊfinal��static���������ʵ�����и�������
		 * synchronized�����η���ʱ��һ��ʱ��ֻ�ܱ�һ���̷߳���
		 * transient�����л��Ķ�������� transient ���ε�ʵ������ʱ��java �����(JVM)�������ض��ı����������η������ڶ������������У�����Ԥ������ͱ������������͡�
		 * volatile�����εĳ�Ա������ÿ�α��̷߳���ʱ����ǿ�ƴӹ����ڴ������¶�ȡ�ó�Ա������ֵ�����ң�����Ա���������仯ʱ����ǿ���߳̽��仯ֵ��д�������ڴ档�������κ�ʱ�̣�������ͬ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��һ�� volatile �������ÿ����� null��
		 */
		System.out.println("�������η�&�Ƿ������η�");
	}
	
	/**********************************5�����**********************************/
	private static void operationalCharacter() {
		/** kinds of operational Character
		 * �����������+ - * % / ++ --
		 * ��ϵ����� ��== != > < <= >=
		 * λ����� ��& | ^ ~ << >> >>>
		 * �߼������ ��&& || !
		 * ��ֵ�������= += -= *= /= (%)= <<= &= ^= |=
		 * ��������� ��?: instanceof 
		 */
		System.out.println("");
	}
	
	/**********************************6Number��**********************************/
	static void classNumber() {
		/** kinds of number
		 * ����ʱ�Ǳ���װ�䣬����ʱ�Ǳ�������
		 */
		double i = 8.4;
		long a = -100;
		long b = 98;
		System.out.println(Math.PI);
		System.out.println(Math.E);
		System.out.println(Math.abs(a));
		//System.out.println(Math.addExact(a, b));
		System.out.println(Math.asin(1));
		System.out.println(Math.round(i));
	}
	
	/**********************************7ת���ַ�**********************************/
	/** escape character
	 * \t ����tab��
	 * \b ������˼�
	 * \n ����
	 * \r �س�
	 * \f ��ҳ��
	 * \' ������
	 * \" ˫����
	 * \\ ��б��
	 */
	
	/**********************************8�ַ���**********************************/
	static void stringType() {
		/** kinds of String
		 * 
		 * 
		 */
		String testStr = "String ���ṩ�����������ַ����ķ�����";
		testStr.trim();
		
		String str = "b";
		StringBuffer strb = new StringBuffer("b");
		StringBuilder strbd = new StringBuilder("b"); 
		int i = 0;
		int j = 100000;
		long startTime;
		long endTime;
		startTime = new Date().getTime();
		while (i < j) {
			str += "b";
			i++;
		}
		endTime = new Date().getTime();
		System.out.println(endTime - startTime);
		//System.out.println(str);
		
		startTime = new Date().getTime();
		while (i < j) {
			strb.append("b");
			i++;
		}
		endTime = new Date().getTime();
		System.out.println(endTime - startTime);
		//System.out.println(strb);
		
		startTime = new Date().getTime();
		while (i < j) {
			strbd.append("b");
			i++;
		}
		endTime = new Date().getTime();
		System.out.println(endTime - startTime);
		//System.out.println(strbd);
	}
	
	/**********************************9����**********************************/
	static void arrary() {
		/** arrary
		 * ����������� http://www.codeceo.com/article/10-java-array-method.html
		 * 
		 */
		String[][] arrStr = {{"a","b","c"},{"d","e","f"}};
		System.out.println(arrStr.length);
		int [] num = {3,4,56,2};
		System.out.println(num);
	}
	
	/**********************************10����ʱ��**********************************/
	@SuppressWarnings("deprecation")
	static void dateType() {
		/** 
		 * 
		 */
		Date nowDate = new Date();
		System.out.println("java.util.Date��" + '\t' + nowDate);
		Date firstDate = new Date(118,0,7); // ��һ�֣�Fri May 25 11:23:24 CST 2018
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(ft.format(nowDate)); // ��ʽ��Ϊ��2018-5-25 11:23:24
		System.out.println(firstDate.toLocaleString());
		System.out.println(Locale.US);
		long timeMills1 = System.currentTimeMillis();
		System.out.println(timeMills1); // �ڶ��֣�1527218604476
		System.out.println(ft.format(timeMills1));
		long timeMills2 = System.currentTimeMillis();
		System.out.println(timeMills2-timeMills1);
		/***********************Calendar��**************************/
		System.out.println("/******************Calendar��**********/");
		Calendar c = Calendar.getInstance();
		System.out.println(c.getWeeksInWeekYear());
		c.set(2017, 2, -8);
		System.out.println(c.get(Calendar.DATE));
	}
	
	/*******************************java����С��**********************/
	private static void javaSkills() {
		String str = "";
		str = "99";
		System.out.println(str.indexOf(0)); // -1
		int num = 0;
		if (5 == num) {
			
		}
		String[] arr = null;
		System.out.println(arr != null);
	}
	
	/*******************************11������ʽ**********************/
	private static void regularExpression() {
		String content = "my name is hidden ma";
		String con = ".*dde.*";
		String con2 = "dde";
		boolean isMatch = Pattern.matches(con, content);
		System.out.println(isMatch);
		System.out.println(content.contains(con2));

		// ��ָ��ģʽ���ַ�������
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(\\D*)(\\d+)(.*)";
		// ���� Pattern ����
		Pattern r = Pattern.compile(pattern);
		// ���ڴ��� matcher ����
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			//System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
	}
	
	/*******************************12IO��**********************/
	private static void iOBuffer() throws IOException {
		int b;
		b = 'A';
		System.out.write(b);
		System.out.write('\n');
		char c;
		// ʹ��system.in����BufferdReader
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("please insert character");
		do {
			c = (char) br.read();
			System.out.println(c);
		} while(c!='q');*/
		
		//InputStream f = new FileInputStream("D:/WPS Office/10.1.0.5973/office6/Readme.txt");
		File f = new File("D:/WPS Office/10.1.0.5973/office6/Readme.txt");
		InputStream out = new FileInputStream(f);
		System.out.println(f.toString());
		
		String dirName = "/temp/user2/itsmystory222";
		File d = new File(dirName);
		File[] folds = d.listFiles();
		System.out.println(d.mkdirs());
		if(folds != null) {
			for(File fil : folds) {
				fil.delete();
			}
		}
		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) {
			System.out.println("print:" + scan.next());
		}
		if ("cl".equals(scan.next())) {
			scan.close();
		}
		int a[] = new int[2];
		try {
			System.out.println(a[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�������鳤�ȴ���");
		} finally {
			System.out.println(a);
		}
	}
	
}
