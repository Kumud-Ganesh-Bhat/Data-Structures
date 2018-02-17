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
 * Problem Description: Add 1's to elements in the linked list
 *                      i.e., start with carry = 1 initially and add it to element in LL, thereafter keep adding carry.
 * @author kumud
 * @version 1.0
 * 
 */
public class AddOneToElementInLinkedList {
    
    static Node head = null; //static variable common to all objects of the class
    
    static public Node addOnes(Node head){  //TC: O(n), SC: O(1)
        if(head == null){
            System.out.println("Empty list encountered");
            return null;
        }
        
        head = LinkedList_Operations.reverseList(head);
        
        Node temp, prev=null; //using temporary pointers to prevent loss of data
        int carry = 1, sum = 0; //starting with value 1
        
        for(temp=head; temp!=null; temp=temp.next){
            sum = (temp.data + carry);
            carry = (sum >= 10)? 1:0; //updating carry for next calculation
            sum = sum%10;
            temp.data = sum;
            prev = temp;
        }
        
        if(carry > 0)
            prev.next = new Node(carry);
        
        head = LinkedList_Operations.reverseList(head);
        
        return head;
        
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes in a list
        int data; //node value
        int i; //loop variable
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Add 1's to element in the linked list");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        head = addOnes(head);
        LinkedList_Operations.traverseList(head);
    }
    
}
