package com.company;

public class DoubleLinkedSequence {
    private Node head;
    private Node currentNode;
    private boolean currentElementStatus;
    /**
     * Initialize an empty sequence.
     * @post This sequence is empty.
     */
    public DoubleLinkedSequence(){
        head = currentNode = null;
        currentElementStatus = false;
    }
    /**
     * Adds a new element to this sequence after the current element.
     * @param element  the new element that is being added.
     * @post If there was no current element, addAfter places the new element at the end of the sequence.
     *       The new element always becomes the new current element of the sequence.
     * @throws OutOfMemoryError  Indicates insufficient memory for a new node.
     */
    public void addAfter(double element) {
        Node newNode = new Node(element, currentNode.getLink());
        currentNode.setLink(newNode);
        currentNode = currentNode.getLink();
    }
    /**
     * Adds a new element to this sequence before the current element.
     * @param element  the new element that is being added.
     * @post  A new copy of the element has been added to this sequence. If there was a current element,
     *        addAfter places the new element after the current element.
     * @throws OutOfMemoryError  Indicates insufficient memory for a new node.
     */
    public void addBefore(double element){
        Node ctrl = head;
        for(; ctrl != null && ctrl.getLink() != currentNode; ctrl = ctrl.getLink());
        Node newNode = new Node(element, currentNode);
        ctrl.setLink(newNode);
    }
    /**
     * Place the contents of another sequence at the end of this sequence.
     * @param addend  a sequence whose contents will be placed at the end of this sequence.
     * @pre  The parameter, addend, is not null.
     * @post  The elements from addend have been placed at the end of this sequence. The current element
     *        of this sequence remains where it was, and the addend is also unchanged.
     * @throws NullPointerException  Indicates that addend is null.
     * @throws OutOfMemoryError  Indicates insufficient memory to increase the size of the sequence.
     */
    public void addAll(DoubleLinkedSequence addend){
        while (currentNode.getLink() != null) currentNode = currentNode.getLink();
        Node ctrlA = addend.head;
        Node ctrlT = head;
        while(ctrlA != null){
            ctrlT.setLink(new Node(ctrlA.getData(), null));
            ctrlT = ctrlT.getLink();
        }
    }
    /**
     * Move forward so that the current element is now the next element in the sequence.
     * @pre  isCurrent( ) returns true.
     * @post If the current element was already the end element of the sequence (with nothing after it),
     *       then there is no longer any current element. Otherwise, the new element is the element
     *       immediately after the original current element.
     * @throws IllegalStateException  Indicates that there is no current element, so advance may not be called.
     */
    public void advance(){
        if(currentNode == null)
            throw new IllegalStateException("currentNode was null");
        currentNode = currentNode.getLink();
        if(currentNode == null) currentElementStatus = false;
    }
    /**
     * Generate a copy of this sequence.
     * Returns  The return value is a copy of this sequence. Subsequent changes to the copy will not affect
     *          the original, nor vice versa. The return value must be typecast to a DoubleLinkedSeq before
     *          it is used.
     * @throws OutOfMemoryError  Indicates insufficient memory for creating the clone.
     */
    public Object clone(){
        DoubleLinkedSequence copySequence = new DoubleLinkedSequence();
        for(Node ctrl = head; ctrl != null; ctrl = ctrl.getLink()){
            copySequence.addAfter(ctrl.getData());
        }
        return copySequence;
    }

}
