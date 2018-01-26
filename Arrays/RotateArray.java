/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Rotate the array of size n by d elements
 *                      
 * @author kumud
 * @version 1.0
 * 
 */
public class RotateArray {
    
    public static int findGCD(int a, int b){
        if(a==0 || b==0)
            return 0;
        else if(a == b)
            return a;
        else if(a>b)
            return findGCD((a-b),b);
        else
            return findGCD(a, (b-a));
    }
    
    public static int[] reverseArray(int[] arr, int l, int r){
        
        int temp; 
        
        while(l < r){
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++; r--;
        }
        
        return arr;
    }
    
    public static int[] leftRotateArray_V4(int[] arr, int n, int d){  //TC: O(n), SC: O(1)
        
        arr = reverseArray(arr, 0, d-1); //reversing first d elements
        arr = reverseArray(arr, d, n-1); //reversing n-d elements
        arr = reverseArray(arr, 0, n-1); //reversing whole array
        
        return arr;
    }
    
    public static int[] leftRotateArray_V3(int[] arr, int n, int d){ //TC: O(gcd * n/gcd), SC: O(1)
        
        int gcd = findGCD(n, d);
        int nBlocks = n/gcd;
        int i,j, k; //loop variables
        int temp;
        
        for(i=0; i<gcd; i++){
            temp = arr[i];
            j = i;
            while(true){
              k = j + d;
              if(k >= n)
                  k-=n;
              if(k == i)
                  break;
              arr[j] = arr[k];
              j = k;
            }
            arr[j] = temp;
        }
        
        return arr;
    }
    
    public static int[] leftRotateArray_V2(int[] arr, int n, int d){ //Time Complexity - O(n*d), Space Complexity - O(1)
        
        int i=0,j=0; //loop variables
        int temp;
        
        while(i < d){
            
            temp = arr[0]; //copying first index value to temporary variable always
            for(j=0; j<n-1; j++)
                arr[j] = arr[j+1];
            arr[j] = temp;
            
            i++;
        }
        
        return arr;
    }
    public static int[] leftRotateArray_V1(int[] arr, int n, int d){ //Time Complexity - O(n), Space Complexity - O(d)
        
        int[] temp = new int[d]; //temporary array
        int i,j; //loop variables
        
        for(i=0; i<d; i++)
            temp[i] = arr[i];
        
        for(i=0; i<n-d; i++)
            arr[i] = arr[i+d];
        
        j = 0;
        
        for(i=n-d; i<n; i++)
            arr[i] = temp[j++]; //better to write this code in try catch block to catch ArrayIndexOutOfBoundsException in case if it is thrown
        
        return arr;
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int d; //number of rotations
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Rotating the array of size n by d elements ");
        
        System.out.println("Enter the number of elements ");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the value of d i.e., by how many elements the array should be rotated");
        d = sc.nextInt();
        
        arr = leftRotateArray_V3(arr,n,d);
        
        System.out.println("After rotating array: " + Arrays.toString(arr));
    }
    
}
