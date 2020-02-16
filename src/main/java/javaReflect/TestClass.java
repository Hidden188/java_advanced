package javaReflect;

public class TestClass {
    private String name;

    public TestClass() {
    }

    public TestClass(String name) {
        this.name = name;
    }

    static {
        System.out.println("这是类中static代码");
    }

    public static void getStatic() {
        System.out.println("这是static方法");
    }

    public void getMethod() {
        System.out.println("这是非静态方法");
    }
}
