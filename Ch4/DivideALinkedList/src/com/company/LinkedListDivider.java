package com.company;

public class LinkedListDivider {
    private LinkedListDivider(){}

    //The original list gets lost after the function executes.
    public static Node[] divide(Node headOrig, int splitVal){
        Node head1 = null, head2 = null;
        for(; headOrig != null; headOrig = headOrig.getLink()){
            if(headOrig.getData() < splitVal)
                head1 = new Node(headOrig.getData(), head1);
            else
                head2 = new Node(headOrig.getData(), head2);
        }
        return new Node[] {head1, head2};
    }
}
