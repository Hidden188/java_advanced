package oop.circle;

public class Cylinder extends Circle {

    public double getVolume(double r, double h) {
        return super.getArea(r) * h;
    }

}
