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
    public static void inorder(BinTreeNode root)
    {
        if (root == null) {
            return;
        }
 
        if (isOperator(root.symbol)) {
            System.out.print("(");
        }
 
        inorder(root.left);
        System.out.print(root.symbol);
        inorder(root.right);
 
        if (isOperator(root.symbol)) {
            System.out.print(")");
        }
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
 
    public static void main(String[] args)
    {
        String postfix = "12+345+**";
        BinTreeNode root = construct(postfix);
 
        System.out.print("Postfix: ");
        postorder(root);
 
        System.out.print("\nInfix: ");
        inorder(root);

        System.out.println("\nResult: ");
    }
}
