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
 *
 * @author kumud
 */
public class FindMiddleNode {
    
    static Node head = null; //static variable common to all objects of a class
    
    static public void findMiddleNode_V1(Node head){  //TC:O(n), SC:O(1)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node temp = head; 
        int count = 0;
        
        while(temp != null){
            count++;
            temp = temp.next;
        }
        
        count = count/2;
        temp = head;
        
        for(int i=0; i<count; i++)
            temp = temp.next;
        
        System.out.println("Middle Node " + temp.data);
    }
    
    
    static public void findMiddleNode_V2(Node head){     //TC:O(n), SC:O(1)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node slow_ptr = head;
        Node fast_ptr = head;
        
        while(fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        
        System.out.println("Middle Node " + slow_ptr.data);
        
    }
    
    static public void findMiddleNode_V3(Node head){        //TC:O(n), SC:O(1)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node mid = head;
        Node temp = head;
        int count = 0;
        
        while(temp != null){
            if(count%2 != 0)
                mid = mid.next;
            count++;
            temp = temp.next;
        }
        
        if(mid != null)
            System.out.println("Middle Node " +mid.data);
        
    }
    
    public static void main(String[] args){
        
        int n; // number of nodes
        int data; //node value
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Find middle node of a linked list");
        
        System.out.println("Enter the number of nodes to be created");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        System.out.println("List created");
        LinkedList_Operations.traverseList(head);
        
        findMiddleNode_V1(head);
        findMiddleNode_V2(head);
        findMiddleNode_V3(head);
    }
    
}
