/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description: Given an array of n numbers, using which construct/find maximum multiple of three
 * @author kumud
 * @version 1.0
 * 
 */
public class MaxMultipleOfThree {
    
    public static void findMaxMultipleOf3(int[] arr){
        
        ArrayList<Integer> q0 = new ArrayList<Integer>(); // data structure holding elements whose modulo 3 is 0
        ArrayList<Integer> q1 = new ArrayList<Integer>(); //data structure holding elements whose modulo 3 is 1
        ArrayList<Integer> q2 = new ArrayList<Integer>(); //data structure holding elements whose modulo 3 is 2
        
        int i; //loop variable
        int sum =0; //variable holding sum of all elements of an array
        int n = arr.length;
        
        Arrays.sort(arr); //Sorting elements in non decreasing order
        
        for(i=0; i<arr.length; i++){
            sum+= arr[i];
            if(arr[i]%3 == 0)
                q0.add(arr[i]); //categorizing element with modulo zero to q0
            else if(arr[i]%3 == 1)
                q1.add(arr[i]); //categorizing element with modulo one to q1
            else
                q2.add(arr[i]); //categorizing element with modulo two to q2
        }
        
        
        i=0;
        
        if(sum % 3 == 1){
            if(!(q1.isEmpty())){
                q1.remove(i++); //deleting one element from q1 - First In First Out
                n--;
            } //nested if
            else{
                  //deleting two elements from q2
                   if(!(q2.isEmpty())){
                      q2.remove(i++);
                      n--;
                    } //nested if
                    else
                        return ;
                
                    if(!(q2.isEmpty())){
                        q2.remove(i++);
                        n--;
                    } //nested if
                    else
                     return ;
                
            } //else
            
        } //if
        else if(sum % 3 == 2){
            if(!(q2.isEmpty())){ //deleting one element from q2
                q2.remove(i);
                n--;
            } //nested if
            else{
                //deleting two elements from q1
                if(!(q1.isEmpty())){
                    q1.remove(i++);
                    n--;
                } //nested if
                else
                    return;
                
                if(!(q1.isEmpty())){
                    q1.remove(i++);
                    n--;
                } //nested if
                else
                    return;
                
            } //else 
        } //else if
          
        i=0;
        Integer[] temp = new Integer[n]; //temporary array storing remianing elements
        for(Integer e0 : q0)
               temp[i++] = e0;
        for(Integer e1: q1)
               temp[i++] = e1;
        for(Integer e2: q2)
               temp[i++] = e2;
        Arrays.sort(temp, Collections.reverseOrder());//Sorting in reverse order i.e., in descending order
        
        System.out.println("Maximum multiple of 3");
        
        for(i=0 ; i<temp.length; i++)
            System.out.print(temp[i]);
        
        
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[] arr; //array of elements
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Maximum Multiple of 3");
        
        System.out.println("Enter the number of elements");
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        for(i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        findMaxMultipleOf3(arr);
        
        System.out.println();
        
    } //main
     
} //class
