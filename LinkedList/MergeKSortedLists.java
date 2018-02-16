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
 * Problem description: Merge K Sorted lists into single list
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class MergeKSortedLists {   //TC: O(kn), SC: O(1)
    
    static public Node merge(Node head1, Node head2){
        if(head1 == null || head2 == null)
            return null;
        Node mergeList = null; //pointer pointing to merged list
        Node temp; //tail o fnewly formed list
        if(head1.data < head2.data){
            mergeList = head1;
            head1 = head1.next;
        }
        else{
            mergeList = head2;
            head2 = head2.next;
        }
        temp = mergeList;
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
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
        return mergeList;
    }
    
    //Using merge sort approach - Divide and conquer
    static public Node merge_V2(Node[] head, int k){  //TC: O(kn * logk), SC: O(1)
        if(head.length == 0)
            return null; //empty lists
        int start , end ;
        while(k != 0){//Until all lists are merged
            start = 0;
            end = k;
            while(start < end){
                head[start] = merge(head[start++], head[end--]); //merging two lists at a time
            }
            if(start >= end)
                k = end;
            
        }
        return head[0];
    }
    
    static public Node merge_V1(Node[] head){ //TC:O(k^2*n), SC:O(1)
        
        if(head.length == 0)
            return null; //empty lists
        
        int i; //loop variable
        Node mergeList = null; //pointer pointing to merged list
        Node temp; //temporary pointer like tail of list
        
        //Using one list as reference list. Therefore remaining will be k-1 lists
        for(i=0; i<head.length-1; i++){   //O(k)
            if(mergeList != null) //merged list will become reference list in next iteration
                head[i] = mergeList; 
            mergeList = merge(head[i], head[i+1]); //O(kn)
            
        } //for
        
        return mergeList;
    }
    
    public static void main(String[] args){
        
        int n; //number of nodes in each list
        int data; //node value
        int i,j; //loop variables
        int k; //number of lists
        Node[] head; //array of pointers, pointing to k lists
        Node mergeList; //pointer pointing to merged list
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Merge K Sorted linked lists into one single list");
        
        System.out.println("Enter the number of linked lists");
        k = sc.nextInt();
        head = new Node[k];
        
        for(i=0; i<k; i++){
            System.out.println("Enter the number of nodes in list " + (i+1) + " ");
            n = sc.nextInt();
            System.out.println("Enter the node values");
            for(j=0; j<n; j++){
                data = sc.nextInt();
                head[i] = LinkedList_Operations.insertNodeAtRear(head[i], data);
            }
        }
        
        mergeList = merge_V2(head, k-1);
        
        System.out.println("Merged List");
        LinkedList_Operations.traverseList(mergeList);
        
    }
    
}
