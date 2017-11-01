/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Separate 0's and 1's in an array
 * Approach: Any sorting algorithm can be applied
 *           1. Counting Sort - Time Complexity: O(n), Space Complexity: O(n)
 *           2. Quick Sort - Time Complexity: O(nlogn) in Best case, Space Complexity: O(1)
 * 
 *
 * Demerit: Quick Sort: Same as naive approach. Because after each partition problem size is not reduced evenly.
 *          And even if elements are sorted quick sort runs and time complexity will be O(n^2)
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class Separate_Zeros_Ones {
    
    public static int partition(int[] arr, int l, int r){
        int x = arr[r]; //pivot element
        int j=l; //index variable
        int i=j-1; //index variable
        int temp; //temporary variable
        for(j=l; j<r; j++){
            if(arr[j] <= x){
                temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
            } //if
        } //for
        temp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = temp;
        
        return i+1;
        
    }
    
    public static int[] sepZeroOne(int[] arr, int l, int r){
        if(l<r){ //Base/Halt condition
            int p = partition(arr,l,r); //correct position of pivot element
            sepZeroOne(arr,l,p-1); //processing first half of array
            sepZeroOne(arr,p+1,r); //processing other half of array
        }
        
        return arr;
    }
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Separating zero's and one's");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        arr = sepZeroOne(arr,0,n-1);
        
        System.out.println("After separating zeros and ones " + Arrays.toString(arr));
        
    }
    
}
