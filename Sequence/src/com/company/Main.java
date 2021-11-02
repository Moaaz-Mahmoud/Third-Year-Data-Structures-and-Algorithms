package com.company;


public class Main {

    public static void main(String[] args) {
        DoubleArraySequence A = new DoubleArraySequence();
        DoubleArraySequence B = new DoubleArraySequence();
        A.addBefore(0);
        A.addBefore(1);
        A.addBefore(2);
        B.addBefore(10);
        B.addBefore(20);
        B.addBefore(30);
        A.addAll(B);
        for(A.start(); A.isCurrent(); A.advance()){
            System.out.println(A.getCurrent());
        }
        try {
            System.out.print(A.getCurrent());
        }
        catch (IllegalStateException e) {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
    }
}
