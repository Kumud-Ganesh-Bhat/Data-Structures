/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;
import java.util.Scanner;
import java.util.HashMap;
/**
 * Problem Description: Consider an array which contains only 0's and 1's, find the largest sub array with equal number of 0's and 1's
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class LargeSubArrWithEqualZerosOnes {
    
    //Optimized Approach - Time Complexity - O(n)
    public static void findLargeSubArr_Optimized(int[] arr){
        int i; //loop variable
        int sum = 0; //variable that keeps track of sum obtained so far
        int startIndex = 0; //lower bound of sub array
        int endIndex = 0; //upper bound of sub array
        int largeVal = Integer.MIN_VALUE; //largest size of sub array
        int temp; //temporary variable
        HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
        
        for(i=0; i<arr.length; i++) //Replacing all 0's with -1's
             arr[i] = (arr[i] == 0) ? -1 : arr[i];
        
        for(i=0; i<arr.length; i++){
            sum+= arr[i]; //sum obtained so far
            if(hMap.containsKey(sum)){
                startIndex = hMap.get(sum);
                temp = i-startIndex+1; //size of sub array obtained so far
                if(largeVal < temp){
                    largeVal = temp;
                    startIndex+=1;
                    endIndex = i;
                }
            }
            
            else
                hMap.put(sum, i);
        }
        
        for(i=0; i<arr.length; i++)
             arr[i] = (arr[i] == -1) ? 0 : arr[i];
        
        if(largeVal == Integer.MIN_VALUE){
            System.out.println("No such subarray");
            return;
        }
        System.out.println("Largest Sub Array with equal number of 0's and 1's is from " + startIndex + " to " + endIndex );
        
    }
    
    public static void findLargeSubArr(int[] arr){ //Time Complexity - O(n^2)
        
        int countZeros;
        int countOnes;
        int sum = 0;
        int largeVal = Integer.MIN_VALUE;
        int i,j; //loop variables
        int startIndex =0, endIndex=0;
        
        for(i=0; i<arr.length; i++){
            countZeros = 0;
            countOnes = 0;
            for(j=i; j<arr.length; j++){
                
                if(arr[j] == 0)
                    countZeros+= 1;
                else
                    countOnes+= 1;
                
                if(countZeros == countOnes){
                    sum = countZeros + countOnes;
                    if(largeVal < sum){
                        largeVal = sum;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            } //for j
        } //for i
        if(largeVal == Integer.MIN_VALUE){
            System.out.println("No such subarray");
            return;
        }
        System.out.println("Largest sub array with equal number of 0's and 1's is from index " + startIndex + " to " + endIndex);
    }
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find the largest sub array with equal number of 0's and 1's");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array of 0's and 1's");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findLargeSubArr_Optimized(arr);
        
        
    }
    
}
