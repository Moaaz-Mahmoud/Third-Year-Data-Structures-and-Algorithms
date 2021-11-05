package com.company;

public class Location {
    public enum Axis {x, y, z}

    private double x;
    private double y;
    private double z;

    public Location(){
        x = y = z = 0;
    }
    public Location(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }

    public void setLocation(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
    }
    public void shift(Axis axis, double amount){
        switch (axis){
            case x -> this.x += amount;
            case y -> this.y += amount;
            case z -> this.z += amount;
        }
    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}
    public void rotate(Axis axis, double theta){
        if(axis == Axis.x){
            y = y * Math.cos(theta) - z * Math.sin(theta);
            z = y * Math.sin(theta) + z * Math.cos(theta);
        }
        else if(axis == Axis.y){
            x = x * Math.cos(theta) + z * Math.sin(theta);
            z = -x * Math.sin(theta) + z * Math.cos(theta);
        }
        else{
            x = x * Math.cos(theta) - y * Math.sin(theta);
            y = x * Math.sin(theta) + y * Math.cos(theta);
        }
    }

    public String toString(){
        return new String("(" + x + ", " + y + ", " + z + ")");
    }
}
