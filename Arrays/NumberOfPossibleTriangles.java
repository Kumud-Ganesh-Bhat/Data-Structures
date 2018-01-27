/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description: Given an unsorted array of positive integers. 
 *                      Find the number of triangles that can be formed with 3 different elements as three sides of triangle
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class NumberOfPossibleTriangles {
    
    static public void findPossibleTrianglesCount_V2(int[] arr, int n){  //Time Complexity: O(n^2), SC: O(1)
        
        //Assuming all elements in an array are different
        
        int i,j,k; //loop or index variables
        int nTriangles =  0;
        
        Arrays.sort(arr);
        
        for(i=0; i<n-2; i++){
            k = i+2;
            for(j=i+1; j<n-1; j++){
                while(k<n && arr[i]+arr[j]>arr[k])
                    k++;
                nTriangles+= k-j-1;
            }
        }
        
        System.out.println("Number of possible triangles " + nTriangles);
    }
    
    static public void findPossibleTrianglesCount_V1(int[] arr, int n){ //Time Complexity: O(n^3), SC: O(1)
        
        int i,j,k; //loop or index variables
        int nTriangles = 0;
        
        for(i=0; i<n-2; i++){
            for(j=i+1; j<n-1; j++){
                for(k=j+1; k<n; k++){
                    if(arr[i] != arr[j] && arr[i] != arr[k] && arr[j] != arr[k]){
                        if(arr[i]+arr[j] > arr[k] && arr[i]+arr[k] > arr[j] && arr[j]+arr[k] > arr[i] ){ //a+b > c 
                            System.out.println(arr[i] + " , " + arr[j] + " , " + arr[k]);
                            nTriangles+=1;
                        }
                    } //if
                } //innermost for k
            } //inner for j
        } //outer for i
        
        System.out.println("Number of possible triangles: " + nTriangles);
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find the number of possible given triangles");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findPossibleTrianglesCount_V2(arr,n);
        
        
    }
    
}
