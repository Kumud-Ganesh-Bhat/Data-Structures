/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Problem Description: Find sub array with given sum x
 * Case 1: All numbers in an array are positive and sub array is contiguous
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class SubArrayWithGivenSum {
    
    //Naive approach trying to find all possible subarrays. i.e., subarrays starting from index 0, index 1 and so on.
    //Time Complexity - O(n^2)
    public static void findSubArray(int[] arr, int x){
        int i =0,j =0, k =0; //loop variables;
        int sum = 0;
        
        for(i=0; i<arr.length; i++){
            sum+=arr[i];
            for(j=i+1; j<arr.length; j++){
                if(sum+arr[j] == x){
                    sum+= arr[j];
                    break;
                }
                else if(sum+arr[j] < x){
                    sum+= arr[j];
                }
                else{
                    sum = 0;
                    break;
                }
            } //for j
            
            if(sum == x)
                break;
        }
        
        if(i == arr.length){
            System.out.println("No sub array with given value found");
            return;
        }
        
        System.out.println("Sub array with given sum value is ");
        for(k=i; k<=j; k++)
            System.out.print(arr[k] + " ");
        
        System.out.println();
    }
    
    //Optimized approach - TC - O(n)
    static public void findSubArray_Optimized(int[] arr, int x){
        
        int i; //loop variable
        int l=0,r=0; //left and right pointers
        int sum=0;
        
        while(l<= r && r<arr.length){
            sum += arr[r];
            
            if(sum == x)
                break;
            
            else if(sum < x)
                r++;
            else{
                  sum-=arr[l];
                  l++;
                  if(sum == x) break;
                  else
                      r++;
            }
            
        }
        
        
        if(l == arr.length || r == arr.length){
            System.out.println("Sub array not found");
            return;
        }
        System.out.println("Sub array with given sum");
        for(i=l; i<=r; i++)
            System.out.print(arr[i] + " ");
        
        System.out.println();
        
    }
    
    //Case 2: Considering array of negative integers as well  - TC- O(n), SC- O(n)
    static public void findSubArray_Optimized_V3(int[] arr, int x){
        
        int i=0,j=0,k=0; //loop or index variables
        int sum=0,diff=0;
        ArrayList<Integer> hash = new ArrayList<Integer>();
        
        for(i=0; i<arr.length; i++){                        //Tc - O(n)
            sum+= arr[i];
            hash.add(sum);
            diff = sum - x;
            if(hash.contains(diff)){
                j = hash.indexOf(diff);
                //System.out.println(j);
                break;
            }
        }
        
        if(i==arr.length){
            System.out.println("No subarray with given sum is found");
            return;
        }
        
        System.out.println("Sub Array with given sum");
        for(k=j+1; k<=i; k++)                           //TC - O(n)
            System.out.print(arr[k] + " ");
        
        System.out.println();
    }
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variables
        int x; //given sum value
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find Sub Array with given sum X");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the value of sum");
        x = sc.nextInt();
        
        //findSubArray(arr,x);
        //findSubArray_Optimized(arr,x);
        findSubArray_Optimized_V3(arr,x);
    }
    
}
