package com.company;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the three values for the lock\n>>> ");
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        Lock lock = new Lock(x, y, z);
        System.out.print("1: Alter the pattern\n");
        System.out.print("2: Turn the knob\n");
        System.out.print("3: Close\n");
        System.out.print("4: Get status\n");
        System.out.print("5: Attempt to open\n");
        System.out.print("6: Exit\n");
        int cmd = 0;
        while (cmd != 6){
            System.out.print("cmd\n>>> "); cmd = sc.nextInt();
            switch(cmd){
                case 1:
                    if(!lock.getStatus()){
                        System.out.println("Access denied!");
                    }
                    else{
                        x = sc.nextInt();
                        y = sc.nextInt();
                        z = sc.nextInt();
                        lock = new Lock(x, y, z);
                        System.out.println("Operation succeeded!");
                    }
                    break;
                case 2:
                    System.out.print("New position\n>>> ");
                    int newPos = sc.nextInt();
                    lock.turn(newPos);
                    break;
                case 3:
                    lock.close();
                    break;
                case 4:
                    System.out.println(lock.getStatus() ? "Open" : "Locked");
                    break;
                case 5:
                    if(!lock.attemptOpen()){
                        System.out.println("Unable to open the lock!");
                    }
                    else{
                        System.out.println("Lock opened!");
                    }
                    break;
                case 6:
                    break;
            }
        }
    }
}
