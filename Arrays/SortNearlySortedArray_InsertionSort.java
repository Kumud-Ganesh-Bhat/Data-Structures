/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Sort nearly sorted array using Insertion Sort
 *                      i.e., Given an array of n elements, in which array is nearly sorted (each element is misplaced by at most k positions)
 * Time Complexity - Worst Case: O(n*k), assuming k < n and k < logn
 *                   Best Case: O(n)
 * 
 * This problem can be solved more efficiently using Heap data structure
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class SortNearlySortedArray_InsertionSort {
    public static void nearlyInsertionSort(int[] arr){
        int i,j; //loop variables
        int key; //temporary variables
        for(j=1; j<arr.length; j++){ //This loop will run atmost n*k times
            key = arr[j]; //preventing loss of data due to overrriding
            i = j-1; //inserted into sorted sequence 0 - j-1
            while(i>=0 && arr[i] > key){
                arr[i+1] = arr[i];
                i = i-1;
            }
            arr[i+1] = key;
            
        }
        
        System.out.println("Sorted Array: " + "\n" + Arrays.toString(arr));
    }
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int k;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Sorting nearly sorted array using Insertion Sort");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the nearly sorted array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the value of k i.e., by how many positions each element in an array is misplaced ");
        k = sc.nextInt();
        
        nearlyInsertionSort(arr);
    }
    
}
