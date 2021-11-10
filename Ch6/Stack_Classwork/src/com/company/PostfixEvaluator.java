package com.company;

import java.util.ArrayList;
import java.util.Stack;

public class PostfixEvaluator {
    private PostfixEvaluator(){}

    public static ArrayList<Object> tokenize(String exp){
        exp = new String(exp + " ");
        ArrayList<Object> tokens = new ArrayList<>();
        StringBuilder curToken = new StringBuilder();
        for(char c : exp.toCharArray()){
            if(c == ' '){
                tokens.add(new String(curToken));
                curToken = new StringBuilder("");
            }
            else{
                curToken.append(c);
            }
        }
        return tokens;
    }
    public static double evaluate(ArrayList<Object> tokens){
        Stack<Object> st = new Stack<>();
        for(Object tok : tokens){
            if(Character.isDigit(tok.toString().charAt(0))){

            }
        }
        return 0.0;
    }
}
