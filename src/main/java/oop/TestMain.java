package oop;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		Salary sal = new Salary("Hidden", 100);
		System.out.println(sal.getName());
		sal.setName("MaJian");
		System.out.println(sal.getName());
		Salary.test();
		sal.getSalary();
		String[] testArr = {"ha", "ab", "aqs"};
		genericMethod(testArr);
		System.out.println(maximum(testArr));
		Integer[] numArr = {3, 500, 12, 2, 100};
		System.out.println(maximum(numArr));
		List<String> strList = new ArrayList<String>();
		strList.add("ma");
		strList.add("hh");
		strList.add("ma");
		System.out.println(compare(strList));
		List<Long> lonList = new ArrayList<Long>();
		lonList.add(55l);
		lonList.add(25l);
		lonList.add(25l);
		//lonList.add("hh");
		System.out.println(compare(lonList));
	}

	static <E> void genericMethod (E[] inputArrary) {
		for (E ele : inputArrary) {
			System.out.printf("%s ", ele);
		}
	}
	
	// ʹ�÷��ͱȽ����ֵ
	public static <T extends Comparable<T>> T maximum(T[] inputArrary) {
		T max = inputArrary[0];
		for (T ele : inputArrary) {
			if (ele.compareTo(max) > 0) {
				max = ele;
			}
		}
		return max;
	}
	
	// ʹ��ͨ����Ƚ����ֵ
	public static boolean compare(List<?> inputArrary) {
		Boolean max = false;
		int len = inputArrary.size();
		for (int i = 0; i < len; i++) {
			Object obj1 = inputArrary.get(i);
			for (int j = i + 1; j < len; j++) {
				Object obj2 = inputArrary.get(j);
				if (obj1.equals(obj2)) {
					max = true;
				}
			}
		}
		return max;
	}
	
}
