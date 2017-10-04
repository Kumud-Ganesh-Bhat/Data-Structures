/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Description:
 * Find a pairs in an array whose sum is equal to a given number
 * x - given number
 * (a,b) - pairs
 * for every a - corresponding b = x-a
 * 
 * Naive approach
 * for each element a find the corresponding number b such that a+b = x
 * for each element n comparisons, for n elements -> Time complexity O(n^2)
 * 
 * Hash table approach
 * Insert elements into hash table -> Amortized cost O(n)
 * For each element corresponding element can be found in O(1) time.
 * Hence using hash approach time complexity will be O(n) time
 * 
 * Input: Array of n numbers
 *        Target sum -x
 * Output: pair(s) (a,b)
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindPairs {
    
    public static void findPairs(int[] arr, int x){
        int i,j; //loop variables
        for(i=0; i<arr.length; i++){
            for(j=i+1; j<arr.length; j++){
                if(arr[j] == x-arr[i])
                   System.out.println("Pair of elements:" + "\n" + "(" + arr[i] + "," + arr[j] + ")");
            }
        }
    }
    
    public static void main(String[] args){
        
        int n; //number of elements of an array
        int[] arr; //array of integers
        int i; //loop variable
        int x; //given element i.e., target sum value
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding the pairs whose sum is equal to given number");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the target sum");
        x = sc.nextInt();
        
        //Naive approach
        findPairs(arr,x);
    } //main
    
}
