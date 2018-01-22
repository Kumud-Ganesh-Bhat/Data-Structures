/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Problem Description: Find duplicates in an array in O(n) time
 *                      Constraints: 0<= x < n ; i.e., an element should fall between 0 and n where 0 is inclusive and n is exclusive
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindDuplicatesInLinearTime {
    
    public static void findDuplicates(int[] arr){
        
        int i; //loop variable
        int countNegative = 0; //variable that keeps track of negative numbers
        HashSet<Integer> hash = new HashSet<Integer>();
        
        for(i=0; i<arr.length; i++){
            if(arr[Math.abs(arr[i])] < 0)
                hash.add(Math.abs(arr[i]));
            else
                arr[Math.abs(arr[i])]*= -1;
        }
        
        for(i=0; i<arr.length; i++){
            if(arr[i] < 0)
                countNegative+= 1;
        }
        
        
        if(countNegative == 0){
            System.out.println("No duplicates found");
            return;
        }
        
        Iterator hashIterator = hash.iterator();
        while(hashIterator.hasNext())
            System.out.print(hashIterator.next() + " ");
        
        System.out.println();
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        int input;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Duplicates in O(n) time and O(1) space ");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements ranging from 0 to n-1 ");
        for(i=0; i<n; i++){
            input = sc.nextInt();
            if(input < n && input >= 0)
                 arr[i] = input;
            else{
                System.out.println("Invalid entry");
                System.exit(1); //Terminate the program
            }
        }
        
        findDuplicates(arr);
    }
    
}
