/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Implementation of Moore Voting Algorithm
 * Problem Statement: 
 *    Given an array A (sorted/unsorted) of size n. Find a majority element that occurs more than n/2 times
 * Procedure:
 *     1. Voting Procedure - Up_vote all the elements by itself - O(n)
 *        Find the difference by down_voting other elements using majority element
 *        If the difference is at least 1, then the element might be majority one
 * 
 *     2. Scan the entire array again to make sure the count of majority element is >= (n+1/2)
 * 
 * Input: array of integers
 * Output: majority element
 *
 * @author kumud
 * @version 1.0
 * 
 */

public class MooreVotingAlgorithm {
    
    public static int getMajorityElement(int[] arr, int n){
        int voter = arr[0]; //starting from first element
        int voterCount = 1;
        int i; //loop variable
        for(i=1; i<n; i++){
            if(arr[i] == voter)
                voterCount++; //element upvoting by itself
            else if(voterCount >=1)
                voterCount--; //down voting other elements
            else{
                voter = arr[i];
                voterCount = 1;
            } //else
        } //if
        
        return (voterCount >= 1) ? voter:-1;
    }
    
    public static void isMajorityElement(int[] arr, int mElement){
        int i; //loop variable
        int count=0;
        for(i=0; i<arr.length; i++){
            if(arr[i] == mElement)
                count++;
        }
        if(count > arr.length/2)
            System.out.println(mElement + " is a majority element");
        else
            System.out.println("No majority element found");
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int mElement; //majority element
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Moore Algorithm Implementation");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        mElement = getMajorityElement(arr,n);
        
        if(mElement != -1)
            isMajorityElement(arr, mElement);
        else
            System.out.println("Majority element not found in the given input");
        
        
    }
    
}
