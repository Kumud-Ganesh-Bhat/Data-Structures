/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Description: Equilibrium Index
 * Given an array of size n, find an index such that sum of all the elements starting from 0 till that index is equal to sum of the remaining elements
 * 
 * @author kumud
 * @version 1.0
 */
public class EqulibriumIndex {
    //Approach 1: Naive Approach: Time Complexity: O(n^2), Space Complexity: O(1)
    public static int findEquilibriumIndex_V1(int[] arr){
        int eIndex = -1; //equilibrium index
        int i,j; //loop variables
        int lSum = 0; //left sum
        int rSum = 0; //right sum
        
        //Checking whether each index is an equilibrium index or not
        for(i=0; i<arr.length; i++){
            lSum+= arr[i];
            for(j=i+1; j<arr.length; j++)
                rSum+= arr[j];
            if(lSum == rSum){
                eIndex = i;
                break;
            }
            rSum = 0;
        }
        return eIndex;
    }
    
    //Approach 2: Time Complexity: O(n), Space Complexity: O(n)
    public static int findEquilibriumIndex_V2(int[] arr){
        int eIndex = -1;
        int i,j; //loop variables
        int[] lSum = new int[arr.length];
        int[] rSum = new int[arr.length];
        int temp = 0;
        
        //calculating left sum - O(n)
        for(i=0; i<arr.length; i++){
            temp+= arr[i];
            lSum[i] = temp;
        }
        
        temp = 0;
        
        //calculating right sum - O(n)
        for(j=arr.length-1; j>=0 ; j--){
            temp+= arr[j];
            rSum[j] = temp;
        }
        
        for(i=0; i<lSum.length; i++){  // - O(n)
            if(lSum[i] == rSum[i+1]){
                eIndex = i;
                break;
            }
        }
        return eIndex;
    }
    //Approach 3: Time Complexity: O(n), Space Complexity: O(1)
    public static int findEquilibriumIndex(int[] arr){
        int eIndex = 0; //equlibrium index
        int lIndex = 0; //left index
        int rIndex = arr.length-1; //right index
        int lSum = 0; //left sum
        int rSum = 0; //right sum
        
        while(lIndex < rIndex){
            lSum+= arr[lIndex];
            rSum+= arr[rIndex];
            if(lSum == rSum){
                eIndex = lIndex;
                break;
            }
            lIndex++;
            rIndex--;
        }
        
        if(lIndex == rIndex){
            if(lSum > rSum){
                rSum+=arr[rIndex];
                eIndex = (lSum ==  rSum)? lIndex-1:-1;
                
            }
            
            else{
                lSum+= arr[lIndex];
                eIndex = (lSum == rSum)? lIndex:-1;
            }
        }
        return eIndex;
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int eIndex; //equilibrium index
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Equlibrium Index");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        eIndex = findEquilibriumIndex_V2(arr);
        
        System.out.println("Equilibrium index is: " + eIndex);
        
    }
    
}
