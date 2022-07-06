// Stacks Data Structures; Illinois State University; Scott Schmidt
// Working Java verision:  https://code.sololearn.com/ceZoqE80TaCp

import java.util.*;


// Create Stack Using Linked list
class Stack{
  
    // A linked list node
    private class Node {
        int data; // integer data
        Node link; // reference variable Node type
    }
    
    Node top; // create global top reference variable global

    // Constructor
    Stack()
    {
        this.top = null;
    }
  
    // Add an element x in the stack
    public void push(int x) // insert at the beginning
    {
        // create new node temp and allocate memory
        Node temp = new Node();
  
        // check if stack (heap) is full. Then inserting an
        //  element would lead to stack overflow
        if (temp == null) {
            System.out.print("\nHeap Overflow");
            return;
        }
  
        temp.data = x; 
        temp.link = top; 
        top = temp; 
    }
  
    // Utility function to check if the stack is empty or not
    public boolean isEmpty()
    {
        return top == null;
    }
  
    // Return top element in a stack
    public int peek()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
  
    // Top element from the stack
    public void pop() // remove at the beginning
    {
        // check for stack underflow
        if (top == null) {
            System.out.print("\nStack Underflow");
            return;
        }
  
        // update the top pointer to point to the next node
        top = (top).link;
    }
  
    public void display()
    {
        // check for stack underflow
        if (top == null) {
            System.out.printf("\nStack Underflow");
        }
        else {
            Node temp = top;
            while (temp != null) {
  
                // print node data
                System.out.printf("%d->", temp.data);
  
                // assign temp link to temp
                temp = temp.link;
            }
        }
    }


    // function to check if brackets are balanced
    public static boolean Balanced(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
            = new ArrayDeque<Character>();
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }
        }
 
        // Check Empty Stack
        return (stack.isEmpty());
    }
}

// main class
public class stackTester {
    public static void main(String[] args)
    {
        // create Object of Implementing class
        Stack obj = new Stack();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
  
        // print Stack elements
        obj.display();
  
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());
  
        // Delete top element of Stack
        obj.pop();
        obj.pop();
  
        // print Stack elements
        obj.display();
  
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}
