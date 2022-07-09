package ilstu.edu;
// Stacks Data Structure; Illinois State University; Scott Schmidt
// Working Java version:  https://code.sololearn.com/ceZoqE80TaCp
// Python version  https://github.com/ScottySchmidt/DataStructures/blob/main/Stacks.ipynb

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
// Create Stack Using Linked list
class Stack {
    // A linked list node
    private class Node {
        String data; // integer data
        Node link; // reference variable Node type
    }

    Node top; // create global top reference variable global

    // Constructor
    Stack() {
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
    public boolean isEmpty() {
        return top == null;
    }

    // Return top element in a stack
    public String peek() {
        // check for empty stack
        if (!isEmpty()) {
            return top.data;
        } else {
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
    public void display() {
        // check for stack underflow
        if (top == null) {
            System.out.println("\nStack Underflow");
        } else {
            Node temp = top;
            while (temp != null) {
                // print node data
                System.out.println("temp.data: " + temp.data);

                // assign temp link to temp
                temp = temp.link;
            }
        }
    }

    /*
    SymbolChecker: manage the process of checking a file.
    Instance variables: A Stack,  Scanner,  lineNumber as an int
      */
    public static void setup(String fileName) throws FileNotFoundException {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();
        int lineCount = 0;

        //creating File instance to reference text file in Java
        File text = new File(fileName);
        System.out.println(text);

        //Creating Scanner instance to read File in Java
        Scanner scan = new Scanner(text);

        //Reading each line of the file using Scanner class
        int lineNumber = 1;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            System.out.println("line " + lineNumber + " :" + line);
            lineNumber++;
            runChecker(line);
        }
        cleanup(scan);
    }

    /*
     SymbolChecker: manage the process of checking a file.
     Instance variables: A Stack,  Scanner,  lineNumber as an int
     @param expr  as a String
    */
    public static boolean runChecker(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<Character>();
        int lineCount = 0;

        // Traversing the Expression
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);
            lineCount++;

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
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
                    if (check == '(') {
                        System.out.println(" ) found match " + check + " on line: " + lineCount);
                        return false;
                    } else {
                        System.out.println("DOES NOT BALANCE. ) found matches " + check + " on line: " + lineCount);
                        return true;
                    }

                case '}':
                    check = stack.pop();
                    if (check == '{') {
                        System.out.println("} found matches " + check + " on line: " + lineCount);
                        return false;
                    } else {
                        System.out.println("DOES NOT BALANCE. } found matches " + check + " on line: " + lineCount);
                        return true;
                    }

                case ']':
                    check = stack.pop();
                    if (check == '[') {
                        System.out.println("] found matches " + check + " on line: " + lineCount);
                        return false;
                    } else {
                        System.out.println("DOES NOT BALANCE. ] found matches " + check + " on line: " + lineCount);
                        return true;
                    }
            }
        }
        return (stack.isEmpty()); // Check Empty Stack
    }

    //close scanner
    public static void cleanup(Scanner scan) {
        scan.close();
    }

    public class stackTest {
        public static void main(String[] args) throws FileNotFoundException {
            Stack obj1 = new Stack();
            Stack obj2 = new Stack();

            // insert Stack value
            obj1.push("{");
            obj1.push("}");
            obj1.push("}");

            // print Stack elements
            obj1.display();

            // print Top element of Stack
            System.out.println("\nTop element is %d " + obj1.peek());

            // Delete top element of Stack
            obj1.pop();
            obj1.pop();
            obj1.display();
            System.out.println("\nTop element is %d " + obj1.peek());
        }
    }
}
