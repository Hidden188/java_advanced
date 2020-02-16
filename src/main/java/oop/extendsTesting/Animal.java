package oop.extendsTesting;

public class Animal extends Creature {
    {
        System.out.println("Animal的非静态初始化块");
    }
    static {
        System.out.println("Animal的静态初始化块,我是第二个运行的");
    }

    public Animal() {
        System.out.println("Animal无参数的构造器");
    }

    public Animal(String name) {
        super(name);
        System.out.println("Animal带一个参数的构造器，name参数：" + name);
    }

    public Animal(String name, int age) {
        this(name);
        System.out.println("Animal带两个参数的构造器，其age：" + age);
    }

}
