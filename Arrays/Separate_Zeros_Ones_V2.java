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
 *     Separate 0's and 1's in an array
 * Approach:
 *     Finding Least Significant Bit using mod 2
 * 
 * @author kumud
 * @version 1.1
 * 
 */
public class Separate_Zeros_Ones_V2 {
    public static int[] sepZerosOnes(int[] arr){
        int countZeros = 0;
        int countOnes = 0;
        int i; //loop variable
        for(i=0; i<arr.length; i++){
            if(arr[i]%2 == 0)
                countZeros+=1;
            else
                countOnes+=1;
        }
        
        for(i=0; i<countZeros; i++)
              arr[i] = 0;
        for(i=countZeros; i<arr.length; i++)
              arr[i] = 1;
        
        return arr;
    }
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements;
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        arr = sepZerosOnes(arr);
        System.out.println("After separating 0's and 1's " + Arrays.toString(arr));
    }
    
}
