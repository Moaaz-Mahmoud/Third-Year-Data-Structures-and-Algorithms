package com.company;

public class Main {

    public static void main(String[] args) {
        Node list = new Node(0, null);
        for(int i = 1; i <= 5; i++)
            list = new Node(i, list);
        Node[] newLists = LinkedListDivider.divide(list, 3);
        for(Node ctrl = newLists[0]; ctrl != null; ctrl = ctrl.getLink())
            System.out.print(ctrl.getData() + " ");
        System.out.println();
        for(Node ctrl = newLists[1]; ctrl != null; ctrl = ctrl.getLink())
            System.out.print(ctrl.getData() + " ");
    }
}
