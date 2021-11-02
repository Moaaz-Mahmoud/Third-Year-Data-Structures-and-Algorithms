package com.company;

public class DoubleLinkedSequence {
    private Node head;
    /**
     * Initialize an empty sequence.
     * @post This sequence is empty.
     */
    public DoubleLinkedSequence(){
        head = null;
    }
    /**
     * Adds a new element to this sequence after the current element.
     * @param element  the new element that is being added.
     * @post If there was no current element, addAfter places the new element at the end of the sequence.
     *       The new element always becomes the new current element of the sequence.
     * @throws OutOfMemoryError  Indicates insufficient memory for a new node.
     */
    public void addAfter(double element) {

    }
    /**
     * Adds a new element to this sequence before the current element.
     * @param element  the new element that is being added.
     * @post  A new copy of the element has been added to this sequence. If there was a current element,
     *        addAfter places the new element after the current element.
     * @throws OutOfMemoryError  Indicates insufficient memory for a new node.
     */
    public void addBefore(double element){

    }
}
