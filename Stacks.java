// Stacks Data Structure; Illinois State University; Scott Schmidt
// Working Java verision:  https://code.sololearn.com/ceZoqE80TaCp
// Python verision  https://github.com/ScottySchmidt/DataStructures/blob/main/Stacks.ipynb

import java.util.*;

// Create Stack Using Linked list
class Stack{
  
    // A linked list node
    private class Node {
        String data; // integer data
        Node link; // reference variable Node type
    }
    
    Node top; // create global top reference variable global

    // Constructor
    Stack()
    {
        this.top = null;
    }
  
    // Add an element x in the stack
    public void push(String x) // insert at the beginning
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
    public String peek()
    {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("Stack is empty");
            return "Empty";
        }
    }
  
    // Top element from the stack:
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
  
    // display data:
    public void display()
    {
        // check for stack underflow
        if (top == null) {
            System.out.println("\nStack Underflow");
        }
        else {
            Node temp = top;
            while (temp != null) {
  
                // print node data
                System.out.println("temp.data: "+temp.data);
  
                // assign temp link to temp
                temp = temp.link;
            }
        }
    }


    /* 
     SymbolChecker: manage the process of checking a file. 
     @param A Stack
     @param Scanner
     @lineNumber as an int 
    */
    public static boolean SymbolChecker(String expr)
    {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack
            = new ArrayDeque<Character>();

        int lineCount=0;
 
        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++)
        {
            char x = expr.charAt(i);
 
            if (x == '(' || x == '[' || x == '{')
            {
                // Push the element in the stack
                stack.push(x);
                lineCount++;
                //System.out.println(lineCount);
                continue;
            }
 
            //Stack cannot be empty must be closing item:
            if (stack.isEmpty()) {
                return false;
            }
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '(' ) {
                    System.out.println(" ) found match "+check+ " on line: "+lineCount );
                    return false;
                } else {
                    System.out.println("DOES NOT BALANCE. ) found matches "+check+ " on line: "+lineCount );
                    return true;
                }

            case '}':
                check = stack.pop();
                if (check == '{') {
                    System.out.println("} found does not match "+check+ " on line: "+lineCount );
                    return false;
                } else {
                    System.out.println("DOES NOT BALANCE. } found matches "+check+ " on line: "+lineCount );
                    return true;
                }
                    
            case ']':
                check = stack.pop();
                if (check == '[') {
                    System.out.println("] found does not match "+check+ " on line: "+lineCount );
                    return false;
                } else {
                    System.out.println("DOES NOT BALANCE. ] found matches "+check+ " on line: "+lineCount );
                    return true;
            }
        }
        }
        return (stack.isEmpty()); // Check Empty Stack
    }
    }

// main class
public class jUnitTesting {
    public static void main(String[] args)
    {
        // create Object of Implementing class
        Stack obj1 = new Stack();
        Stack obj2 = new Stack();
        
        // insert Stack value
        //obj.push("{");
        //obj.push("}");
        //obj.push("}");
  
        // print Stack elements
        // obj.display();
  
        // print Top element of Stack
        // System.out.println("\nTop element is %d " + obj.peek());
  
        // Delete top element of Stack
        // obj.pop();
        // obj.pop();
        // obj.display();
        // System.out.println("\nTop element is %d "+ obj.peek());

        obj1.SymbolChecker("(})");
        obj2.SymbolChecker("(]");
        obj2.SymbolChecker("()");
    }
}
