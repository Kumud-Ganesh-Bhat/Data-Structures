/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;

/**
 * Search Algorithm: Algorithm that retrieves information stored in data structure
 * like Arrays, LinkedList, Hash Tables, Binary Search Trees etc.
 * Searching also encompasses algorithms that query the database such as SQL SELECT command
 * 
 * Problem Statement: 
 *                      Given a list L of n elements with values or records L0, L1, ..., Ln-1 and the target value T
 *                      the following subroutine uses Linear Search to find the index of target T in L
 * 
 * Procedure:
 *                      1. Set index to 0
 *                      2. if Li = T, search terminates successfully, return i
 *                      3. Increase i by 1
 *                      4. If i<array.length, go to Step 2. Otherwise search terminates unsuccessfully. return -1
 * 
 * Input: array of integers
 *        target value to be searched
 * 
 * Output:
 *        index of target value
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class LinearSearch {
    
    //Iterative approach
    public static int linearSearch(int[] arr, int n, int target){
        int i;
        for(i=0; i<n; i++){
            if(arr[i] == target)
                return i;
        }
        return -1;
    }
    
    //Recursive approach
    public static int recLinearSearch(int[] arr, int target, int i){
        if(arr[i] == target)
            return i;
        else if(i>=arr.length)
             return -1;
        else
            return recLinearSearch(arr, target, i+1);
    }

    
    public static void main(String[] args){
        int n; //size of the array
        int[] arr; //array of integers
        int i; //index variable
        int target; //target value to be searched
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Linear Search Implementation on Arrays");
        System.out.println("Enter the number of elements");
        
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        System.out.println("Enter the target value to be searched");
        target = sc.nextInt();
        
        i = linearSearch(arr, n, target);
        
        //Recursive approach
        // i = recLinearSearch(arr, target, 0);
        
        System.out.println("Element" + " "+ target + " " + "found at index" + " " + i);
        
        
    } //main
    
}
