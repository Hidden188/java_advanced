package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class ListDelete {

    public static void main(String[] args) {
        /**
         * 将一个泛型中的值等于0的全部去掉，并将剩余的数据存入一个新的数组
         */
        int[] data = new int[] {4, 11, 19, 21, 24, 29, 47, 47, 67, 71, 78, 99, 100};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                list.add(data[i]);
            }
        }
    }

}
