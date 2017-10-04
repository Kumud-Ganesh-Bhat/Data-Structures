/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Statement: Finding majority element in a sorted array using Linear Search
 * Majority element is the one that is occurring more than n/2 times
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindMajorityElement {
    
    public static void findMajorityElement(int[] arr, int n){
        int i,j; //loop variables
        for(i=0; i<=n/2; i++){ //Time complexity O(n/2)
            j= i+n/2;
            if(arr[i] == arr[j]){
                System.out.println("Majority elements is" + " " + arr[i]);
                break;
                
            }
        }
        
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding majority element in a sorted array using Linear Search");
        
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements in sorted order");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findMajorityElement(arr,n);
    }
    
}
