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
 * Problem Description: Merge two sorted linked lists into one sorted linked list
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class MergeTwoSortedLists {
    
    static Node head1, head2; //static variable that is common to all objects of the class
    
    static public Node merge_V2(Node head1, Node head2){  //TC: O(m+n), SC: O(1)
        if(head1 == null || head2 == null){
            System.out.println("Empty list encountered");
            return null;
        }
        
        Node mergedList; //pointer pointing to first node of merged list
        Node temp; //temporary pointer
        
        if(head1.data < head2.data){
            mergedList = head1;
            head1 = head1.next;
        }
        
        else{
            mergedList = head2;
            head2 = head2.next;
        }
        
        temp = mergedList;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        
        if(head1 == null)
            temp.next = head2;
        else
            temp.next = head1;
        
        return mergedList;
    }
    
    static public Node merge_V1(Node head1, Node head2){ 
        //TC: O(m*n) -> Running time increases as size of list grows and number of observations increases
        if(head1 == null || head2 == null){
            System.out.println("Empty list encountered");
            return null;
        }
        Node temp1=head1, temp2=head2, prev = null, next = null; //using temporary pointers to prevent loss of data
        
        while(temp1 != null){
            next = temp1.next;
            temp2 = head2;
            while(temp2 != null && temp2.data < temp1.data){
                prev = temp2;
                temp2 = temp2.next;
            }
            if(prev == null){
                prev = temp1;
                temp1.next = temp2;
                head2 = prev;
                
            }
            else{
                temp1.next = temp2;
                prev.next = temp1;
            }
            
            temp1=next;
        }
        
        return head2;
        
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        
        Node mergedList;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Merge two sorted lists into one sorted linked list");
        
        //Creating first sorted linked list
        System.out.println("Enter the number of nodes in 1st list ");
        n = sc.nextInt();
        System.out.println("Enter the first list values in sorted order");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head1 = LinkedList_Operations.insertNodeAtRear(head1, data);
        }
        
        //Creating second sorted linked list
        System.out.println("Enter the number of nodes in 2nd list");
        n = sc.nextInt();
        System.out.println("Enter the second list values in sorted order");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head2 = LinkedList_Operations.insertNodeAtRear(head2, data);
        }
        
        mergedList = merge_V2(head1, head2);
        
        System.out.println("Merged List");
        LinkedList_Operations.traverseList(mergedList);
        
    }
    
}
