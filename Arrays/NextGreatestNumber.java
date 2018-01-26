/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description:  Find Next Greatest Number with same set of digits
 *                       Given a number n, the smallest number that has same set of digits as n and is greater than n
 *                       TC: O(n), SC: O(1) i.e auxillary space
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class NextGreatestNumber {
    
    public static void findNextGreatestNumber(int[] arr, int n){
        
        int i=0, j=0; //loop or index variables
        int pos = -1; //position variable
        int min = Integer.MAX_VALUE;
        int temp;
        
        for(i=n-2; i>=0; i--){      //O(n)
            if(arr[i] < arr[i+1]){
                pos = i;
                break;
            }
        }
        
        
        if(i==-1){ //or condition if(pos == -1)
            System.out.println("Not possible to construct next greater number with same set of digits");
            return;
        }
        
        for(i=pos+1; i<n; i++){      // ~ O(n)
            if(arr[i] > arr[pos]){
                if(min > arr[i]){
                    min = arr[i];
                    j = i;
                }
            }
        }
        
        //Swapping
        temp = arr[pos];
        arr[pos] = arr[j];
        arr[j] = temp;
        
        Arrays.sort(arr, pos+1, n);
        
        System.out.println("Next Greater number with same set of digits");
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        
         int n; //number of elements/digits
         int[] arr; //array of elements
         int i; //loop variable
         
         Scanner sc = new Scanner(System.in);
         
         System.out.println("Find the next greatest number with same set of digtis ");
         
         System.out.println("Enter the number of elements");
         n = sc.nextInt();
         arr = new int[n];
         
         System.out.println("Enter the array elements");
         for(i=0; i<n; i++)
             arr[i] = sc.nextInt();
         
         findNextGreatestNumber(arr, n);
         
    }
    
}
