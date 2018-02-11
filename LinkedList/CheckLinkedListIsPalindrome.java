/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import java.util.Stack;
import datastructures.linkedlist.Node;
import datastructures.linkedlist.LinkedList_Operations;
import datastructures.linkedlist.ReverseList;


/**
 * Problem Description: Check whether linked list is palindrome or not
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class CheckLinkedListIsPalindrome {
    static Node head = null; //static variable that is ocmmon to all objects of the class
    
    static public Node cloneList(Node head){ //O(n)
        if(head == null)
            return null; //list is empty
        Node headClone=null,temp;
        for(temp=head; temp!=null; temp=temp.next)
            headClone = LinkedList_Operations.insertNodeAtRear(headClone, temp.data);
        return headClone;
    }
    
    static public Node findMiddleNode(Node head){ //O(n)
        if(head == null)
            return null; //list is empty
        Node slow_ptr = head;
        Node fast_ptr = head;
        while(slow_ptr !=null && fast_ptr != null && fast_ptr.next != null){
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        if(slow_ptr != null)
            return slow_ptr;
        return null;
    }
    
    static public void isPalindrome_V3(Node head){  //TC: O(n), SC: O(1)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node middleNode = findMiddleNode(head); //O(n)
        Node midNode_Next = ReverseList.reverseList(middleNode.next); //reversing the second half -> O(n)
        Node temp,temp1; //using temporary pointers to prevent loss of data
        boolean isPalindrome = true;
        
        for(temp=head,temp1=midNode_Next; temp!=null && temp1!=null; temp=temp.next, temp1=temp1.next){ //O(n/2) -> O(n)
            if(temp.data != temp1.data){
                isPalindrome = false;
                break;
            }
        }
        
        if(isPalindrome == true)
            System.out.println("List is palindrome");
        else
            System.out.println("List is not a palindrome");
        
    }
    
    static public void isPalindrome_V2(Node head){ //TC: O(n), SC: O(n)
        
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        Node temp;
        int count=0,i=1;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(temp=head; temp!=null; temp=temp.next){
            count++;
            stack.push(temp.data);
        }
        temp=head;
        while((i <= ((count%2 !=0)? (count/2-1):count/2)) && temp!=null && !(stack.isEmpty())){    //TC: O(n/2)-> O(n), SC: O(n)
            if(temp.data != stack.pop()){
                isPalindrome = false;
                break;
            }
            i++;
            temp = temp.next;
        }
        
        if(isPalindrome == true)
            System.out.println("Linked List is palindrome");
        else
            System.out.println("Linked List is not palindrome");
    }
    
    static public void isPalindrome_V1(Node head){  //TC: O(n), SC: O(n)
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp,temp1; //using temporary variables to prevent loss of data
        Node headClone = cloneList(head);
        headClone = ReverseList.reverseList(headClone);
        boolean isPalindrome = true;
        for(temp=head,temp1=headClone; temp!=null && temp1!=null; temp=temp.next,temp1=temp1.next){
            if(temp.data != temp1.data){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome == true)
            System.out.println("Linked List is palindrome");
        else
            System.out.println("Linked List is not a palindrome");
    }
    
    public static void main(String[] args){
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        Scanner sc = new Scanner(System.in);
        System.out.println("Check whether given linked list is a palindrome or not");
        System.out.println("Enter the number of nodes");
        n = sc.nextInt();
        System.out.println("Enter the node values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head = LinkedList_Operations.insertNodeAtRear(head, data);
        }
        isPalindrome_V3(head);
    }
}
