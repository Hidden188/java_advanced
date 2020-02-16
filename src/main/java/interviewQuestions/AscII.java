package interviewQuestions;

public class AscII {

    public static void main(String[] args) {
        /**
         * 从一个字符串中查找到每个字符的ASCII码 
         */
        String str = "adsjfgijkWJ%37^^&^&^r%^*&OIEHJFJjfjT^%^&*YUiurhrgio4ouih";
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            int at = 0 + str.charAt(i);
            System.out.println(str.charAt(i) + ":" + at);
            sum = sum + at;
        }
        System.out.println("ASCII码的和为：" + sum);
    }

}
