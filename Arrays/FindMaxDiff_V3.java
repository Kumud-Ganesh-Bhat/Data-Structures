/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Statement:
 *    Find maximum difference between 2 elements in an array such that larger element has higher index than smaller element
 *    i.e., larger element will come after smaller element
 * 
 *
 * @author kumud
 * @version 1.2
 * 
 */
public class FindMaxDiff_V3 {
    
    public static int getMaxDiff(int[] arr){
        int minElement = Integer.MAX_VALUE; //minimum element visited so far
        int maxDiff = 0; //maximum difference so far
        int temp;//temporary variable to store the difference
        int i; //loop variable
        
        for(i=0; i<arr.length-1; i++){
            minElement = (minElement<arr[i])? minElement:arr[i];
            if(arr[i+1] > arr[i]){ // larger element appearing after smaller element
                temp = arr[i+1]-arr[i];
                if(maxDiff <= temp){
                    maxDiff = temp;
                    System.out.println("Pairs are: " + arr[i] + "," + arr[i+1]);
                } //nested if
            } //if
        } //for
        
        return maxDiff;
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //index variable
        int maxDiff;//maximum difference
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Maximum Difference");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        maxDiff = getMaxDiff(arr);
        
        System.out.println("Maximum Difference: " + maxDiff);
    }
    
}
