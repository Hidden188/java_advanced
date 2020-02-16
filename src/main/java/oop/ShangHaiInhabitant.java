package oop;

public class ShangHaiInhabitant extends Chinese {

    static String location;
    long savings;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eat() {
        // TODO Auto-generated method stub
        super.getClass().toString();
        getClass().getSuperclass().getName();
    }

    @Override
    protected void say() {
        // TODO Auto-generated method stub
        
    }
    
    private static Boolean testSuper() {
        int x = 1;
        return x==1?true:false; 
    }
    
    public static void testInnerClass() {
        class InnerClass2 {
            int grade;
            public void method() {
                System.out.println("innnnnnnnnerClass");
            }
        }
    }
    

}
