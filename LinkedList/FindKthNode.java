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
 * Problem Description: Find Kth node from end of the linked list
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindKthNode {
    
    static Node head = null; //static variable that is common to all objects of the class
    
    static public void findKthNode_V1(Node head, int k){    //Tc: O(n), SC: O(1)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head;
        int count = 0;
        int i=0; //loop variable
        
        while(temp != null){ //Traversing the list to find the count - O(n)
            count++;
            temp = temp.next;
        }
        
        count = count-k; //computing placement of required node from start
        temp = head;
        
        while(temp != null && i<count){
            temp = temp.next;
            i++;
        }
        
        if(temp == null)
            return;
        
        System.out.println("The " + k + "node from the end is " + temp.data);
        
        
    }
    
    static public void findKthNode_V2(Node head, int k){
        
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        
        Node p=head, q=head; //two reference pointers to linked list
        int count = 1;
        
        while(count < k && p != null){
            p = p.next;
            count++;
        }
        
        if(p == null)
            return; //kth node can't be found
        
        while(p.next != null){
            q = q.next;
            p = p.next;
        }
        
        System.out.println("The " + k + "node from the end is " + q.data);
        
        
    }
    
    static public void findKthNode_V3(Node head, int k){ //TC: O(n), SC: O(n) - Prevents traversing list twice but space complexity arises
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        Node temp = head; //using temporary pointer to prevent loss of data
        int count = 0;
        
        while(temp != null){
            count++;
            hash.put(count, temp.data); //storing node position and its value
            temp = temp.next;
        }
        
        count-=k; //computing placement of required kth node form beginning
        
        System.out.println("The kth node from end is " + hash.get(count+1));
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        int k; //kth node
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find kth node from end of the linked list");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        System.out.println("Enter the value of k");
        k = sc.nextInt();
        
        System.out.println("Created linked list");
        LinkedList_Operations.traverseList(head);
        
        findKthNode_V1(head,k);
        findKthNode_V2(head,k);
        findKthNode_V3(head,k);
        
    }
    
}
