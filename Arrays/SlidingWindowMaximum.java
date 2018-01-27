/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description:
 *     Given an array A and an integer k, find the maximum element for each and every contiguous sub-array of size k
 *     1. Using Naive approach - O(k*(n-k))
 *
 * @author kumud
 */
public class SlidingWindowMaximum {
   /* public static void findMaxSubArray_Optimized(int[] arr, int k){
        //int max = Integer.MIN_VALUE;
        int i; //loop variable
        for(i=0; i<=arr.length-k; i++){
            int[] temp = Arrays.copyOfRange(arr, i, i+k);
            Arrays.sort(temp);
            System.out.print(temp[i+k-1]);
            
        }
    }*/
    public static void findMaxSubArray(int[] arr, int k){
        int i,j; //loop variable
        int max = Integer.MIN_VALUE;
        for(i=0; i<=arr.length-k; i++){
            for(j=i; j<i+k; j++){
                if(max < arr[j])
                    max = arr[j];
            }
            System.out.print(max + ",");
            max = Integer.MIN_VALUE;
        }
    }
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int k; //window size
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Sliding Window Maximum problem");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the window size");
        k = sc.nextInt();
        
        findMaxSubArray(arr,k);
        
        System.out.println();
        
    }
    
}
