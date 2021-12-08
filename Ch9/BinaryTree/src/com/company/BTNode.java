package com.company;

public class BTNode<E> {
    E data;
    BTNode<E> LeftNode;
    BTNode<E> RightNode;
    public BTNode(E data,BTNode<E> LeftNode,BTNode<E> RightNode)
    {
        this.data=data;
        this.LeftNode=LeftNode;
        this.RightNode=RightNode;
    }
    public E getData(){
        return data;
    }
    public BTNode<E> getLeftNode(){
        return LeftNode;
    }
    public BTNode<E> getRightNode(){
        return RightNode;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeftNode(BTNode<E> leftNode) {
        LeftNode = leftNode;
    }

    public void setRightNode(BTNode<E> rightNode) {
        RightNode = rightNode;
    }

    public E getLeftMostData(){
       if(LeftNode==null)
           return data;
       else
           return LeftNode.getLeftMostData();
    }
    public E getRigthMostData(){
        if(RightNode==null)
            return data;
        else
            return RightNode.getRigthMostData();
    }
    public boolean IsLeaf(){
        return ((LeftNode==null)&&(RightNode==null));
    }
    public BTNode<E> RemoveMostLeft(){
        if(LeftNode==null)
            return RightNode;
        else {
            LeftNode=LeftNode.RemoveMostLeft();
            return this;
        }
    }
    public static <E> BTNode<E> CopyTree (BTNode<E>  Tree)
    {
        BTNode<E> LeftCopy,RightCopy;
        if(Tree==null)
            return null;
        else
        {
            LeftCopy=CopyTree(Tree.LeftNode);
            RightCopy=CopyTree(Tree.RightNode);
            return new BTNode<E>(Tree.data,LeftCopy,RightCopy);
        }

    }
    public void PreOrderPrint(){
            System.out.println(data);
        if(LeftNode!=null)
            LeftNode.PreOrderPrint();
        if(RightNode!=null)
            RightNode.PreOrderPrint();
    }
    public void InOrderPrint(){
        if(LeftNode!=null)
            LeftNode.InOrderPrint();
        System.out.println(data);
        if(RightNode!=null)
            RightNode.InOrderPrint();
    }
    public void PostOrderPrint(){
        if(LeftNode!=null)
            LeftNode.InOrderPrint();
        if(RightNode!=null)
            RightNode.InOrderPrint();
        System.out.println(data);
    }
}
