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
 * Problem Description: Alternating split of a given linked list
 *                      Split the original list into 2 different lists, such that one list contains all nodes occurring at odd positions
 *                      and other list contains all nodes occurring at even positions
 *                      i.e., split the list without creating a new list. i.e., without changing the address of nodes
 * 
 * @author kumud
 * @version 1.0
 */
public class AlternatingSplitOfList {
    
    static Node head = null; //static variable that is common to all objects of a class
    
    static public Node[] createAlternateSplits(Node head, Node[] heads){ //TC: O(n), SC: O(1)
        if(!(head == null) || !(head.next == null)){ //we cannot create a split with one node or with an empty list
            heads[0] = head;
            heads[1] = head.next;
            Node p = head, temp;
            while(p != null){
                temp = p.next;
                p.next = (temp != null)? temp.next:temp;
                p = temp;
            }
        }
        
        return heads;
            
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes in a list
        int data; //node value
        int i; //loop variable
        Node[] heads = new Node[2];
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Alternating split of a given list");
        
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        
        System.out.println("Before creating an alternate split " );
        LinkedList_Operations.traverseList(head);
        
        heads = createAlternateSplits(head, heads);
        
        for(Node temp: heads){
            LinkedList_Operations.traverseList(temp);
        }
        
    }
}
