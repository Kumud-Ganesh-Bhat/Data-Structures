/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem Description: Rotate square matrix by 90 degree in anti-clockwise direction
 *                      TC: O(n^2), SC: O(1)
 * 
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class RotateSqaureMatrix90 {
    
    static public void rotateMatrix(int[][] arr, int n){
        
        int i =0,j=0,k=0; //loop variables
        int temp;
        
        //reverse elements in each row
        for(i=0; i<n; i++){
            for(j=0; j<n/2; j++){
                temp = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = temp;
            }
        }
        
        //find transpose of a matrix .i.e., make columns as rows
        for(i=0; i<n; i++){
            for(j=i; j<n; j++){
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        
        System.out.println("After Rotation: " + "\n" + Arrays.deepToString(arr));
    }
    
    public static void main(String[] args){
        
        int n; //number of elements
        int[][] arr; //array/matrix of elements
        int i,j; //loop variables
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Rotate the square matrix by 90 degrees ");
        
        System.out.println("Enter the value of n");
        n = sc.nextInt();
        arr = new int[n][n];
        
        System.out.println("Enter the matrix elements");
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Matrix before rotation: " + "\n" + Arrays.deepToString(arr));
        
        rotateMatrix(arr, n);
        
    }
    
}
