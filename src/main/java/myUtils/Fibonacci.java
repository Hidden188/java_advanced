package myUtils;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(circleMe(30));
		
	}
	
	private static int lessThanThree(int n) {
		if (n < 0) {
			System.out.println("请输入正整数");
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return n;
		}
	}
	
	// 递归求解
	public static int recursionMe(int n) {
		if (n < 3) {
			return lessThanThree(n);
		}
		return recursionMe(n-1) + recursionMe(n-2);
	}
	
	// 循环求解
	public static int circleMe(int n) {
		if (n < 3) {
			return lessThanThree(n);
		}
		int fn = 0;
		int f1 = 1;
		int f2 = 1;
		for (int i = 2; i < n; i++) {
			fn = f1 + f2;
			f1 = f2;
			f2 = fn;
		}
		return fn;
	}
	
	long[][] f = new long[][]{{0, 1}, {1, 1}};
	// 矩阵求解
	/*public int getNthNumber1(int n) {
		if (n < 3) {
			return lessThanThree(n);
		}
		f = pow(n, f);
		return (int) f[1][1];
	}
	private long[][] pow(int n, long[][] f) {
		if (n == 1) {
			return f;
		}
		if (n == 2) {
			return fun(f, f);
		}
	}*/
	
	// 公式求解 带根号不能直接运算
	/*public static long expressionMe(int n) {
		if (n < 3) {
			return lessThanThree(n);
		}
		return 
	}*/
	
}
