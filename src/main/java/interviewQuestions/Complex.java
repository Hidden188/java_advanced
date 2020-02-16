package interviewQuestions;

public class Complex implements Cloneable {

    private double realPart;
    private double imaginaryPart;
    
    public static void main(String[] args) {
        Complex a = new Complex(4, 5);
        Complex b = new Complex(2, 9);
        System.out.println(a.toString());
        System.out.println(a.add(b).toString());
        System.out.println(a.decrease(b).toString());
        System.out.println(a.multiply(b).toString());
        System.out.println(a.divide(b).toString());
    }

    public Complex() {
        this.realPart = 0.0;
        this.imaginaryPart = 0.0;
    }
    
    public Complex(double a, double b) {
        this.realPart = a;
        this.imaginaryPart = b;        
    }
    
    public double getRealPart() {
        return realPart;
    }
    
    public double getImaginaryPart() {
        return imaginaryPart;
    }
    
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }
    
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    
    // 加法
    public Complex add(Complex aComNum) {
        if (aComNum == null) {
            System.out.println("can not be null!");
            return new Complex();
        }
        return new Complex(this.realPart + aComNum.getRealPart(), this.imaginaryPart + aComNum.getImaginaryPart());
    }
    
    // 减法
    public Complex decrease(Complex aComNum) {
        if (aComNum == null) {
            System.out.println("can not be null!");
            return new Complex();
        }
        return new Complex(this.realPart - aComNum.getRealPart(), this.imaginaryPart - aComNum.getImaginaryPart());
    }
    
    // 乘法
    public Complex multiply(Complex aComNum) {
        if (aComNum == null) {
            System.out.println("can not be null!");
            return new Complex();
        }
        double newRealPart = this.realPart * aComNum.realPart - this.imaginaryPart;
        double newImaginaryPart = this.realPart * aComNum.imaginaryPart + this.imaginaryPart * aComNum.realPart;
        return new Complex(newRealPart, newImaginaryPart);
    }
    
    // 除法
    public Complex divide(Complex aComNum) {
        if (aComNum == null) {
            System.out.println("can not be null!");
            return new Complex();
        }
        double temp = aComNum.getRealPart() * aComNum.getRealPart() + aComNum.getImaginaryPart() * aComNum.getImaginaryPart();
        double newRealPart = (this.realPart * aComNum.getRealPart() + this.imaginaryPart * aComNum.getImaginaryPart()) / temp;
        double newImaginaryPart = (this.imaginaryPart * aComNum.getRealPart() - this.realPart * aComNum.getImaginaryPart()) / temp;
        return new Complex(newRealPart, newImaginaryPart);
    }
    
    // 复数转换成字符串
    public String toString() {
        return this.realPart + "+" + this.imaginaryPart + "i";
    }
    
    // 比较两个复数对象的值是否相等的方法
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Complex) {
            Complex para = (Complex) obj;
            if ((this.realPart == para.realPart) && (this.imaginaryPart == para.imaginaryPart)) {
                return true;
            }
        }
        return false;
    }
    
    // 根据现有对象克隆一个对象
    public Object clone() {
        try {
            Complex newObj = (Complex) super.clone();
            newObj.setRealPart(this.realPart);
            newObj.setImaginaryPart(this.imaginaryPart);
            return newObj;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
