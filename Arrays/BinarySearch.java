/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Binary Search Algorithm implementation
 * Binary Search is also called as half-interval search or logarithmic search
 * because during every search the size of problem is reduced by half
 * Binary Search is efficient and applicable only if
 * 1) the elements are stored in an array
 * 2) array elements are sorted
 * 
 * Problem Statement:
 *       Given an array A of n numbers with values or records sorted A0, A1, A2, ... An-1 such that
 *       A0 <=  A1 <= A2......<= An-1
 *       and the target value T, the following subroutine uses Binary Search to find an index of target value T
 * 
 * Input:
 * 1) Sorted array of n elements
 * 2) Target value
 * 
 * Output:
 * index of target element if found
 *
 * @author kumud
 * @version 1.0
 * 
 */
public class BinarySearch {
    
    //Recursive approach
    public static int binarySearch(int[] arr, int l, int r, int target){
        if(l <= r){
            int mid = (l+r)/2;
            if(target == arr[mid])
                return mid; //eleement found at middle position
            else if(target < arr[mid])
                return binarySearch(arr,l,mid-1,target); //search in left half of the array
            else
                return binarySearch(arr,mid+1,r, target); //search in right half of the array
        }
        
        return -1;
    }
    
    //Iterative approach
    public static int iterative_binarySearch(int[] arr, int l, int r, int target){
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                l = mid+1;
            else
                r = mid-1;
        }
        return -1;
    }
    
    public static void main(String[] args){
        int n; //number of elements of array
        int[] arr; //array of n elements
        int i; //loop variable
        int target; //target value to be searched
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Binary Search Implementation");
        System.out.println("Enter the number of elements");
        
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array eleemnts sorted in an ascending order");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the target value");
        target = sc.nextInt();
       
        i = binarySearch(arr,0, n-1, target);
        System.out.println("Element found at index" + " " + i);
        
    }
    
}
