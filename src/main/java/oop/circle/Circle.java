package oop.circle;

public class Circle {
    
    double radius;
    double PI = 3.1415926535897932384626;
    
    public double getRadius() {
        return this.radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // 面积
    public double getArea(double r) {
        return PI * r * r;
    }
    
    // 周长
    public double getPerimeter(double r) {
        return 2 * PI * r;
    }
    
}
