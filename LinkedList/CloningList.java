/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import java.util.HashMap;

/**
 * Problem Description:  Each node in a linked list consists of data, next pointer (pointing to next node), and
 *                       also a random pointer which points to a random node in the list. Give an algorithm for cloning the list
 * Application:          Implementation of snake and ladder game.
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class CloningList {
    static Node head = null; //static variable that is common to all objects of a class
//*******************************************************************************************************************************************************    
    static class Node{  //structure of node
        int data; //node value
        Node next; //next pointer
        Node randNext; //random pointer
        public Node(int data){
            this.data = data;
            this.next = null;
            this.randNext = null;
        }
    }
//***********************************************************Linked List Operations **********************************************************************   
    static public Node insertNodeAtRear(Node head, int data){ //Insertion operation
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head; //using temporary pointer to prevent loss of data
        while(temp.next != null)
              temp = temp.next;
        temp.next = newNode;
        return head;
    }
    
    static public void traverseList(Node head){ //Traversal operation
        if(head == null)
            return;
        while(head != null){
            System.out.print("Node : " + head.data);
            if(head.randNext != null)
                System.out.print(" Random pointer: " + head.randNext.data);
            if(head.next != null)
                System.out.println(" Next pointer: " + head.next.data);
            
            head = head.next;
        }
        
        System.out.println();
    }
//******************************************************************************************************************************************************
    
//**************************************************************Approaches******************************************************************************    
//Approach 2
    static public Node cloneList_V2(Node headOriginal, Node headClone){    //TC: O(n), SC: O(n)
        
        if(headOriginal == null){
            System.out.println("Empty Original List");
            return null;
        }
        
        Node temp,temp1; //using temporary pointers to prevent loss of data
        HashMap<Node,Node> hash = new HashMap<Node,Node>();
        
        for(temp = headOriginal; temp != null; temp = temp.next) //O(n) -> Creating clone without updating random pointer
            headClone = insertNodeAtRear(headClone, temp.data);
        
        for(temp = headOriginal,temp1=headClone; temp != null && temp1 != null; temp = temp.next, temp1 = temp1.next) //O(n)
            hash.put(temp, temp1); //storing corresponding nodes addresses
        
        for(temp = headOriginal; temp != null; temp = temp.next){ //O(n) -> Updating random pointer
            if(hash.containsKey(temp) && hash.containsKey((temp.randNext)))
                hash.get(temp).randNext = hash.get(temp.randNext);
        }
        
        return headClone;
        
    }
    
//Approach 3
    static public Node cloneList_V3(Node headOriginal, Node headClone){  //TC: O(n), SC: O(1)
        //Disadv: Original list is broken. Damage cannot be repaired
        
        if(headOriginal == null){
            System.out.println("Empty original list");
            return null;
        }
        
        Node temp,temp1,temp2;
        
        for(temp = headOriginal; temp!= null; temp = temp.next) //O(n)
            headClone = insertNodeAtRear(headClone,temp.data);
        
        for(temp = headOriginal,temp1=headClone; temp!=null && temp1!=null; temp1=temp1.next){ //-> Parallel mapping O(n)
            temp2 = temp.next;
            temp.next = temp1;
            temp1.randNext = temp.randNext;
            temp = temp2;
        }
        
        for(temp1 = headClone; temp1!=null; temp1 = temp1.next) //-> Updating random pointer O(n)
            temp1.randNext = temp1.randNext.next;
        
        return headClone;
    }
//Approach 4
    static public Node cloneList_V4(Node headOriginal, Node headClone){   //TC: O(n), SC: O(1)
        
        if(headOriginal == null){
            System.out.println("Empty original list");
            return null;
        }
        
        Node temp, temp1, temp2, temp3; //using temporary pointers to prevent loss of data
        
        for(temp = headOriginal; temp!=null; temp = temp.next) //O(n)
            headClone = insertNodeAtRear(headClone, temp.data);
        
        for(temp=headOriginal,temp1=headClone; temp!=null && temp1!=null;){ //Inserting new node in between in original list -> O(n)
            temp2 = temp.next;
            temp3 = temp1.next;
            temp1.next = temp2;
            temp.next = temp1;
            temp = temp2;
            temp1 = temp3;
        }
        
        for(temp=headOriginal; temp!=null; temp=temp.next.next) //Updating random pointer - O(n)
            temp.next.randNext = temp.randNext.next;
        
        //Now create alternate split
        temp=headOriginal;
        while(temp!=null){ //O(n)
            temp1 = temp.next;
            temp.next = (temp1!=null)? temp1.next:temp1;
            temp=temp1;
        }
        
        return headClone;
    }
    
//*********************************************************************************************************************************************************
    
    public static void main(String[] args){
        
        //creating a list
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        //connecting random pointers
        head.randNext = head.next.next; //ladder
        head.next.randNext = head.next.next.next; //ladder
        head.next.next.next.randNext = head; //snake
        head.next.next.randNext = head.next; //snake
        
        Node headClone = cloneList_V4(head, null);
        
        System.out.println("Orignal List");
        traverseList(head);

        System.out.println("Cloned List");
        traverseList(headClone);
        
    }
    
}
