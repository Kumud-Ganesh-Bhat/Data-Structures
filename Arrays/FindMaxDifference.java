/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Statement:
 * Find maximum difference between two elements in an array such that larger element appears after the smaller element
 * Using Approach 1 (naive approach - Linear search)
 * Time complexity - O(n^2)
 * 
 * Input: array of elements
 * Output: maximum difference
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindMaxDifference {
    
    public static void getMaxDifference(int[] arr, int n){
        int i,j; //loop variables
        int maxDiff =0; //maximum difference
        int a=0,b=0; //pair of elements 
        
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                //larger element should come after the smallest element
                if(arr[j] > arr[i]){
                    if(maxDiff < arr[j]-arr[i]){
                        maxDiff = arr[j]-arr[i];
                        a = arr[i];
                        b = arr[j];
                    } //nested if
                } //if
            } //for j
        } //for i
        
        System.out.println("Maximum difference is " + maxDiff + " " + "and the pair of elements are (" + a + "," + b + ")");
    }
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding maximum difference");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        getMaxDifference(arr,n);
        
    }
    
}
