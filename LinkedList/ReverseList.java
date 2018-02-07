/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import datastructures.linkedlist.LinkedList_Operations;
import datastructures.linkedlist.Node;

/**
 *
 * @author kumud
 */
public class ReverseList {
    
    static public Node reverseList(Node head){
        
        if(head == null){
            System.out.println("Empty list");
            return null;
        }
        
        Node prev, cur, next;
        
        cur = head;
        prev = null;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int i; //loop variable
        int data; //node value
        Node head = null;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Reversing the linked list");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        System.out.println("Before reversing list");
        LinkedList_Operations.traverseList(head);
        
        head = reverseList(head);
        
        System.out.println("After reversing list");
        LinkedList_Operations.traverseList(head);
        
    }
    
}
