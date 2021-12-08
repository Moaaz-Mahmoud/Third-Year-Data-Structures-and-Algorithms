package com.company;

public class Main {

    public static void main(String[] args) {
        /*
                                               +
                                             1   5
         */
        BTNode<String> root1 = new BTNode<String>(
                "+",
                new BTNode<String>("1", null, null),
                new BTNode<String>("5", null, null)
        );
        /*
                                                    +
                                               *          *
                                             5   3      5   3

         */
        BTNode<String> root2 = new BTNode<String>(
                "+",
                new BTNode<String>(
                        "*",
                        new BTNode<String>("5", null, null),
                        new BTNode<String>("3", null, null)
                ),
                new BTNode<String>(
                        "*",
                        new BTNode<String>("5", null, null),
                        new BTNode<String>("3", null, null)
                )
        );
        System.out.println(new ExpressionTree(root1).evaluate());
        System.out.println(new ExpressionTree(root2).evaluate());
    }
}
