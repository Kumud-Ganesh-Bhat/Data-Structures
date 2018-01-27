/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Rearrange array so that a[i] becomes a[a[i]], assuming numbers lie in the range 0 to n-1
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class RearrangeArray {
    
    static public void rearrangeArray_V2(int[] arr, int n){ //TC: O(n), SC: O(1)
        
        //Assuming numbers lie in the range of 0 to n-1
        
        int i; //loop variable
        
        for(i=0; i<n; i++)
            arr[i] = (arr[i] + (arr[arr[i]]%n) * n) ;
        
        for(i=0; i<n; i++)
            arr[i] = arr[i]/n;
        
        System.out.println(Arrays.toString(arr));
        
    }
    
    static public void rearrangeArray_V1(int[] arr, int n){ //TC:O(n), SC: O(n)
        
        int i; //loop variable
        int[] temp = new int[n];
        
        for(i=0; i<n; i++)
            temp[i] = arr[arr[i]];
        
        arr = Arrays.copyOf(temp, n);
        
        System.out.println(Arrays.toString(arr));
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Re arrange array so that a[i] becomes a[a[i]]");
        
        System.out.println("Enter the number of elements ");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        rearrangeArray_V1(arr,n);
        rearrangeArray_V2(arr,n);
        
    }
    
}
