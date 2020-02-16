package oop.circle;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //Demo001();
        //Demo002();
    }

    public static void Demo001() {
        System.out.println("请输入一个圆的半径");
        double[] d = new double[5];
        for(int i = 0; i <= 4; i++) {
            Scanner sc = new Scanner(System.in);
            d[i] = sc.nextDouble();
        }
        for(int i = 0; i < d.length; i++) {
            Circle c = new Circle();
            double area = c.getArea(d[i]);
            System.out.println("半径为" + d[i] + "的圆面积为：" + area);
        }
    }
    
    public static void Demo002() {
        System.out.println("请输入5个圆柱的底面半径");
        double[] r = new double[5];
        for (int i = 0; i <= 4; i++) {
            Scanner sc = new Scanner(System.in);
            r[i] = sc.nextDouble();
        }
        System.out.println("请输入5个圆柱的高");
        double[] h = new double[5];
        for (int i = 0; i <= 4; i++) {
            Scanner sc = new Scanner(System.in);
            h[i] = sc.nextDouble();
        }
        for (int i = 0; i <= 4; i++) {
            Cylinder c = new Cylinder();
            double volume = c.getVolume(r[i], h[i]);
            System.out.println("半径为" + r[i] + "，高为" + h[i] + "的圆柱的体积为: " + volume);
        }
        
    }
    
    
}
