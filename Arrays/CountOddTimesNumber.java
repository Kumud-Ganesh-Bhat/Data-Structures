/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Problem Statement: Count number occurring odd number of times in an array of size n
 * 
 *
 * @author kumud
 * @version 1.0
 * 
 */
public class CountOddTimesNumber {
    
    public static int findMax(int[] arr){
        int i; //loop variable
        int maxValue=0; //maximum element
        for(i=0; i<arr.length; i++)
            maxValue = (maxValue > arr[i]) ?  maxValue:arr[i];
        return maxValue;
    }
    
    public static void countOddNumber(int[] arr){
        int maxElement = findMax(arr);
        int[] count = new int[maxElement+1];
        int i;
        
        for(i=0; i<arr.length; i++){
            count[arr[i]]+=1;
        }
        
        for(i=0; i<count.length; i++){
            if(count[i]%2 != 0)
                System.out.println("Number occuring odd number of times:" + i);
                
        }
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Counting number occurring odd number of times in an array");
        
        System.out.println("Enter the number of elements");
        n=sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        countOddNumber(arr);
    }
    
}
