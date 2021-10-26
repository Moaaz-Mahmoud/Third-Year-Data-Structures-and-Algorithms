package com.company;

public class Main {

    public static void main(String[] args) {
        QuadraticExpression q1 = new QuadraticExpression(), q2 = new QuadraticExpression();
        q1.display();   //0 0 0
        q1.setCoefficients(1, -3, 5);
        q2.setCoefficients(1, 4,-7);
        QuadraticExpression q3 = QuadraticExpression.sum(q1, q2);
        q3.display();   //2 1 -2
        var q4 = QuadraticExpression.scale(0.5 ,q3);
        q4.display();   //1 0.5 -1
    }
}
