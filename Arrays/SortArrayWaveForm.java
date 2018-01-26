/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;

/**
 * Problem Description: Sort an array in wave form
 *                      arr[0] >= arr[1] <= arr[2] >= arr[3] <= .......
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class SortArrayWaveForm {
    
    public static int[] sortArrayWaveForm_V2(int[] arr, int n){  //TC: O(nlogn) , SC: O(1)
        
        int i; //loop variable
        int temp; //temporary variable
        
        Arrays.sort(arr); //O(nlogn)
        
        for(i=0; i<arr.length; i+=2){ //O(n/2)
            temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            
        }
        
        return arr;
    }
    
    public static int[] sortArrayWaveForm_V1(int[] arr, int n){    //TC: O(n), SC: O(1)
        
        int i; //loop variable
        int temp; //temporary variable
        
        for(i=0; i<arr.length; i+=2){
            
            if(i==0){
                if(arr[i] < arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                } //nested if
            } //if
            else if(i==n-1){
                if(arr[i] < arr[i-1]){
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                } //nested if
                
            } //else if
            
            else{
                if(arr[i] < arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
                if(arr[i] < arr[i-1]){
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                } 
                
            } //else
            
        }
        
        return arr;
        
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Sorting an array in wave form");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        arr = sortArrayWaveForm_V2(arr,n);
        
        System.out.println(Arrays.toString(arr));
    }
    
    
    
}
