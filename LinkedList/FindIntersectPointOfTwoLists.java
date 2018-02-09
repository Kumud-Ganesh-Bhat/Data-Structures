/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Stack;

import datastructures.linkedlist.Node;
import datastructures.linkedlist.LinkedList_Operations;

/**
 * Problem Description: Suppose there are two linked lists, both of which merge at some point and become a single linked list.
 *                      Find the node at which they merge.
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class FindIntersectPointOfTwoLists { 
    
    static Node head1 = null; //static variable that are common to all objects of the class
    static Node head2 = null;
    
    static public Node getIntersectNode(int diff, Node head1, Node head2){
        if(head1 == null || head2 == null)
            return null;
        for(int i=0; i<diff && head1 != null ; i++)
            head1 = head1.next;
        while(head1 != null && head2 != null){
            if(head1 == head2)
                break;
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    
    static public int getCountNodes(Node head){
        int count = 0;
        while(head != null){
            count+=1;
            head = head.next;
        }
        return count;
    }
    
    
    static public void findIntersectionPoint_V5(Node head1, Node head2){
        if(head1 == null || head2 == null){
            System.out.println("Encountered empty list. No intersection point");
            return;
        }
        
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Node temp1 = head1;
        Node temp2 = head2;
        Node value1 = null, value2 = null, value = null;
        
        while(temp1 != null){
            s1.push(temp1);
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            s2.push(temp2);
            temp2 = temp2.next;
        }
        
        while(!(s1.empty()) && !(s2.empty())){
            value1 = s1.pop();
            value2 = s2.pop();
            if(value1 != value2)
                break;
            if(value1 == value2)
                value = value1;
            
        }
        
        if(value != null)
            System.out.println("Intersection node " + value.data);
        else
            System.out.println("No intersection found");
    }
    
    static public void findIntersectionPoint_V4(Node head1, Node head2){    //TC: O(m+n), SC: O(1)
        if(head1 == null || head2 == null){
            System.out.println("Encountered empty list. No intersection point");
            return;
        }
        Node temp1 = head1; //using temporary pointer to prevent loss of data
        Node slow_ptr = head2; //slow pointer
        Node fast_ptr = head2;
        
        while(temp1.next != null)  //O(m)
            temp1 = temp1.next;
        temp1.next = head1; //intentionally creating loop
        
        while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null){    //O(n)
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
            if(slow_ptr == fast_ptr)  //detecting loop
                break;
        }
        
        //leave the fast pointer at its respective position which will be equal to number of nodes in cycle(loop) - size of first linked list
        slow_ptr = head2;
        while(slow_ptr != null && fast_ptr != null){ //in worst case O(n)
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
            if(slow_ptr == fast_ptr)
                break;
        }
        
        if(slow_ptr != null)
            System.out.println("Intersection point found at node " + slow_ptr.data);
        else
            System.out.println("No intersection found");
        
        temp1.next = null; //removing loop
    }
    
    static public void findIntersectionPoint_V3(Node head1, Node head2){   //TC: O(m+n), SC: O(1)
        if(head1 == null || head2 == null){
            System.out.println("Encountered empty list. No intersection point");
            return;
        }
        int m = getCountNodes(head1);
        int n = getCountNodes(head2);
        int diff = Math.abs(m-n);
        Node intersectNode;
        
        intersectNode = (m>n) ? getIntersectNode(diff, head1, head2): getIntersectNode(diff, head2, head1);
        
        if(intersectNode != null)
            System.out.println("Intersection point is at node: " + intersectNode.data);
        else
            System.out.println("No intersection found");
    }
    
    static public void findIntersectionPoint_V2(Node head1, Node head2){ //TC: O(m+n), SC: O(n)/O(m)
        if(head1 == null || head2 == null){
            System.out.println("Encountered empty list. No intersection point");
            return;
        }
        HashSet<Node> hash = new HashSet<Node>(); //hash data structures that stores addresses of node. We can also store hashcode instead
        Node temp1=head1, temp2=head2;
        while(temp1 != null){    //O(m) where m is the number of nodes in list1
            hash.add(temp1);
            temp1 = temp1.next;
        }
        while(temp2 != null){  //O(n) in worst case, where n is the number of nodes in list2
            if(hash.contains(temp2))
                break;
            temp2 = temp2.next;
        }
        
        if(temp2 == null)
            System.out.println("No intersection found");
        else
            System.out.println("Intersection point found at " + temp2.data);
    }
    
    static public void findIntersectionPoint_V1(Node head1, Node head2){ 
        //Assuming m = number of nodes in first list
        //Assuming n = number of nodes in second list
        //TC: O(m*n), SC: O(1)
        if(head1 == null || head2 == null){
            System.out.println("Encountered empty list. No intersection point");
            return;
        }
        Node temp1 = head1;
        Node temp2 = head2; //using temporary pointer to prevent loss of data
       
        outer:
        while(temp1 != null){
            temp2 = head2;
            while(temp2 != null){
                if(temp1 == temp2){
                   break outer;
                }
                temp2 = temp2.next;
            }
            
            temp1 = temp1.next;
        }
        
        if(temp1!= null )
            System.out.println("Intersection point is found at node " + temp1.data);
        else
            System.out.println("No intersection found");
        
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes
        int data; //node value
        int i; //loop variable
        Node temp;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Finding Intersection point of two linked lists");
        
        System.out.println("Enter the number of nodes in list1");
        n = sc.nextInt();
        
        System.out.println("Enter the list1 values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head1 = LinkedList_Operations.insertNodeAtRear(head1, data);
        }
        
        System.out.println("Enter the number of nodes in list2");
        n = sc.nextInt();
        
        System.out.println("Enter the list2 values");
        for(i=0; i<n; i++){
            data = sc.nextInt();
            head2 = LinkedList_Operations.insertNodeAtRear(head2, data);
        }
        
        temp = head1;
        while(temp.next != null)
             temp = temp.next;
        temp.next = head2.next; //creating intersection point
        
        findIntersectionPoint_V1(head1, head2);
        findIntersectionPoint_V2(head1, head2);
        findIntersectionPoint_V3(head1, head2);
        findIntersectionPoint_V4(head1, head2);
        findIntersectionPoint_V5(head1, head2);
    }
    
}
