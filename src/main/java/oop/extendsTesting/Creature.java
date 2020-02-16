package oop.extendsTesting;

public class Creature {
    {
        System.out.println("Creature的非静态初始化块");
    }
    static {
        System.out.println("Creature的静态初始化块,我是最先运行的");
    }

    public Creature() {
        System.out.println("Creature无参数的构造器");
    }

    public Creature(String name) {
        this();
        System.out.println("Creature带有name参数的构造器，name参数：" + name);
    }
}
