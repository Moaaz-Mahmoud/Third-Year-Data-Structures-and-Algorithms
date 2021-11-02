package com.company;

/**
 * Implements the Sequence ADT (array-based)
 */
public class DoubleArraySequence {
    private static final Double MAX_VAL = Double.MAX_VALUE;
    private static final Integer DEFAULT_CAPACITY = 10;

    private Double[] buffer;
    private Integer capacity;
    private Integer size;
    private Integer currentIndex;
    private boolean currentElementStatus;

    /**
     * Initialize an empty sequence with an initial capacity of DEFAULT_CAPACITY.
     * @post  This sequence is empty and has an initial capacity of DEFAULT_CAPACITY.
     * @throws OutOfMemoryError  Indicates insufficient memory for new double[10].
     */
    public DoubleArraySequence(){
        try {
            buffer = new Double[DEFAULT_CAPACITY];
        }
        catch (OutOfMemoryError e){
            throw e;
        }
        capacity = DEFAULT_CAPACITY;
        size = 0;
        currentIndex = 0;
        currentElementStatus = false;
    }

    /**
     * Initializes an empty sequence with a specified initial capacity.
     * @param initialCapacity  The initial capacity of this sequence.
     * @pre  `initialCapacity` is non-negative.
     * @post  This sequence is empty and has the given initial capacity.
     * @throws IllegalArgumentException  Indicates that initialCapacity is negative.
     * @throws OutOfMemoryError  Indicates insufficient memory for new double[initialCapacity].
     */
    public DoubleArraySequence(int initialCapacity){
        if(initialCapacity < 0)
            throw new IllegalArgumentException("");
        try {
            buffer = new Double[initialCapacity];
        }
        catch (OutOfMemoryError e){
            throw e;
        }
        capacity = initialCapacity;
        size = 0;
        currentIndex = 0;
        currentElementStatus = false;
    }
    /**
     * Adds a new element to this sequence after the current element. If this new element would
     * take this sequence beyond its current capacity, then the capacity is increased before adding
     * the new element.
     * @param element  The new element to be added.
     * @post  A new element has been added to this sequence just after currentIndex.
     * @throws OutOfMemoryError  Indicates insufficient memory to increase the size of this sequence.
     * @implNote An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence
     *           to fail with an arithmetic overflow.
     */
    public void addAfter(double element){
        //Hard-coded for now
        if(size == 0){
            currentElementStatus = true;
            currentIndex = 0;
            buffer[0] = element;
            size++;
            return;
        }
        if(size == capacity){
            Double newBuffer[];
            try {
                if(capacity == 0) newBuffer = new Double[5];
                else newBuffer = new Double[capacity*2];
                capacity = newBuffer.length;
            }
            catch (OutOfMemoryError e){
                throw e;
            }

            //    [0, 1, ..., curIndex, curIndex+1, ..., size-1]
            // -> [0, 1, ..., curIndex, elem, curIndex+1, ..., size-1]
            //No change till curIndex
            for(int i = 0; i <= currentIndex; i++){
                newBuffer[i] = buffer[i];
            }
            //Shift starting from curIndex+1
            for(int i = size; i >= currentIndex+2; i--) {
                newBuffer[i] = buffer[i-1];
            }
            //At this point, newBuffer = [0, 1, ..., curIndex, curIndex, ..., size-1]
            newBuffer[currentIndex+1] = element;
            buffer = newBuffer;
        }
        else{
            //Shift starting from curIndex+1
            for(int i = size+1; i >= currentIndex+1; i--) {
                buffer[i] = buffer[i-1];
            }
            //At this point, buffer = [0, 1, ..., curIndex, curIndex, ..., size-1]
            buffer[currentIndex+1] = element;
        }
        size++;
    }
    /**
     * Adds a new element to this sequence before the current element. If this new element would
     * take this sequence beyond its current capacity, then the capacity is increased before adding
     * the new element.
     * @param element  The new element to be added.
     * @post  A new element has been added to this sequence just before currentIndex.
     * @throws OutOfMemoryError  Indicates insufficient memory to increase the size of this sequence.
     * @implNote An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence
     *           to fail with an arithmetic overflow.
     */
    public void addBefore(double element){
        //Hard-coded for now
        if(currentIndex == 0){
            currentElementStatus = true;
            if(capacity > size){
                for (int i = size; i >= 1; i--)
                    buffer[i] = buffer[i - 1];
                currentIndex = 0;
                buffer[0] = element;
            }
            else{
                Double newBuffer[];
                try {
                    if(capacity == 0) newBuffer = new Double[5];
                    else              newBuffer = new Double[capacity*2];
                }
                catch (OutOfMemoryError e){
                    throw e;
                }
                for(int i = size; i >= 1; i--)
                    newBuffer[i] = buffer[i-1];
                newBuffer[0] = element;
            }
            size++;
            return;
        }
        if(size == capacity){
            Double newBuffer[];
            try {
                if(capacity == 0) newBuffer = new Double[5];
                else              newBuffer = new Double[capacity*2];
            }
            catch (OutOfMemoryError e){
                throw e;
            }

            //    [0, 1, ..., curIndex, curIndex+1, ..., size-1]
            // -> [0, 1, ..., elem, curIndex, curIndex+1, ..., size-1]
            //No change till curIndex-1
            for(int i = 0; i < currentIndex; i++){
                newBuffer[i] = buffer[i];
            }
            //Insert `element`
            newBuffer[currentIndex] = element;
            //Shift starting from curIndex
            for(int i = size; i >= currentIndex+1; i--) {
                newBuffer[i] = buffer[i-1];
            }
            buffer = newBuffer;
        }
        else{
            //Shift starting from curIndex
            for(int i = size; i >= currentIndex; i--) {
                buffer[i] = buffer[i-1];
            }
            //At this point, buffer = [0, 1, ..., curIndex, curIndex, ..., size-1]
            buffer[currentIndex] = element;
        }
        size++;
    }
    /**
     * @param addend  a sequence whose contents will be placed at the end of this sequence.
     * @pre  The parameter, addend, is not null.
     * @post The elements from addend have been placed at the end of this sequence. The current element
     *       of this sequence remains where it was, and the addend is also unchanged.
     * @throws NullPointerException  Indicates that addend is null.
     * @throws OutOfMemoryError  Indicates insufficient memory to increase the capacity of this sequence.
     * @implNote  An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to
     *            fail with an arithmetic overflow.
     */
    public void addAll(DoubleArraySequence addend){
        if(addend == null)
            throw new NullPointerException("addend was null");

        if(this.capacity-this.size < addend.size){
            Double[] newBuffer;
            try {
                newBuffer = new Double[this.size + addend.size];
            }
            catch (OutOfMemoryError e){
                throw e;
            }
            int i = 0;
            for(; i < this.size; i++)
                newBuffer[i] = buffer[i];
            for(int j = 0; j < addend.size; j++)
                newBuffer[i++] = addend.buffer[j];
            this.buffer = newBuffer;
            this.size += addend.size;
        }
        else {
            for (int i = 0; i < addend.size; i++) {
                buffer[size++] = addend.buffer[i];
            }
        }
    }
    /**
     * Accessor method to determine whether this sequence has a specified current element that can
     * be retrieved with the getCurrent method.
     * @return true (there is a current element) or false (there is no current element at the moment).
     */
    public boolean isCurrent(){
        return currentElementStatus;
    }
    /**
     * Move forward so that the current element is now the next element in this sequence.
     * @pre  isCurrent( ) returns true.
     * @post  If the current element was already the end element of this sequence (with nothing after it),
     *        then there is no longer any current element. Otherwise, the new element is the element
     *        immediately after the original current element.
     * @throws IllegalStateException  Indicates that there is no current element, so advance may not be called.
     */
    public void advance(){
        if(!isCurrent())
            throw new IllegalStateException("isCurrent returned null");
        if(currentIndex == size-1)
            currentElementStatus = false;
        else
            currentIndex++;
    }
    /**
     * @return The return value is a copy of this sequence. Subsequent changes to the copy will not affect
     *         the original, nor vice versa. The return value must be typecast to a DoubleArraySeq before
     *         it is used.
     * @throws OutOfMemoryError  Indicates insufficient memory for creating the clone.
     */
    public DoubleArraySequence clone(){
        DoubleArraySequence newSequence = new DoubleArraySequence(capacity); //The exception will be
                                                                             //thrown by the constructor
        for(int i = 0; i < this.size; i++)
            newSequence.buffer[i] = this.buffer[i];
        return newSequence;
    }
    /**
     * Create a new sequence that contains all the elements from one sequence followed by another.
     * @pre  Neither s1 nor s2 is null.
     * @return  A new sequence that has the elements of s1 followed by the elements of s2 (with no current
     *          element)
     * @throws NullPointerException  Indicates that one of the arguments is null.
     * @throws OutOfMemoryError  Indicates insufficient memory for the new sequence.
     * @implNote An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence to
     *           fail with an arithmetic overflow.
     */
    public static DoubleArraySequence concatenation(DoubleArraySequence s1, DoubleArraySequence s2){
        if(s1 == null)
            throw new NullPointerException("s1 was null");
        if(s2 == null)
            throw new NullPointerException("s2 was null");

        DoubleArraySequence newSequence = new DoubleArraySequence(s1.size+ s2.size); //The exception will be
                                                                                                //thrown by the constructor
        int i = 0;
        for(; i < s1.size; i++)
            newSequence.buffer[i] = s1.buffer[i];
        for(int j = 0; j < s2.size; j++)
            newSequence.buffer[i++] = s2.buffer[j];
        newSequence.size = s1.size() + s2.size();
        newSequence.currentElementStatus = true;
        return newSequence;
    }
    /**
     * Change the current capacity of this sequence.
     * @param minimumCapacity  the new capacity for this sequence.
     * @post  This sequence’s capacity has been changed to at least minimumCapacity.
     * @throws OutOfMemoryError  Indicates insufficient memory for new double[minimumCapacity].
     */
    public void ensureCapacity(int minimumCapacity){
        Double[] newBuffer;
        if(minimumCapacity < size)
            throw new OutOfMemoryError("Insufficient memory");
        try {
            newBuffer = new Double[minimumCapacity];
        }
        catch (OutOfMemoryError e){
            throw e;
        }
        for(int i = 0; i < this.buffer.length; i++)
            newBuffer[i] = this.buffer[i];
        buffer = newBuffer;
    }
    /**
     * Accessor method to determine the current capacity of this sequence. The addBefore and
     * addAfter methods work efficiently (without needing more memory) until this capacity is
     * reached.
     * @return  the current capacity of this sequence.
     */
    public int getCapacity(){
        return capacity;
    }
    /**
     * Accessor method to determine the current element of this sequence.
     * @pre  isCurrent() returns true.
     * @return  the current element of this sequence
     * @throws IllegalStateException  Indicates that there is no current element.
     */
    public double getCurrent(){
        if(!isCurrent()) throw new IllegalStateException("There is no current element");
        return buffer[currentIndex];
    }
    /**
     * Remove the current element from this sequence.
     * @pre  isCurrent() returns true.
     * @post The current element has been removed from this sequence, and the following element (if
     *       there is one) is now the new current element. If there was no following element, then there
     *       is now no current element.
     * @throws IllegalStateException  Indicates that there is no current element, so removeCurrent may not be called.
     */
    public void removeCurrent(){
        if(currentElementStatus == false)
            throw new IllegalStateException("There is no current element");
        for(int i = 0; i < size-1; i++)
            buffer[i] = buffer[i+1];
        //currentIndex will remain the same as the elements after the removed element are shifted
        //backwards.
        size--;
        if(currentIndex == size)
            currentElementStatus = false;
    }
    /**
     * Accessor method to determine the number of elements in this sequence.
     * @return  the number of elements in this sequence
     */
    public int size(){
        return size;
    }
    /**
     * Set the current element at the front of this sequence.
     * @post  The front element of this sequence is now the current element (but if this sequence has no
     *        elements at all, then there is no current element).
     */
    public void start(){
        if(size > 0) currentIndex = 0;
        else         currentElementStatus = false;
    }
    /**
     * Reduce the current capacity of this sequence to its actual size (i.e., the number of elements it
     * contains).
     * @post  This sequence’s capacity has been changed to its current size.
     * @throws OutOfMemoryError  Indicates insufficient memory for altering the capacity.
     */
    public void trimToSize(){
        Double[] newBuffer;
        try{
            newBuffer = new Double[size];
        }
        catch (OutOfMemoryError e){
            throw e;
        }
        for(int i = 0; i < size; i++){
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
        capacity = size;
    }

}
