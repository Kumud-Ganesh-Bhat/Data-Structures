/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import static datastructures.arrays.Separate_Zeros_Ones_V2.sepZerosOnes;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kumud
 */
public class Separate_Zeros_Ones_V3 {
    
    public static int[] sepZerosOnes(int[] arr){
        int l = 0; //left pointer
        int r = arr.length-1; //right pointer
        int temp; //temporary variable
        while(l<r){
            while(arr[l]%2 ==0 && l<r)
                l++;
            while(arr[r]%2 !=0 && r>l)
                r--;
            if(l<r){
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
            }
        }
        
        return arr;
    }
    
    public static void main(String[] args){
        int n; //number of elements
        int[] arr; //array of elements;
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        arr = sepZerosOnes(arr);
        System.out.println("After separating 0's and 1's " + Arrays.toString(arr));
    }
    
}
