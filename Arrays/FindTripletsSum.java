/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Find Triplets in given array such that sum is equal to given number 'x'
 * Approaches
 *   1. Using Naive approach - Time Complexity - O(n^3)
 *   2.
 *   3.
 * 
 * @author kumud
 * @version 1.0
 */
public class FindTripletsSum {
    
    //Naive approach - Time Complexity - O(n^3)
    public static void findTriplets(int[] arr, int x){
        int i,j,k; //loop variables
        for(i=0; i<arr.length; i++){
            for(j=i+1; j<arr.length; j++){
                for(k=j+1; k<arr.length; k++){
                    if(arr[k] == x-arr[j]-arr[i])
                        System.out.println("Triplets are " + "(" + arr[i] + "," + arr[j] + "," + arr[k] + ")");
                }
            }
        }
    }
    
    public static int[] merge(int[] arr, int p, int q, int r){
        int n1 = q-p+1; //number of elements in the first half array
        int n2 = r-q; //number of elements in the second half array
        int[] L = new int[n1+1]; //Left array
        int[] R = new int[n2+1]; //Right array
        int i,j,k; //loop variables
        
        for(i=0; i<n1; i++)
             L[i] = arr[p+i];
        for(j=0; j<n2; j++)
             R[j] = arr[q+1+j];
        
        L[n1] = Integer.MAX_VALUE; //storing very large value in the last entry
        R[n2] = Integer.MAX_VALUE; //storing very large value in the last entry
        
        i=0; //element pointing to entries in left array
        j=0; //element pointing to entries in right array
        
        for(k=p; k<=r; k++){
            if(L[i] <= R[j])
                arr[k]=L[i++];
            else
                arr[k]=R[j++];
        }
        
        return arr;
    }
    
    public static int[] mergeSort(int[] arr, int p, int r){
        if(p<r){
            int q = (p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            arr = merge(arr, p, q, r);
        }
       return arr; 
    }
    
    
    //Optimizing the third loop - Time Complexity - O(n^2logn)
    public static void findTriplets_V2(int[] arr, int x){
        int i,j; //loop variables;
        int temp;
        arr = mergeSort(arr, 0, arr.length-1); //sorting the array - O(nlogn)
        for(i=0; i<arr.length; i++){ // O(n*n)
            for(j=i+1; j<arr.length; j++){
                temp = Arrays.binarySearch(arr, x-arr[i]-arr[j]); //returns the index of third element in the pair if found - O(logn)
                if(temp != -1)
                    System.out.println("Triplets are: " + "("  + arr[i] + "," + arr[j] + "," + arr[temp] +")");
            }
        }
        
    }
    
    //Third Approach - 
    //Fix one element. And adjust left and right pointers to it accordingly until we get required sum
    //Time Complexity - O(n^2)
    public static void findTriplets_V3(int[] arr, int x){
        int i; //loop variable
        int l; //left index
        int r; //right index
        int temp;
        
        arr = mergeSort(arr,0,arr.length-1);
        for(i=0; i<arr.length-2; i++){
            //fix left and right pointers for each element
            l = i+1;
            r = arr.length-1;
            while(l<r){
                temp = arr[i]+arr[l]+arr[r];
                if(x == temp){
                    System.out.println("Triplets are " + arr[i] + "," + arr[l] + "," + arr[r]);
                    return;
                }
                else if(temp < x)
                     l++;
                else
                    r--;
                
            } //while
            
        } //for
        
        System.out.println("Triplets not found");
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int x; //given sum
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Triplets such that their sum is equal to given number 'x' ");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the sum value");
        x = sc.nextInt();
        
        findTriplets_V3(arr,x);
        
    }
    
}
