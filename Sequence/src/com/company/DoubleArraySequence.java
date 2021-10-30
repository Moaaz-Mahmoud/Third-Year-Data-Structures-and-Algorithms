package com.company;

import java.lang.reflect.Member;

public class DoubleArraySequence {
    private static final Double MAX_VAL = Double.MAX_VALUE;
    private static final Integer DEFAULT_CAPACITY = 10;

    private Double[] buffer;
    private Integer capacity;
    private Integer size;
    private Integer currentIndex;

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
        if(size == capacity){
            Double newBuffer[];
            try {
                newBuffer = new Double[capacity*2];
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
            for(int i = size; i >= currentIndex+1; i--) {
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
     * @post
     * @throws OutOfMemoryError  Indicates insufficient memory to increase the size of this sequence.
     * @implNote An attempt to increase the capacity beyond Integer.MAX_VALUE will cause this sequence
     *           to fail with an arithmetic overflow.
     */
    public void addBefore(double element){

    }
}
