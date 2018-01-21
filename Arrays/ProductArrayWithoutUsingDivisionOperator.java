/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Given an array of n integers. Construct product array such that product[i] is equal 
 *                      to product of all array elements except arr[i] without using division operator.
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class ProductArrayWithoutUsingDivisionOperator {
    
    public static void findProdArray_WithDivisionOp(int[] arr){
        int[] prodArray = new int[arr.length];
        int i; //loop variable
        int product = 1;
        
        for(i=0; i<arr.length; i++)
            product*= arr[i];
        for(i=0; i<prodArray.length; i++)
            prodArray[i] = product/arr[i];
        System.out.println("Product Array " + "\n" + Arrays.toString(prodArray));
    }
    
    public static void findProdArray_Optimized_V3(int[] arr){
        
        int i; //loop variable
        int product = 1;
        int[] prodArray = new int[arr.length];
        
        Arrays.fill(prodArray, 1); //Initialize product array to one
        
        for(i=0; i<arr.length; i++){ //Computing Left Product
            prodArray[i] = product;
            product*= arr[i];
        }
        
        product = 1;
        
        for(i=arr.length-1; i>=0; i--){//Computing Right Product and Overriding to get final result
            prodArray[i] *= product;
            product *= arr[i];
        }
        
        System.out.println("Product Array " + "\n" + Arrays.toString(prodArray));
    }
    
    public static void findProdArray_Optimized(int[] arr){  //Time Complexity - O(n), Space Complexity - O(n)
        int i; //loop variable
        int[] prodArray = new int[arr.length];
        int[] leftProd = new int[arr.length];
        int[] rightProd = new int[arr.length];
        
        leftProd[0] = arr[0];
        rightProd[arr.length - 1] = arr[arr.length-1];
        
        for(i=1; i<arr.length; i++)
            leftProd[i] = leftProd[i-1] * arr[i];
        
        for(i=arr.length-2; i>=0; i--)
            rightProd[i] = rightProd[i+1] * arr[i];
        
        for(i=0; i<prodArray.length; i++){
            if(i==0)
               prodArray[i] = rightProd[i+1];
            else if(i == prodArray.length-1)
               prodArray[i] = leftProd[i-1];
            else
                prodArray[i] = leftProd[i-1] * rightProd[i+1];
        }
        
        System.out.println("Product Array " + "\n" + Arrays.toString(prodArray));
    }
    
    public static void findProdArray(int[] arr){ //Time Complexity - O(n^2), Space Complexity - O(n)
        int i, j, k; //loop variable
        int product = 1;
        int[] prodArray = new int[arr.length];
        
        for(i=0; i<arr.length; i++){
             k = i-1;
             j = i+1;
             while(k >= 0)
                 product*= arr[k--];
             while(j < arr.length)
                 product*= arr[j++];
             prodArray[i] = product;
             product = 1;
        }
        
        System.out.println("Product Array " + "\n" + Arrays.toString(prodArray));
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Product of an array without using division operator");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        //findProdArray(arr);
        //findProdArray_Optimized(arr);
        //findProdArray_WithDivisionOp(arr);
        findProdArray_Optimized_V3(arr);
    }
    
}

