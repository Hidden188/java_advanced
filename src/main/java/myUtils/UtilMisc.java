package myUtils;

import org.apache.commons.collections4.map.HashedMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UtilMisc {
        public static <K, V> Map<String, V> toMap(Object... data) {
            if (data.length % 2 == 1) {
                throw new IllegalArgumentException("元素个数必须是偶数");
            }
            Map<String, V> map = new HashedMap<>();
            for (int i = 0; i < data.length; ) {
                map.put((String) data[i++], (V) data[i++]);
            }
            return map;
        }

        public static <T> List<T> toList(T... data) {
            List<T> list = new LinkedList<>();
            for (T t : data) {
                list.add(t);
            }
            return list;
        }
}
