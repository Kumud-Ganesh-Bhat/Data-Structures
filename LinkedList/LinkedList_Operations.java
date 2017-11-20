/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;

/**
 * We perform 3 operations on linked list
 * 1. Traversal (Printing the elements of linked list)
 * 2. Insertion
 * 3. Deletion
 * 
 * @author kumud
 * @version 1.0
 */
public class LinkedList_Operations {
    
    static Node head; //it is like a pointer referring to first element of the linked list
    
    public static Node insertNodeAtFront(Node head, int data){ //O(1)
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return head;
        }
        Node temp = head; //using temporary pointer to prevent losing of data
        newNode.next = temp;
        head = newNode;
        return head;
    }
    
    public static Node insertNodeAtRear(Node head, int data){ //O(n)
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
    
    public static Node insertNodeAtMiddle(Node head, int key, int data){ //in worst case O(n)
        Node newNode = new Node(data);
        if(head == null){
            System.out.println("List is empty, so node is inserted in the beginning");
            head = newNode;
            return head;
        }
        Node temp = head; //using temporary pointer to prevent loss of data
        while(temp!= null && temp.data != key)
              temp = temp.next;
        if(temp == null){
            System.out.println("No key found. Hence node cannot be inserted");
            return head;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
        
        return head;
    }
    
    public static Node deleteNodeAtFront(Node head){
        if(head == null){
            System.out.println("List is empty. Cannot be deleted");
            return head; //returning null
        }
        Node temp = head; //using temporary pointer to prevent loss of data
        head = temp.next;
        
        temp = null;
        System.gc();
       
        return head;
    }
    
    public static Node deleteNodeAtRear(Node head){
        if(head == null){
            System.out.println("List is empty. Cannot be deleted");
            return head; //returning null
        }
        Node prev = null; //reference to keep track of previous node
        Node temp = head; //using temporary pointer to prevent loss of data
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp = null;
        System.gc();
        return head;
    }
    
    public static Node deleteNodeAtMiddle(Node head, int key){
        if(head == null){
            System.out.println("List is empty. Cannot be deleted");
            return head; //returning null
        }
        Node prev = null;
        Node temp = head;
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Node to be deleted not found");
            return head;
        }
        prev.next = temp.next;
        temp = null;
        System.gc();
        return head;
    }
    
    //Iterative version
    public static void traverseList(Node head){
        if(head == null){
           System.out.println("List is empty");
           return;
        }
        Node temp = head; //using temporary variable to prevent loss of data
        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
        
    }
    
    //Recursive version
    public static void traverseList_Recursive(Node head){
        if(head == null){
            return;
        }
        Node temp = head; //using temporary variable to prevent loss of data
        System.out.print(temp.data + " -> ");
        traverseList_Recursive(temp.next);
    }
    
    public static void printReverseList(Node head){
        if(head == null){
            //System.out.println("List is empty");
            return;
        }
        Node temp = head;//using temporary variable to prevent loss of data
        printReverseList(temp.next);
        System.out.print(temp.data + " -> ");
    }
    
    //Iterative version
    public static Node reverseList(Node head){
        if(head == null){
            System.out.println("List is empty");
            return head;
        }
        Node prev = null; //keeping track of previous node
        Node cur = head; //keeping track of current node that we are working on
        Node next = null; //keeping track of next node
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
    
    //Recursive version
    public static Node reverseList_Recursive(Node prev, Node cur){
        if(cur == null)
            return prev;        
        else{
            reverseList_Recursive(cur, cur.next);
            cur.next = prev;
        }
        
        return prev;
    }
    
    public static Node moveLastToFirst(Node head){ //O(n)
        if(head == null){
            System.out.println("List is empty");
            return head; //returning null
        }
        Node prev = null;
        Node temp = head; //using temporary pointer to prevent loss of data
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = null;
        temp.next = head;
        head = temp;
              
        return head;
    }
    
    
    
    public static void main(String[] args){
        
        //variables local to main method
        int choice, ch;
        int data;
        char proceed = 'Y'; //continuing program execution
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Linked List Operations");
        System.out.println("1. Insertion" +  "\n" +
                           "2. Deletion" + "\n" +
                           "3. Traversing" + "\n" +
                           "4. Reversal" + "\n" +
                           "5. Moving Last Node to First");
        while(proceed == 'Y'){
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            switch(choice){
                case 1: System.out.println("Inserting a node into Singly Linked List");
                        System.out.println("1. Front End" + "\n" + "2. Rear End" + "\n" +"3. After a particular node");
                        while(proceed == 'Y'){
                            System.out.println("Enter your choice");
                            ch = sc.nextInt();
                    
                            //Nested switch
                            switch(ch){
                                case 1: System.out.println("Inserting an element at front end of linked list");
                                        System.out.println("Enter the node value to be inserted");
                                        data = sc.nextInt();
                                        head = insertNodeAtFront(head, data);
                                        break;
                                case 2: System.out.println("Inserting an element at rear end of linked list");
                                        System.out.println("Enter the node value to be inserted");
                                        data = sc.nextInt();
                                        head = insertNodeAtRear(head, data);
                                        break;
                                case 3: int key;
                                        System.out.println("Inserting an element after a particular node");
                                        System.out.println("Enter the node value to be inserted");
                                        data = sc.nextInt();
                                        System.out.println("Enter the value of node, after which new node should be inserted");
                                        key = sc.nextInt();
                                        head = insertNodeAtMiddle(head, key, data);
                                        break;
                                default: System.out.println("Wrong choice");
                                         break;
                                 } //nested switch
                            System.out.println("Do you want to continue Insertion ?");
                            proceed = sc.next().charAt(0);
                        } //while
                        break;
                    
                case 2: System.out.println("Deleting an element from Singly Linked List");
                        System.out.println("1. Front End" + "\n" + "2. Rear End" + "\n" + "3. After a particular node");
                        while(proceed == 'Y'){
                            System.out.println("Enter your choice");
                            ch = sc.nextInt();
                    
                            //nested switch
                            switch(ch){
                                case 1: System.out.println("Deleting an element at the front end of linked list");
                                        head = deleteNodeAtFront(head);
                                        break;
                                case 2: System.out.println("Deleting an element at the rear end of the linked list");
                                        head = deleteNodeAtRear(head);
                                        break;
                                case 3: int key;
                                        System.out.println("Deleting a particular node");
                                        System.out.println("Enter the node value to be deleted");
                                        key = sc.nextInt();
                                        head = deleteNodeAtMiddle(head, key);
                                        break;
                                default: System.out.println("Wrong choice");
                                         break;
                            }//nested switch
                            System.out.println("Do you want to continue deletion");
                            proceed = sc.next().charAt(0);
                        } //while
                        break;
                    
                case 3: System.out.println("Traversing a Singly linked list");
                        traverseList(head); //Iterative version
                        System.out.println("Printing elements of a list in reverse order");
                        printReverseList(head);
                        System.out.println();
                        break;
            
                case 4: System.out.println("Reversing a Singly Linked List ");
                        head = reverseList(head); //Iterative version
                        break;
                    
                case 5: System.out.println("Moving last node to the front end of linked list");
                        head = moveLastToFirst(head);
                        break;
                    
                default: System.out.println("Wrong choice");
                         break;
                } //outer switch
          
                System.out.println("Do you want to continue ?");
                proceed = sc.next().charAt(0);
        } //while
        
    } //main
} //class

