/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Given an array of positive integers, find a smallest integer that cannot
 *                      be represented as sum of any subset of a given array
 *                      TC: O(n) SC: O(1)
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class SmallestNotASumInteger {
    
    static public void findSmallestInteger(int[] arr, int n){   //Time Complexity: O(n), SC: O(1)
        int i; //loop variable
        int smallSum = 1; //smallest integer that cannot be sum so far
        for(i=0; i<n; i++){
            if(arr[i] <= smallSum)
                smallSum+= arr[i];
            else
                break;
        }
        
        System.out.println("The smallest integer that cannot be represented as sum of any subset of a given array " + smallSum);
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find the smallest integer that cannot be represented as sum of any subset of a given array ");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findSmallestInteger(arr,n);
        
    }
    
}
