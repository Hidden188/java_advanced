package myUtils;

import java.util.ArrayList;

public class ArrayListCustSort implements Comparable<Object> {

    int age;

    @Override
    public int compareTo(Object o) {
        // 是否符合类
        if (!(o instanceof ArrayListCustSort)) {
            throw new ClassCastException();
        }
        ArrayListCustSort other = (ArrayListCustSort) o;
        return age > other.age ? 1 : age == other.age ? 0 : -1;
    }
    
    ArrayList<Object> datas = new ArrayList<>();    
    public void add(Object obj) {
        for (int i = 0; i < datas.size(); i++) {
            if (((ArrayListCustSort) obj).compareTo(datas.get(i)) != 1) {
                datas.add(i, obj);
            }
        }
    }

}
