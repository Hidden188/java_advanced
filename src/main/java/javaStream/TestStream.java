package javaStream;

import myUtils.UtilMisc;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {
        Map<String, Object> tempMap = UtilMisc.toMap("fileId", "123", "fileName", "jfia", "supplierFactory", "1000", "supplierFactoryName", "供应商0");
        Map<String, Object> tempMap2 = UtilMisc.toMap("fileId", "123", "fileName", "jfiaaaaa", "supplierFactory", "1000", "supplierFactoryName", "供应商1");
        Map<String, Object> tempMap3 = UtilMisc.toMap("fileId", "123", "fileName", "jfiaaaaaaaaa", "supplierFactory", "1001", "supplierFactoryName", "供应商2");
        Map<String, Object> tempMap4 = UtilMisc.toMap("fileId", "234", "fileName", "jfiaaaaaaaaaaaaaa", "supplierFactory", "1000", "supplierFactoryName", "供应商3");
        Map<String, Object> tempMap5 = UtilMisc.toMap("fileId", "234", "fileName", "jfiaaaaaaaaaaaaaa", "supplierFactory", "1000", "supplierFactoryName", "供应商4");
        List<Map<String, Object>> list = UtilMisc.toList(tempMap, tempMap2, tempMap3, tempMap4, tempMap5);
        System.out.println("list原来的值" + list.toString());
        // 截取特定元素、去重、统计个数
        long l = list.stream().map(d -> d.get("fileId")).distinct().count();
        System.out.println("list的长度：" + l);
        // 双重分组
        Map<Object, Map<Object, Long>> list2 = list.stream().collect(Collectors.groupingBy(d -> d.get("fileId"), Collectors.groupingBy(d -> d.get("supplierFactory"), Collectors.counting())));
        System.out.println("list分组之后的值：" + list2.toString());
    }

}