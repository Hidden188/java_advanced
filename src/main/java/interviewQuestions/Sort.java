package interviewQuestions;

public class Sort {

    public static void main(String[] args) {
        /**
         * 对数组int[] a = {100, 40, 87, 0} 快速排序
         */
        int[] data = {47, 29, 71, 99, 78, 19, 24, 47, 100, 4, 21, 346, 67, 11 };

        // 冒泡排序
        for (int i = 0; i < data.length - 1; i++) {// 控制趟数
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
        System.out.println("11111" + "   "+data[0]+"  "+data[3]);
        data = new int[]{ 100, 40, 87, 0 };
        // 选择排序
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;// 将当前下标定为最小值下标
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = data[i];
                data[i] = data[min];
                data[min] = tmp;
            }
        }
        System.out.println("2222222" + "   "+data[0]+"  "+data[3]);
        data = new int[] { 8, 9, 5, 4, 3, 10, 6, 13 };
        // 快速排序
        quickSort(data, 0, data.length -1);
        System.out.println("33333" + "   "+data[0]+"  "+data[3]);
    }

    // 快速排序
    public static void quickSort(int[] data, int start, int end) {
        // 设置关键数据key为要排序数组的第一个元素，
        // 即第一趟排序后，key右边的数全部比key大，key左边的数全部比key小
        int key = data[start];
        // 设置数组左边的索引，往右移动比key大的数
        int i = start;
        // 设置数组右边的索引，往左移动比key小的数
        int j = end;
        // 如果左边索引比右边索引小，则还有数据没有排序
        while (i < j) {
            while (data[j] > key && j > i) {
                j--;
            }
            data[i] = data[j];
            while (data[i] < key && i < j) {
                i++;
            }
            data[j] = data[i];
        }
        // 此时 i==j
        data[i] = key;
        // 递归调用
        if (i - 1 > start) {
            // 递归调用，把key前面的完成排序
            quickSort(data, start, i - 1);
        }
        if (i + 1 < end) {
            // 递归调用，把key后面的完成排序
            quickSort(data, i + 1, end);
        }
    }
    
}
