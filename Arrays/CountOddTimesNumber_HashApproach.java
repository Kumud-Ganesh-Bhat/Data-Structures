/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Problem Description:
 *    Count the number occurring odd number of times in a given array of size n, such that only one number is occurring odd number of times
 * Approach: 
 *    Hash Approach
 *
 * @author kumud
 * @version 1.1
 * 
 */
public class CountOddTimesNumber_HashApproach {
    
    public static int getOddTimesNumber(int[] arr){
        int oddNumber =0;
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int i; //loop variable
        
        //Constructing hashmap with count.i.e., number of occurrences of each key
        for(i=0; i<arr.length; i++){
            if(hash.containsKey(arr[i]))
                hash.replace(arr[i], hash.get(arr[i]), hash.get(arr[i])+1);
            else
                hash.put(arr[i], 1); //when visiting element for first time
        }
        
        for(HashMap.Entry<Integer,Integer> entry: hash.entrySet()){
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();
            if(value%2 != 0)
                oddNumber = key;
        }
        
        return oddNumber;
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements
        int i; //index variable
        int result;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Counting the number occurring odd number of times");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i]=sc.nextInt();
        
        result = getOddTimesNumber(arr);
        
        System.out.println("Number occurring odd number of times: " + result);
        
    }
    
}
