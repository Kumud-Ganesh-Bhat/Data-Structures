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
 * Problem Description: Given a set of n+2 elements
 *                      1 <= a[i] <= n
 *                      every element of an array occurs atmost once except two elements
 *                      Find those two repeating elements
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindTwoRepeatingElements {
    
    public static void findTwoRepeatedElements_Optimized_V5(int[] arr, int n, int temp){ //TC: O(n), Auxillary space: O(1)
        
        int i; //loop variable
        HashSet<Integer> hash = new HashSet<Integer>();
        
        for(i=0; i<n; i++){
            if(arr[Math.abs(arr[i])] < 0)
                hash.add(Math.abs(arr[i]));
            else
              arr[Math.abs(arr[i])]*= -1;  
        }
        
        if(hash.isEmpty()){
            System.out.println("No repeated elements found");
            return;
        }
        
        Iterator hashIterator = hash.iterator();
        while(hashIterator.hasNext())
            System.out.print(hashIterator.next() + " ");
        
        System.out.println();
    }
    
    
    
    public static void findTwoRepeatedElements_Optimized_V4(int[] arr, int n, int temp){ //TC: O(n), SC: O(1)
        
        int i; //loop variable
        int xor_arr = arr[0]; //exclusive or of all array elements
        int xor_n = 1; //exclusive or of all n elements
        int xor_xy =0 ; //exclusive or of two repeated elements say x and y
        int set_bit; //variying bit of two repeated numbers (it can be lsb, msb and so on)
        int x=0,y=0;
        
        for(i=1; i<arr.length; i++)
             xor_arr^= arr[i];
        for(i=2; i<=temp; i++)
            xor_n^= i;
        xor_xy = xor_arr ^ xor_n;
        
        set_bit = ((xor_xy) & ~(xor_xy - 1));
        
        for(i=0; i<arr.length; i++){     //partitioning into two groups based on set bits
            if((arr[i] & set_bit) != 0)
                x^= arr[i];
            else
                y^= arr[i];
            
        }
        
        for(i=1; i<=temp; i++){
            if((i & set_bit) != 0)
                x^= i;
            else
                y^= i;
        }            
        
        System.out.println(x + " " + y);
    }
    
    public static void findTwoRepeatedElements_Optimized_V3(int[] arr, int n, int temp){
        
        int i; //loop variable
        int sum_arr = 0; //sum of all array elements
        int sum_n = 0; //sum of first n i.e., n-2 here natural numbers
        int prod_arr = 1; //product of all array elements
        int prod_n = 1; //product of first n natural numbers
        int xSumy, xPrody, xDiffy;
        int x,y;
        
        for(i=0; i<n; i++){
            sum_arr+= arr[i];
            prod_arr*= arr[i];
        }
        sum_n = (temp * (temp+1))/2 ;
        for(i=1; i<=temp; i++)
            prod_n*= i;
        
        xSumy = sum_arr - sum_n; //(x+y)
        xPrody = prod_arr/prod_n;
        
        xDiffy = (int)Math.sqrt((double)(Math.pow(xSumy,2)) - (double)(4*xPrody)); //(x-y)
        
        x = (xSumy - xDiffy)/2;
        y = xSumy - x;
        System.out.println(x + " " + y);
        
        
        
    }
    
    public static void findTwoRepeatedElements_Optimized_V2(int[] arr, int n, int temp){ //TC: O(n), SC: O(1)
        int[] count = new int[temp+1]; //array that keeps track of count..i.e., number of occurrences of each key
        int i; //loop variable
        for(i=0; i<n; i++)
            count[arr[i]]+=1;
        for(i=0; i<count.length; i++){
            if(count[i] == 2)
                System.out.print(i + " ");
        }
        System.out.println();
        
    }
    
    //Naive or Brute Force approach - TC: O(n^2), SC: O(1) i.e., auxillary space complexity is O(1)
    public static void findTwoRepeatedElements(int[] arr, int n, int temp){
        
        int i, j; //loop variables
        int count; //variable that keeps track of count
        HashSet<Integer> hash = new HashSet<Integer>();
        
        for(i=0; i<n; i++){
            count = 1;
            for(j=i+1; j<n; j++){
                if(arr[i] == arr[j])
                    count+=1;
            } //for j
            
            if(count == 2)
                hash.add(arr[i]);
        } //for i
        
        if(hash.isEmpty()){
            System.out.println("No repeating elements found"); //which shouldn't be case because we check entries of range of array numbers
            return;
        }
        
        Iterator hiterator = hash.iterator();
        while(hiterator.hasNext())
            System.out.print(hiterator.next() + " ");
        
        System.out.println();
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int i; //loop variable
        int[] arr; //array of elements
        int temp, temp1; //temporary variables
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find two repeating elements in an array ");
        
        System.out.println("Enter the total number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        temp = n-2;
        
        System.out.println("Enter the array elements and it should fall in the range from 1 to " + temp + " ");
        for(i=0; i<n; i++){
             temp1 = sc.nextInt();
             if(temp1 >=1 && temp1 <= temp)
                 arr[i] = temp1;
             else{
                 System.out.println("Invalid entry");
                 System.exit(0);
             }
        }
        
        //findTwoRepeatedElements(arr, n, temp);
        //findTwoRepeatedElements_Optimized_V2(arr, n, temp);
        //findTwoRepeatedElements_Optimized_V3(arr, n, temp);
        //findTwoRepeatedElements_Optimized_V4(arr, n, temp);
        findTwoRepeatedElements_Optimized_V5(arr, n, temp);
        
    }
    
}
