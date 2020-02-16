package oop.extendsTesting;

public class Wolf extends Animal {
    {
        System.out.println("Wolf的非静态初始化块");
    }
    static {
        System.out.println("Wolf的静态初始化块，我是第三个运行的");
    }

    public Wolf() {
        //super("灰太狼", 3);
        System.out.println("Wolf的无参数的构造器");
    }

    public Wolf(double weight) {
        this();
        System.out.println("Wolf的带weight参数的构造器，weight参数：" + weight);
    }
}
