package javaReflect;

public class javaClassTest {

    public static void main(String[] args) {
        try {
            Class<?> testCl = Class.forName("javaReflect.TestClass");
            System.out.println("name:" + testCl.getName());
            System.out.println("simpleName:" + testCl.getSimpleName());
            System.out.println("CanonicalName:" + testCl.getCanonicalName());
            System.out.println("superClass:" + testCl.getSuperclass());
            System.out.println("typeName:"+testCl.getTypeName());
            System.out.println("genericString:"+testCl.toGenericString());
            System.out.println("methods:"+testCl.getMethods());
            System.out.println("getClasses:"+testCl.getClasses());
            System.out.println("fields:"+testCl.getFields());
            System.out.println("toString:" + testCl.toString());
            Object testClass = testCl.newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
