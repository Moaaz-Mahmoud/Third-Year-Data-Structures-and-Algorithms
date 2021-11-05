package com.company;

public class Main {

    public static void main(String[] args) {
        Location l1 = new Location(2, 3, -5.02);
        l1.setLocation(0, 1, 2);
        l1.rotate(Location.Axis.x, Math.PI);
        System.out.println(l1.toString());
    }
}
