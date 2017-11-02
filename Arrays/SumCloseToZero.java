/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Description: Find two elements in an array whose sum is closest to zero
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class SumCloseToZero {
    
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
    
    public static int findSumCloseToZero(int[] arr){
        arr = mergeSort(arr, 0, arr.length-1); //sorting the given array in O(nlogn) time
        int l = 0; //left index
        int r = arr.length-1; //right index
        int a=0,b=0; //two elements
        int temp;
        int sum = Integer.MAX_VALUE; //variable holding resulting sum
        
        while(l<r){
            temp = arr[l]+arr[r];
            if(Math.abs(temp) < Math.abs(sum)){
                sum = temp;
                a = arr[l];
                b = arr[r];
            }
            if(temp<0)
                r--;
            else
                l++;
                
        }
        
        System.out.println("Pair of elements are: " + "(" + a + "," + b + ")" );
        
        return sum;
        
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int sum;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding the numbers whose sum is closest to zero");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        sum = findSumCloseToZero(arr);
        
        System.out.println("Sum is " +sum);
    }
    
    
}
