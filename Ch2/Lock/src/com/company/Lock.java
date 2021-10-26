package com.company;

public class Lock {
    private final static Integer MIN = 0;
    private final static Integer MAX = 39;
    // x < z < y
    private Integer x;
    private Integer y;
    private Integer z;
    private boolean status; //true: open    false: closed
    private Integer position;
    private Integer[] lastPositions;

    public Lock(Integer newX, Integer newY, Integer newZ){
        this.x = newX;
        this.y = newY;
        this.z = newZ;
        status = false;
        position = 0;
        lastPositions = new Integer[3];
    }
    public void alterCombination(int newX, int newY, int newZ){
        if(this.status == false){
            System.out.println("Access denied!");
            return;
        }
        x = newX;
        y = newY;
        z = newZ;
    }
    public void turn(int newPos){
        this.position = newPos;
        lastPositions[0] = lastPositions[1];
        lastPositions[1] = lastPositions[2];
        lastPositions[2] = newPos;
    }
    public void close(){
        status = false;
        for(Integer pos : lastPositions) pos = 0;
    }
    public boolean attemptOpen(){
        if(lastPositions[0] == x && lastPositions[1] == y && lastPositions[2] == z){
            status = true;
            return true;
        }
        return false;
    }
    public boolean getStatus(){
        return status;
    }
    public Integer getPosition(){
        return position;
    }
}
