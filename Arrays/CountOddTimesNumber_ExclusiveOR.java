/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Description:
 *     Counting number occurring odd number of times in a given array of size n such that
 *     only one element will be occurring odd number of times
 * 
 * Approach: Bitwise Exclusive OR
 * 
 * @author kumud
 * @version 1.2
 * 
 */
public class CountOddTimesNumber_ExclusiveOR {
    
    public static int getOddTimesNumber(int[] arr){
        int result=0;
        int i; //loop variable
        for(i=0; i<arr.length; i++)
            result = result^arr[i];
        
        return result;
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int result;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Counting number occurring odd times");
        
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        arr =  new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        result = getOddTimesNumber(arr);
        
        System.out.println("Number occurring odd number of times " + result);
    }
    
}
