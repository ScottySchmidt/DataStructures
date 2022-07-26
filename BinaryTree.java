/* 
Binary Tree; symbol Structures; Illinois State University;
https://code.sololearn.com/cWXfb0I9YtFw

Read an arithmetic expression in postfix notation 
creates a binary expression tree from that expression. 
The program will then print the expression out in prefix form and 
in properly parenthesized infix form. It will also evaluate
the expression and print the result. 
 */

import java.util.Stack;
 
public class BinTreeNode
{
    char symbol;
    BinTreeNode left, right;
    int value;
    boolean isOperator;
 
    BinTreeNode(char symbol)
    {
        this.symbol = symbol;
        this.left = this.right = null;
    }
 
    BinTreeNode(char symbol, BinTreeNode left, BinTreeNode right)
    {
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }
}
 
//This class will hold your binary tree.
//It will have a single private instance variable: a root of type BinTreeNode
public class ExpressionTree
{
    // check if is an operator
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
 
    // postfix expression 
    public static void postorder(BinTreeNode root)
    {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.symbol);
    }
 
    // getInfixNotation, which will take no parameters 
    // return a String that contains the infix version of the expression
    public static void getInfixNotation(BinTreeNode root)
    {
        //String exp; 
        if (root == null) {
            return;
        }
 
        if (isOperator(root.symbol)) {
            System.out.print("(");
        }
 
        getInfixNotation(root.left);
        System.out.print(root.symbol);
        getInfixNotation(root.right);
 
        if (isOperator(root.symbol)) {
            System.out.print(")");
        }
        //return exp;
    }
 
    // Function to construct an expression tree 
    public static BinTreeNode construct(String postfix)
    {
        if (postfix == null || postfix.length() == 0) {
            return null;
        }
 
        Stack<BinTreeNode> s = new Stack<>();
 
        for (char c: postfix.toCharArray())
        {
            if (isOperator(c))
            {
                BinTreeNode x = s.pop();
                BinTreeNode y = s.pop();
 
                BinTreeNode BinTreeNode = new BinTreeNode(c, y, x);
 
                s.add(BinTreeNode);
            }
            else {
                s.add(new BinTreeNode(c));
            }
        }
        return s.peek();
    }
 
    public static int getValue(String exp)
    {

        Stack<Integer> stack = new Stack<>();
          
        for(int i = 0; i < exp.length(); i++)
        {
            char c = exp.charAt(i);
              
            if(c == ' ')
            continue;
              
            else if(Character.isDigit(c))
            {
                int n = 0;
                  
                while(Character.isDigit(c))
                {
                    n = n*10 + (int)(c-'0');
                    i++;
                    c = exp.charAt(i);
                }
                i--;
                stack.push(n);
            }
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

    public static void main(String[] args)
    {
        String postfix = "12+345+**";
        BinTreeNode root = construct(postfix);
 
        System.out.print("Postfix: ");
        postorder(root);
 
        System.out.print("\nInfix: ");
        getInfixNotation(root);
        //String exp = getInfixNotation(root);

        System.out.println("\nResult: ");
        //getValue(exp);
    }
}
