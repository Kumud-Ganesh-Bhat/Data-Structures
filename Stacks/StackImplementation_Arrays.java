/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.stacks;
import java.util.Scanner;
/**
 * Stack - very old and most important data structure
 * LIFO - Last In First Out data structure
 * push and pull the data in same direction
 * 
 * Operations performed on stack
 * 1. Push
 * 2. Pop
 * 3. Display
 * 
 * Stacks can be implemented both using arrays and linked list
 * 
 * In linked list implementation of stacks -> Inserting at rear end
 *                                         -> Deleting at rear end .. because in stacks elements are pushed and pulled in only one direction
 * 
 * @author kumud
 * @version 1.0
 * 
 */
public class StackImplementation_Arrays {
    
    static int[] stack = new int[5]; //stack holding integers
    static int top = -1; //variable that always shows what is on top of the stack
    
    public static void push(int value){
        if(top == stack.length-1){
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }
    
    public static int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }
        int value = stack[top--];
        return value;
    }
    
    public static void display(){
        while(top != -1){
            System.out.print(stack[top--] + " , ");
        }
    }
    
    public static void main(String[] args){
        
        char proceed = 'Y';
        int choice;
        int value;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Implementation of stack using arrays");
        System.out.println("1.Push" + "\n" + "2. Pop" + "\n" + "3.Display");
        
        while(proceed == 'Y'){
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            
            switch(choice){
                case 1: System.out.println("Performing push operation on the stack");
                        System.out.println("Enter the value of an element to be pushed onto the stack");
                        value = sc.nextInt();
                        push(value);
                        break;
                        
                case 2: System.out.println("Performing pop operation on the stack");
                        value = pop();
                        System.out.println("Value popped is" + value);
                        break;
                        
                case 3: System.out.println("Traversing and printing elements of the stack");
                        display();
                        System.out.println();
                        break;
                        
                default: System.out.println("Wrong choice");
                         break;
            }
            
            System.out.println("Do you want to continue ?");
            proceed = sc.next().charAt(0);
        } //while
        
     } //main
} //class
