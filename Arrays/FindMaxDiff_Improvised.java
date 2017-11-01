/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Description:
 *    Finding maximum difference between two elements in array such that larger element has higher index than smaller element.
 *    i.e., larger element appears after smaller element
 * Algorithm:
 *    1. Construct difference array: diff[i] = arr[i+1]-arr[i]
 *    2. Find maximum sum subarray in difference array which will be equal to required maximum difference
 * Time Complexity - O(n)
 * Space Complexity - O(n)
 * 
 * @author kumud
 * @version 1.1
 */
public class FindMaxDiff_Improvised {
    
    public static int findMaxDiff(int[] arr){
        int currDiff;
        int[] diff = new int[arr.length-1]; //difference array
        int i; //index variable
        
        //Compute difference array
        for(i=0; i<arr.length-1; i++)
            diff[i] = arr[i+1] - arr[i];
        
        //find maximum sum subarray from difference array
        currDiff = diff[0];
        for(i=1; i<diff.length; i++){
            if(diff[i-1] > 0)
                diff[i]+=diff[i-1];
            currDiff = (currDiff < diff[i])? diff[i]:currDiff;
        }
        
        return currDiff;
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //index variable
        int maxDiff; //maximum difference
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Maximum Difference");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        maxDiff = findMaxDiff(arr);
        
        System.out.println(maxDiff);
    }
    
}
