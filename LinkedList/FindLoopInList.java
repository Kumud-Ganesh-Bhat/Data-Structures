/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import java.util.HashMap;

import datastructures.linkedlist.Node;
import datastructures.linkedlist.LinkedList_Operations;

/**
 * Problem Description: Find loop in a linked list
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindLoopInList {
    
    static Node head = null; //static variable that is common to all objects of a class
    
    
    static public void findLoop_V1(Node head){   //TC: O(n), SC: O(n)
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        Node temp = head;
        
        while(!(hash.containsValue(temp.hashCode())) && temp != null){
            hash.put(temp.data, temp.hashCode());
            temp = temp.next;
        }
        
        if(temp == null){
            System.out.println("No loop in list");
            return;
        }
        
        System.out.println("Loop exists at node " + temp.data);
    }
    
    /*
    static public void findLoop_V2(Node head){  //TC: O(n), SC: O(1)
           if(head == null){
               System.out.println("List is empty");
               return null;
           }
           Node temp = head;
           while(temp != null){
               if(temp.visited == 1)
                    break;
               temp.visited = 1;
               temp = temp.next;
           }
           if(temp == null){
            System.out.println("No loop in list");
            return;
          }
          System.out.println("Loop exists at node " + temp.data);
    }
    */
    
    
    static public Node createLoop(Node head){
        
        if(head == null)
            return null;
        
        Node temp = head;

        while(temp.next != null)
            temp = temp.next;
        
        temp.next = head.next; //loop created at second node
        
        return head;
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding loop in a linked list");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        head = createLoop(head);
        
        findLoop_V1(head);
       
        
    }
    
}
