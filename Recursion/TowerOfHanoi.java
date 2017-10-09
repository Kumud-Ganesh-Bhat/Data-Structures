package datastructures.recursion;

import java.util.Scanner;

/**
 * Recursion - Tower of Hanoi
 * Problem Statement:
 * 1. There are three towers X,Y,and Z
 * 2. Move n disks from tower X to tower Y using tower Z
 * 3. Only one disk can be moved at a time from one tower to other tower and
 * 4. Heavier disk should not be placed on lighter disk
 *
 * No of recursive calls = O(2^n+1 -1)
 * No of movements = O(2^n -1)
 * Space complexity = O(n)
 * Time complexity = O(2^n) - NP Completeness/Hard category
 * 
 * @author Kumud Bhat
 * @version 1.0
 */

public class TowerOfHanoi{
    
    //instance variables
    int n; //number of disks
    static String source = "X"; //tower X
    static String destination = "Y"; //tower Y
    static String intermediate = "Z"; //tower Z
    
    public void moveDisks(int n, String source, String destination, String intermediate){
        if(n>1){ //Reducing number of invocations by changing condition
            moveDisks(n-1,source,intermediate,destination);
            System.out.println("Move disk" + " " + n + "from " + source + "to " + destination );
            moveDisks(n-1,intermediate,destination,source);
        }
        else if(n==1)
            System.out.println("Move disk" + " " + n + "from " + source + "to " + destination );
        else
            return;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TowerOfHanoi toh = new TowerOfHanoi();
        
        System.out.println("Tower of Hanoi Problem");
        System.out.println("Enter the number of disks");
        
        toh.n = sc.nextInt();
        toh.moveDisks(toh.n,source,destination,intermediate);
  }
}
