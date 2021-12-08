package com.company;

import java.util.StringTokenizer;

public class ExpressionTree {
    private BTNode<String> root;

    public ExpressionTree(BTNode<String> root){
        this.root = root;
    }
    public double evaluate(){
        return evaluateUtil(root);
    }
    protected double evaluateUtil(BTNode<String> rt){
        if(rt.getLeftNode() == null && rt.getRightNode() == null){
            return Double.parseDouble(rt.getData());
        }

        if(rt.getData() == "+"){
            return evaluateUtil(rt.getLeftNode())
                    + evaluateUtil(rt.getRightNode());
        }
        else if(rt.getData() == "-"){
            return evaluateUtil(rt.getLeftNode())
                    - evaluateUtil(rt.getRightNode());
        }
        else if(rt.getData() == "*"){
            return evaluateUtil(rt.getLeftNode())
                    * evaluateUtil(rt.getRightNode());
        }
        return evaluateUtil(rt.getLeftNode())
                / evaluateUtil(rt.getRightNode());
    }
}
