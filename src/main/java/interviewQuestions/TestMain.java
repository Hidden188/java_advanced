package interviewQuestions;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.Connection;

public class TestMain {

    public static void main(String[] args) {
        // getStringSum();
        // splitString();
        // getSum();
        // getFactorialSum();
        // getNumber();
        // getOddSum();
        // solveHorsePackTileProblem();
        // getPrimeNumberSum();
        // getNarcissisticNumber();
        // getTotalPeachNumber();
        // getSwopNumber();
        // getDivide7ExactlySum();
        // getYearReachDouble();
        // divideCoin();
        // getRoundSum();
        // getPI();
        // getLCM();
        // Date date = new Date(); System.out.println(date);
        // System.out.println(getDaySequence(date));
        // tisket();
        //hexadecimal();
        //wirteDomTest();
        readDomTest();
    }

    // 输入一串数字字符串，获得所有字符的和
    private static void getStringSum() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += Integer.parseInt(str.valueOf(str.charAt(i)));
        }
        System.out.println("整数是：" + str);
        System.out.println("和为：" + sum);
    }

    // 将String类型的“HelloWorld”拆分成“hello”和“world”输出
    public static void splitString() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        if (str == null || str.isEmpty()) {
            System.out.println("不能为空");
            return;
        }
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tempChar = str.charAt(i);
            if (i != 0 && tempChar >= 'A' && tempChar <= 'Z') {
                newStr.append(" " + tempChar);
            } else {
                newStr.append(tempChar);
            }
        }
        String[] strList = newStr.toString().split(" ");
        System.out.println("您输入的字符串为：" + str + "分解后的单词为：");
        for (int i = 0; i < strList.length; i++) {
            System.out.print(strList[i] + " ");
        }
    }

    // 求和
    public static void getSum() {
        int sum = 0;
        int end = 0;
        for (int i = 1;; i += 2) {
            sum += i;
            if (sum > 2000) {
                sum -= i;
                end = i;
                break;
            }
        }
        System.out.println("和为：" + sum + "最后一个数为：" + end);
    }

    // 求阶乘的和
    public static void getFactorialSum() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (int i = 1; i < 16; i++) {
            BigDecimal numSum = BigDecimal.valueOf(1);
            for (int j = 1; j <= i; j++) {
                numSum = numSum.multiply(BigDecimal.valueOf(j));
            }
            sum = sum.add(numSum);
        }
        System.out.println("和为：" + sum);
    }

    // 找到所有有数字5的三位数
    public static void getNumber() {
        int count = 0;
        for (int i = 100; i < 1000; i++) {
            String iStr = String.valueOf(i);
            if ('5' == iStr.charAt(0) || '5' == iStr.charAt(1) || '5' == iStr.charAt(2)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }

    // 找到所有有数字5的三位数
    public static void getOddSum() {
        int count = 0;
        for (int i = 101; i < 1000; i += 1) {
            int firstNum = i / 100;
            int secondNum = (i / 10) % 10;
            int thirdNum = i % 10;
            if (firstNum == secondNum * thirdNum) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }

    // 百马百瓦问题。大、小、马驹共100匹，驮100片瓦，大马一驮三，小马一驮二，马驹二驮一，一次驮完，三种马都用，共有多少种组合
    public static void solveHorsePackTileProblem() {
        for (int i = 1; i <= 98; i++) {
            for (int j = 2; j <= 98; j += 2) {
                int k = 100 - i - j;
                if (k <= 0) {
                    break;
                }
                if (3 * i + j / 2 + 2 * k == 100) {
                    System.out.println(i + " " + k + " " + j);
                }
            }
        }
    }

    // 第18题：找到质数
    public static void getPrimeNumberSum() {
        System.out.println("2 3 5");
        // classic method
        for (int i = 7; i <= 1000; i += 2) {
            boolean isContinue = true;
            for (int j = 2; j <= Math.sqrt(i); j++) { // 当j小于根号i的时候，继续循环。
                if (i % j == 0) {
                    isContinue = false;
                    break;
                }
            }
            if (isContinue) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        // advance method
        for (int num = 7; num < 1000; num += 2) {
            // 不在6的倍数两侧的一定不是质数
            if (num % 6 == 1 || num % 6 == 5) {
                boolean isPrime = true;
                int tmp = (int) Math.sqrt(num);
                // 在6的倍数两侧的也可能不是质数
                for (int i = 5; i <= tmp; i += 6) {
                    // 判断是否有质数为这个数的公约数
                    if (num % i == 0 || num % (i + 2) == 0) {
                        isPrime = false;
                        break;
                    }
                }
                // 排除所有，剩余的是质数
                if (isPrime) {
                    System.out.print(num + " ");
                }
            }
        }
    }

    // 列出水仙花数
    public static void getNarcissisticNumber() {
        for (int i = 100; i < 1000; i++) {
            int firstN = i / 100;
            int secondN = (i % 100) / 10;
            int thirdN = (i % 100) % 10;
            if (firstN * firstN * firstN + secondN * secondN * secondN + thirdN * thirdN * thirdN == i) {
                System.out.println(i);
            }
        }
    }

    // 猴子每天吃半数桃子
    public static void getTotalPeachNumber() {
        int num = 1;
        for (int i = 10; i > 1; i--) {
            num = (num + 1) * 2;
        }
        System.out.println(num);
    }

    // 求出一个两位数，与46的和等于，其对调数和64的和
    public static void getSwopNumber() {
        for (int i = 10; i < 100; i++) {
            int j = i / 10 + (i % 10) * 10;
            if (46 + i == 64 + j) {
                System.out.println(i);
            }
        }
    }

    // 200以内能被7整除的数的平方和
    public static void getDivide7ExactlySum() {
        int sum = 0;
        int i = 7;
        while (i < 200) {
            sum += i * i;
            i += 7;
        }
        System.out.println(sum);

        double sum2 = 0;
        for (int ii = 1; ii < 100; ii++) {
            sum2 += Math.sqrt(ii);
        }
        BigDecimal sum2B = BigDecimal.valueOf(sum2);
        System.out.println(sum2B.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }

    // 获得因数
    public static void getFactorSum() {
        for (int i = 1; i < 200; i++) {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    list.add(j);
                }
            }
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            System.out.println(sum);
        }
    }

    // 国民生产总值为45600亿元，9%的增长率，多少年之后国民生产总值翻一番
    public static void getYearReachDouble() {
        double k = 45600.000;
        double d = 1.09 * k;
        int i = 1;
        while (d < 2 * k) {
            d = Math.pow(1.09, i) * k;
            i++;
        }
        System.out.println("第" + i + "年");
    }

    // 分硬币：一百元的钞票，分成一元、二元、五元的，每种面值至少8枚，一共有几种方案？
    public static void divideCoin() {
        int count = 0;
        for (int i = 8; i <= 44; i++) {
            for (int j = 8; j <= 26; j++) {
                for (int k = 8; k <= 15; k++) {
                    if (i + 2 * j + 5 * k == 100) {
                        count++;
                        System.out.println("一元" + i + "；二元" + j + "；五元" + k);
                    }
                }
            }
        }
        System.out.println("总共有这么多分法：" + count);
    }

    // 计算1+2/3+3/5+4/7+...+n/(2*n-1)(n=50)，将结果四舍五入方式精确到两位小数
    public static void getRoundSum() {
        double sum = 0;
        for (double i = 1.0; i <= 1000; i++) {
            sum += i / (2 * i - 1);
        }
        System.out.println("sum的值为：" + sum);
        String s = String.valueOf(sum);
        if (s.length() - s.indexOf(".") >= 4) {
            String s2 = s.substring(s.indexOf(".") + 3, s.indexOf(".") + 4);
            double d2 = Double.parseDouble(s2);
            if (d2 >= 5) {
                String s1 = s.substring(0, s.indexOf(".") + 3);
                double d1 = Double.parseDouble(s1);
                d1 = (d1 * 100 + 1) / 100;
                s = String.valueOf(d1);
            }
        }
        System.out.println("和为：" + s);
    }

    // 通过pi/4=1-1/3+1/5-1/7+...求出pi（圆周率）的近似值，直到最后一项的绝对值小于指定的数为止
    public static void getPI() {
        double sum = 0.0;
        double flag = 1.0;
        double t = -1;
        for (int i = 2;; i++) {
            sum += (Math.pow(t, i) * (1 / flag)); // sum值是等号右边的和
            flag = 2 * i - 1;
            if (1.0 / flag < 0.0001) {
                break;
            }
        }
        System.out.println("近似值为：" + sum * 4);
    }

    // 键盘输入两个数字，求出它们的最小公倍数
    public static void getLCM() {
        Integer s1 = 0;
        Integer s2 = 0;
        Integer lCM = 1;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("请输入第一个数");
            String str1 = s.nextLine();
            s1 = Integer.parseInt(str1);
            System.out.println("请输入第二个数");
            String str2 = s.nextLine();
            s2 = Integer.parseInt(str2);
            // 求出最小公倍数
            if (s1 == 0 || s2 == 0) {
                System.out.println("0没有最小公倍数");
                return;
            }
            System.out.println(" 第一个数和第二个数的整数部分是：" + s1 + "，" + s2);
            // 较大的为s1
            if (s1 < s2) {
                Integer t = s2;
                s2 = s1;
                s1 = t;
            }
            if (s2 == 1) {
                lCM = s1;
            } else {
                Integer i = 1;
                while (lCM % s2 != 0) {
                    lCM = s1 * i;
                    i++;
                }
            }
            System.out.println("最小公倍数是：" + lCM);
        } catch (NumberFormatException e) {
            System.out.println("结束！必须输入整数！！！");
            System.out.println("重新开始");
            getLCM();
        }
    }

    /**
     * 判断某年某月某日是一年的第几天
     */
    public static int getDaySequence(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        int day = ca.get(Calendar.DAY_OF_MONTH);
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            days[2] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            day += days[i];
        }
        return day;
    }

    public static void tisket() {
        int children = 18;
        int count = 1;
        for (int i = 1; i <= children; i++) {
            if (count % 11 == 0) {
                children--;
                System.out.println("第" + i + "个孩子掉了，" + "还剩余" + children + "个孩子");
                i--;
            }
            if (i == children) {
                i = 0;
            }
            count++;
        }
    }

    // 16进制和10进制转换
    public static void hexadecimal() {
        String str = "14abf";
        int len = str.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(len - 1 - i);
            int n = Character.digit(c, 16);
            sum += n * (1 << (4 * i));
        }
        System.out.println(sum);
        System.out.println(Integer.parseInt(str, 16));
    }

    public static void connectedSQL() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:mysql:thin:@127.0.0.1:school", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from grade");
            while(rs.next()) {
                System.out.println(rs.toString());
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("异常");
        }
    }

    // 解析xml
    public static void wirteDomTest() {
        try {
            javax.xml.parsers.DocumentBuilder docBuilder = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.newDocument();
            org.w3c.dom.Element root = doc.createElement("teacher");
            org.w3c.dom.Element wang = doc.createElement("name");
            org.w3c.dom.Element liu = doc.createElement("age");
            liu.appendChild(doc.createTextNode("我是年龄"));
            wang.appendChild(doc.createTextNode("我是名称"));
            root.appendChild(liu);
            root.appendChild(wang);
            doc.appendChild(root);
            javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING, "gb2312");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.transform(new javax.xml.transform.dom.DOMSource(doc), new javax.xml.transform.stream.StreamResult("D:\\people.xml"));
        } catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
    }
    
    // 读取xml
    public static void readDomTest() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("D:\\people.xml");
            NodeList users = document.getChildNodes();
            for (int i = 0; i < users.getLength(); i++) {
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();
                for (int j = 0; j < userInfo.getLength(); j++) {
                    if (userInfo.item(j).getNodeName() != "#text") {
                        System.out.println(userInfo.item(j).getNodeName() + ":" + userInfo.item(j).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("异常操作");
        }
    }
    
}
