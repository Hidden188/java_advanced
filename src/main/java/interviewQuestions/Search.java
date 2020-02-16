package interviewQuestions;


public class Search {

    static int[] data = {4, 11, 19, 21, 24, 29, 47, 47, 67, 71, 78, 99, 100, 346};
    static int len = data.length;
    
    public static void main(String[] args) {
        if(search(65)) {
            System.out.println();
        } else {
            System.out.println("没有找到");
        }
    }
    
    /**
     * 使用折半查找法的算法，在数组中查询到某个数
     */
    private static boolean search(int k) {
        int left = 0;
        int right = len - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (k < data[middle]) {
                right = middle--;
            } else if (k > data[middle]) {
                left = middle++;
            } else if (k == data[middle]) {
                System.out.println("get it in " + middle);
                return true;
            }
        }
        return false;
    }
}
