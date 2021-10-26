package com.company;

public class QuadraticExpression {
    Double a;
    Double b;
    Double c;

    public QuadraticExpression(){
        a = b= c = 0.0;
    }
    public double evaluate(double x){
        return a*x*x + b*x + c;
    }
    public void setCoefficients(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static QuadraticExpression sum(QuadraticExpression q1, QuadraticExpression q2){
        QuadraticExpression q = new QuadraticExpression();
        q.setCoefficients(q1.a + q2.a, q1.b+q2.b, q1.c+q2.c);
        return q;
    }
    public static QuadraticExpression scale(double r, QuadraticExpression q){
        QuadraticExpression newQ = new QuadraticExpression();
        newQ.setCoefficients(r*q.a, r*q.b, r*q.c);
        return newQ;
    }
    public void display() {
        System.out.println(a + "x^2 + " + b + "x + " + c);
    }
}
