/* 
Binary Tree; DataStructures; Illinois State University;
https://code.sololearn.com/cPNhADWM4154

Let sumDigits(x) be the sum of the digits of integer x. For example: sumDigits(53) = 8, SumDigits(325) = 10.
 1.  Write a program that generates a sequence of random integers between 1 and 100 and builds a binary tree in a recursive way as follows:
The root of the tree is the first integer generated
To insert a new integer in the tree, you need to traverse the tree recursively. When you visit a node n (whose integer value is n.value) to insert a value x:
  i. If the difference sumDigits(x) <= sumDigits(n.value), insert x in the left subtree of node n.
  ii. If the difference sumDigits(x) > sumDigits(n.value), insert x in the right subtree of node n.

Example:
Input (randomly generated in this order)
15, 12, 26, 11, 32, 87, 44, 5, 14, 76, 79, 50, 16, 17, 25
 */

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ data =x; left=right = null;}
};

public class Main
{
    //sumDigits(x) be the sum of the digits of integer x.
    static int sumDigits(int n){
        int s = 0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }

    //traverse the binary tree in PreOrder
    public static void preorder(TreeNode temp)
    {
        if (temp == null) {
                   return;
        }
        System.out.print( temp.data+" ");
        preorder(temp.left);
        preorder(temp.right);
    }

    //insertNode left or right based upon sum of digits 
    public static TreeNode insertNode(TreeNode root, int data){
        if(root == null){ 
            return  new TreeNode(data);
        }
        else if(sumDigits(data) <= sumDigits(root.data)){ 
            root.left = insertNode(root.left, data);
        }
        else{ 
            root.right = insertNode(root.right, data);
        }
        return root;
    }
//generates a sequence of random integers between 1 and 100 and builds a binary tree in a recursive way as follows:
//The root of the tree is the first integer generated
	public static void main(String[] args) {
	    Random r = new Random(); 
	    TreeNode root = new TreeNode(r.nextInt(101)); 
	    System.out.print(root.data+" "); 
	    for(int i=0;i<10;i++){ 
            int rand_num = r.nextInt(101); 
    	    System.out.print(rand_num +" ");  
            root = insertNode(root, rand_num); 
        }
        System.out.println(); 
        preorder(root); 
	}
}
