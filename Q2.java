/* 
Final; DataStructures; Illinois State University; Scott Schmidt
Java:  https://code.sololearn.com/cylC4Ap00nXz

Write a Java program that:
1. Randomly populates a stack S with 30 integers whose remainder of division 
by 10 is 3, 5 or 7.
For example, the following are numbers that satisfy this: 15, 13, 43, 57, 63, 87, 95, 5, 3, 7, 17, 53, 65, 73

2. Prints out the content of the stack S.

3. Uses the content of stack S to create two other stack S5 and S7 such that, at the end:
a. Stack S contains only the numbers whose remainder of division by 10 is 3
b. Stack S5 contains only the numbers whose remainder of division by 10 is 5
c. Stack S7 contains only the numbers whose remainder of division by 10 is 7

Do not use any number should be removed (using pop()) from the original stack S twice.
Do not use any additional temporary data structures (other stacks, arrays, etc.)
 */

import java.util.Scanner;
import java.util.Random;

public class Stack357{
    public int[] Stck;
    public int top;
    public int n;

    public Stack357(int size){
        n = size;
        Stck = new int[n];
        top = -1;
    }
    public  void push(int x){
        Stck[++top] = x;
    }

    public void printArray(int[] stack){
        for (int i=0; i< stack.length;i++){
                System.out.print(stack[i] + " ");

        }
    }
}

public class StackClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("\n Enter the size of the Stack needed : ");
        int n = scan.nextInt();

        Stack357 S = new Stack357(n);
        int x;
        int count5 = 0;
        int count7 = 0;

        for (int i=0; i<n;){
            x = rand.nextInt(100);
            if (x%10 == 3 || x%10 == 5 || x%10 == 7) {
                if (x%10 == 5){count5++;}
                if (x%10 == 7){count7++;}
                S.push(x);
                i++;
            }
        }
        System.out.print("\n Array elements in Stack S : ");
        S.printArray(S.Stck);

        Stack357 S5 = new Stack357(count5);
        Stack357 S7 = new Stack357(count7);

        for (int i=0; i<n;i++){
            x = S.Stck[i];
            if (x%10 == 5 || x%10 == 7) {
                if (x%10 == 5) {
                    S5.push(x);
                    S.Stck[i] = 0;
                }
                else {
                    S7.push(x);
                    S.Stck[i] = 0;
                }
            }
        }
        System.out.print("\n Array elements in Stack S : ");
        S.printArray(S.Stck);
        System.out.print("\n Array elements in Stack S5 : ");
        S.printArray(S5.Stck);
        System.out.print("\n Array elements in Stack S7 : ");
        S.printArray(S7.Stck);
    }
}
