/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import datastructures.linkedlist.CloningList.Node;
import datastructures.linkedlist.ReverseList;


/**
 * Problem Description: Consider a singly linked list with each node having an arbitrary pointer.
 *                      Initial value of arbitrary pointer for all the nodes is null
 *                      Give an algorithm to make arbitrary pointer point to greatest value node in a linked list on its right side
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class GreatestValueNodeRightSide {
    
    static Node head; //static variable that is common to all objects of the class
    
    static public Node reverseList(Node head){ //TC: O(n)
        if(head == null){
            System.out.println("Empty list");
            return head;
        }
        
        Node cur = head, prev = null, next; //using temporary pointers to prevent loss of data
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    static public Node populateArbitraryPointers_V2(Node head){  //TC: O(n), SC: O(1)
        if(head == null){
            System.out.println("Empty list encountered");
            return head;
        }
        head = reverseList(head);  //O(n)
        Node arbitrary = head, temp;
        for(temp = head.next; temp!=null; temp=temp.next){  //O(n)
            temp.randNext = arbitrary; //maximum element obtained so far
            if(temp.data > arbitrary.data)
                arbitrary = temp;
        }
        head = reverseList(head); //O(n)
        return head;
    }
    
    static public Node populateArbitraryPointers_V1(Node head){  //TC: O(n^2), SC: O(1)
        if(head == null){
            System.out.println("Empty list encountered");
            return head;
        }
        
        Node temp, temp1, arbitrary; //using temporary pointers to prevent loss of data
        int max = Integer.MIN_VALUE; //variable that keeps track of maximum value
        
        for(temp=head; temp!=null; temp=temp.next){
            arbitrary = null;
            max = Integer.MIN_VALUE;
            for(temp1=temp.next; temp1 != null; temp1 = temp1.next){
                if(temp1.data > max){
                    max = temp1.data;
                    arbitrary = temp1;
                }
            }
            temp.randNext = arbitrary;
        }
        
        return head;
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Populate arbitrary pointers of each node to the greatest element on its right side");
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = CloningList.insertNodeAtRear(head, data);
        }
        
        head = populateArbitraryPointers_V2(head);
        CloningList.traverseList(head);
    }
    
    
    
    
    
}
