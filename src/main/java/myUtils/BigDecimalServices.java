package myUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalServices {
	
	public static void main(String[] args) {
		//BigDecimal bdObj = BigDecimal.valueOf(1.22);
		BigDecimal aDouble =new BigDecimal(1.22);
		System.out.println(aDouble);
		BigDecimal bdDou1 = BigDecimal.valueOf(10);
		/*System.out.println(4.0776*0.2);
        BigDecimal bdObj = new BigDecimal(-4.0776);
        System.out.println(bdObj.multiply(new BigDecimal(0.2)));
        System.out.println(bdObj2.multiply(BigDecimal.valueOf(0.2)));
        Double valDou1 = new Double(4.0776);
        Double valDou2 = new Double(3.0224);
        BigDecimal bdDou2 = BigDecimal.valueOf(3);
        System.out.println(bdDou1.divide(bdDou2,10).doubleValue());
        System.out.println("4.0776".toCharArray());
        System.out.println(bdObj.hashCode());
        System.out.println(10-4.07763453456789065678899);*/
		//hashArithmetic("valueName");
        // 方式一
        DecimalFormat df1 = new DecimalFormat("#.000");
        //System.out.println(String.format("%.100f", num));
        /**
         * 
        BigDecimal.setScale()方法用于格式化小数点
		setScale(1)表示保留一位小数，默认用四舍五入方式 
		setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3 
		setScale(1,BigDecimal.ROUND_UP)进位处理，2.35变成2.4 
		setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
		setScaler(1,BigDecimal.ROUND_HALF_DOWN)四舍五入，2.35变成2.3，如果是5则向下舍
		setScaler(1,BigDecimal.ROUND_CEILING)接近正无穷大的舍入
		setScaler(1,BigDecimal.ROUND_FLOOR)接近负无穷大的舍入，数字>0和ROUND_UP作用一样，数字<0和ROUND_DOWN作用一样
		setScaler(1,BigDecimal.ROUND_HALF_EVEN)向最接近的数字舍入，如果与两个相邻数字的距离相等，则向相邻的偶数舍入。
         */
        double num = 784.07758453456789462567655622;
        BigDecimal bd = BigDecimal.valueOf(num);
        double result = bd.setScale(4, BigDecimal.ROUND_CEILING).doubleValue();
        System.out.println(result);
        
        BigDecimal a = new BigDecimal("0.234"); 
        BigDecimal b = new BigDecimal("0.123"); 
        a.add(b); 
        System.out.println(a); 
        
        
	}
	
	public static void hashArithmetic (String name) {
		/** 位运算复习
		 * 
		 *  << : 左移运算符，num << 1,相当于num乘以2  低位补0
			>> : 右移运算符，num >> 1,相当于num除以2  高位补0
			>>> : 无符号右移，忽略符号位，空位都以0补齐
			% : 模运算 取余
			^ : 位异或 第一个操作数的的第n位于第二个操作数的第n位相反，那么结果的第n为也为1，否则为0
			& : 与运算 第一个操作数的的第n位于第二个操作数的第n位如果都是1，那么结果的第n为也为1，否则为0
			| : 或运算 第一个操作数的的第n位于第二个操作数的第n位 只要有一个是1，那么结果的第n为也为1，否则为0
			~ : 非运算 操作数的第n位为1，那么结果的第n位为0，反之，也就是取反运算（一元操作符：只操作一个数）
		 *
		 */
		
		/** hashCode
		 * 
		 * hashMap之所以快，是因为使用散列表，根据key的hashCode生成数组下标，所以CRUD操作十分快，但需要大量空间
		（1）HashCode的存在主要是用于查找的快捷性，如Hashtable，HashMap等，HashCode经常用于确定对象的存储地址；
   		（2）如果两个对象相同， equals方法一定返回true，并且这两个对象的HashCode一定相同；
		（3）两个对象的HashCode相同，并不一定表示两个对象就相同，即equals()不一定为true，只能够说明这两个对象在一个散列存储结构中。
		（4）如果对象的equals方法被重写，那么对象的HashCode也尽量重写。
		
		 */
		Map<String, String> map = new HashMap<>(4);
	    map.put(name, "hell3456789o");
	}
	
	
	
	
	
	
	

}
