/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;

import datastructures.linkedlist.Node;
import datastructures.linkedlist.LinkedList_Operations;
import datastructures.linkedlist.FindLoopInList;

/**
 * Problem Description: To detect whether loop exists in a linked list and to print the starting node where loop begins
 *                      TC: O(n), SC: O(1)
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FloydCycleDetectionAlgorithm {
    
    static Node head = null; //static variable that is commom to all objects of a class
    
    static public void DetectLoopAndFindStartNode(Node head){
        
         if(head == null){
             System.out.println("List is empty");
             return;
         }
         
         Node slow_ptr=head, fast_ptr=head;
         boolean loopExists = false;
         
         while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null){
             slow_ptr = slow_ptr.next;
             fast_ptr = fast_ptr.next.next;
             if(slow_ptr == fast_ptr){
                 loopExists = true;
                 break;
             }
         }
         
         if(loopExists == true){
             slow_ptr = head;
             while(slow_ptr != null && fast_ptr != null){
                 slow_ptr = slow_ptr.next;
                 fast_ptr = fast_ptr.next;
                 if(slow_ptr == fast_ptr){
                     System.out.println("Loop exists at node " + slow_ptr.data);
                     break;
                 }
             }
             if(slow_ptr == null || fast_ptr == null){
                 System.out.println("No loop");
                 return;
             }
         }
         
         else{
             System.out.println("No loop");
             return;
         }
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Floyd's Cycle detection algorithm");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        head = FindLoopInList.createLoop(head);
        
        DetectLoopAndFindStartNode(head);
    }
    
}
