// Binary Tree; Data Structures; Illinois State University;
// https://code.sololearn.com/cWXfb0I9YtFw

public class Student
{
    private String fName;
    private String lName;
    private double gpa;

    public Student(String fn, String ln, double g)
    {
        fName = fn;
        lName = ln;
        gpa = g;
    }

    public String getFName()
    {
        return fName;
    }

    public String getLName()
    {
        return lName;
    }

    public double getGPA()
    {
        return gpa;
    }

}

import java.util.Stack;
  
public class Test 
{
    // Method to evaluate value of a postfix expression
    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
          
        // Scan all characters one by one
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
              
            // If the scanned character is an operand (number here),
            // push it to the stack.
            if(Character.isDigit(c))
            stack.push(c - '0');
              
            //  If the scanned character is an operator, pop two
            // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();
                  
                switch(c)
                {
                    case '+':
                    stack.push(val2+val1);
                    break;
                      
                    case '-':
                    stack.push(val2- val1);
                    break;
                      
                    case '/':
                    stack.push(val2/val1);
                    break;
                      
                    case '*':
                    stack.push(val2*val1);
                    break;
              }
            }
        }
        return stack.pop();    
    }
      
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        String exp="231*+9-";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));
    }
}

public class BinTreeNode
{

    private Student std;
    private BinTreeNode leftChild;
    private BinTreeNode rightChild;

    public BinTreeNode(Student s)
    {
        std = s;
        leftChild = null;
        rightChild = null;

    }

    public void printTree(int level)
    {
        // System.out.print("Level = " + level);
        for (int i = 0; i < level; i++)
            System.out.print("    ");

        System.out.println(std.getFName() + " " + std.getLName() + " " + std.getGPA());

        if (leftChild != null)
        {

            // System.out.println("LEFT SUBTREE ");
            leftChild.printTree(level + 1);
        }
        else
        {
            for (int i = 0; i <= level; i++)
                System.out.print("    ");
            System.out.println("NO LEFT CHILD ");
        }
        if (rightChild != null)
        {

            // System.out.println("RIGHT SUBTREE ");
            rightChild.printTree(level + 1);
        }
        else
        {
            for (int i = 0; i <= level; i++)
                System.out.print("    ");
            System.out.println("NO RIGHT CHILD ");
        }
    }

    public void inOrderTraversal()
    {
        if (leftChild != null)
            leftChild.inOrderTraversal();
        System.out.println(std.getFName() + " " + std.getLName() + " " + std.getGPA());
        if (rightChild != null)
            rightChild.inOrderTraversal();
    }

    public void preOrderTraversal()
    {
        System.out.println(std.getFName() + " " + std.getLName() + " " + std.getGPA());
        if (leftChild != null)
            leftChild.preOrderTraversal();

        if (rightChild != null)
            rightChild.preOrderTraversal();
    }

    public void postOrderTraversal()
    {

        if (leftChild != null)
            leftChild.postOrderTraversal();

        if (rightChild != null)
            rightChild.postOrderTraversal();
        System.out.println(std.getFName() + " " + std.getLName() + " " + std.getGPA());
    }

    public void search(String ln)
    {

        if (std.getLName().equals(ln))
            System.out.println("FOUND !!! , GPA = " + std.getGPA());
        if (leftChild != null)
            leftChild.search(ln);

        if (rightChild != null)
            rightChild.search(ln);

        System.out.println("NOT FOUND !!!");
    }

    public void insertChild(BinTreeNode n)
    {
        if (std.getLName().compareTo(n.std.getLName()) > 0)
            if (leftChild == null)
                leftChild = n;
            else
                leftChild.insertChild(n);
        else if (rightChild == null)
            rightChild = n;
        else
            rightChild.insertChild(n);
    }

}

public class Main
{
    static BinTreeNode root;

    public static void main(String[] args)
    {

        BinTreeNode[] stdBinTreeNode = new BinTreeNode[12];
        stdBinTreeNode[0] = new BinTreeNode(new Student("Robert", "Smith", 3.4));
        stdBinTreeNode[1] = new BinTreeNode(new Student("Sarah", "Thomas", 3.5));
        stdBinTreeNode[2] = new BinTreeNode(new Student("Peter", "Gabby", 3.1));
        stdBinTreeNode[3] = new BinTreeNode(new Student("Kyle", "Marcos", 2.1));
        stdBinTreeNode[4] = new BinTreeNode(new Student("John", "Havana", 3.3));
        stdBinTreeNode[5] = new BinTreeNode(new Student("Cristina", "Robertson", 3.9));
        stdBinTreeNode[6] = new BinTreeNode(new Student("David", "Zelensky", 3.4));
        stdBinTreeNode[7] = new BinTreeNode(new Student("Philip", "Thomas", 1.8));
        stdBinTreeNode[8] = new BinTreeNode(new Student("John", "Dolce", 3.5));
        stdBinTreeNode[9] = new BinTreeNode(new Student("Johnathan", "Francisco", 2.7));
        stdBinTreeNode[10] = new BinTreeNode(new Student("Brad", "Gabbana", 4.0));
        stdBinTreeNode[11] = new BinTreeNode(new Student("Raymond", "Chavez", 2.8));

        root = new BinTreeNode(new Student("Alex", "Paulson", 2.3));

        for (BinTreeNode n : stdBinTreeNode)
            root.insertChild(n);

        root.inOrderTraversal();
        System.out.println("====================");
        root.preOrderTraversal();
        System.out.println("====================");
        root.postOrderTraversal();

        root.search("ASDF");

        // root.printTree(0);

    }
}
