/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;
import java.util.Scanner;
import datastructures.linkedlist.Node;
import datastructures.linkedlist.LinkedList_Operations;

/**
 * Problem Description:  Sort a linked list of zeros, ones, and two's.
 *                       This problem is similar to Dutch NAtional Flag problem for arrays. However following the same approach here is quite tricky
 * @author kumud
 * @version 1.0
 */
public class SortList_Zeros_Ones_Twos {
    static Node head = null; //static variable common to all the objects of a class
    
    static public void sortList012(Node head){ //TC:O(n), SC:O(1)
        
        if(head == null){
            System.out.println("Empty list encountered");
            return ;
        }
        
        int[] count = new int[3]; //array containing number of occurrences of 0's, 1's and 2's in linked list
        int i=0; //loop variable
        Node temp; //using temporary pointer to prevent loss of data
        
        for(temp=head; temp!=null; temp = temp.next)
            count[temp.data]+= 1;
        
        temp = head;
        
        while(temp!=null){
            if(count[i]==0)
                i++; //go to next element
            else{
                temp.data = i;
                count[i]-=1;
                temp = temp.next;
            }
        }
         LinkedList_Operations.traverseList(head);
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Sorting linked list of 0's 1's and 2's");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        sortList012(head);
        
    }
    
}
