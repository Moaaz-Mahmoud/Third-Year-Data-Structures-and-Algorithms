package com.company;

class ArraySequenceTester{
    public static void runTests(){
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
        System.out.print("\n\n______________________________\n\n");

        try {
            System.out.print(A.getCurrent());
        }
        catch (IllegalStateException e) {
            System.out.print(e.getStackTrace());
            System.out.print(e.getMessage());
        }
        System.out.print("\n\n______________________________\n\n");

        B = A.clone();
        for(B.start(); B.isCurrent(); B.advance()){
            System.out.println(B.getCurrent());
        }
        System.out.print("\n\n______________________________\n\n");

        DoubleArraySequence C = DoubleArraySequence.concatenation(A, B);
        for(C.start(); C.isCurrent(); C.advance()){
            System.out.println(C.getCurrent());
        }
        System.out.print("\n\n______________________________\n\n");

        A.trimToSize();
        System.out.print(A.size());
        System.out.print("\n\n______________________________\n\n");
    }
}
class LinkedSequenceTester{
    public static void test1(){
        DoubleLinkedSequence A = new DoubleLinkedSequence();
        A.start();
        A.addAfter(2);
        A.addAfter(20);
        A.addAfter(200);
    }
    public static void test2(){
        DoubleLinkedSequence A = new DoubleLinkedSequence();
        A.addBefore(2);
        A.addBefore(20);
        A.addBefore(200);
    }
    public static void test3(){
        DoubleLinkedSequence A = new DoubleLinkedSequence();
        A.addBefore(2);
        A.addAfter(20);
        A.addBefore(3);
        A.addAfter(30);
        A.addBefore(4);
        A.addAfter(40);
    }
    public static void test4(){
        DoubleLinkedSequence A = new DoubleLinkedSequence();
        DoubleLinkedSequence B = new DoubleLinkedSequence();
        A.addAfter(1); A.addAfter(2); A.addAfter(3);
        B.addAfter(1); B.addAfter(2); B.addAfter(3);
        A.addAll(B);
        System.out.print("A");
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedSequenceTester.test4();
    }
}
