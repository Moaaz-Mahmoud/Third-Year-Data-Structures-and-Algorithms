package com.company;

public class Main {

    public static void main(String[] args) {
        var exp = PostfixEvaluator.tokenize("2 305 + 32 *");
        for(Object a : exp){
            System.out.println(a.toString());
        }
    }
}
