package myUtils;

public class Test {

	public static void main(String[] args) {
		List dll = new List();
		// 添加
		dll.add(2);
		dll.add(true);
		dll.add('f');
		dll.add("G");
		System.out.println(dll);
		
		// 添加到最前面
		dll.addFirst("C");
		System.out.println(dll);
		
		// 添加到最后面
		dll.addLast("B");
		System.out.println(dll);
		
		// 添加到指定位置
		dll.add(5, "A");
		System.out.println(dll);
		
		// 移除最前面的
		dll.removeFirst();
		System.out.println(dll);
		
		// 移除最后面的
		dll.removeLast();
		System.out.println(dll);
		
		// 移除指定位置的
		dll.remove(2);
		System.out.println(dll);
	}

}
