/* 
Final; DataStructures; Illinois State University; Scott Schmidt
Java Version:  https://code.sololearn.com/cVffX9pcm85a

Consider an array of integers a (int[] a). We would like to generate a 2D array (i.e., matrix) m
(int[][] m) as follows:
• Initially, all element of the 2D array m are set to 0.
• Take a[0], the first element of the array a and assign it to m[0][0] (i.e., m[0][0] = a[0])
• for any subsequent element a[j], j > 0:
If a[j-1] <= a[j], continue by inserting a[j] in m in the same direction (left to right or
tdownwards)

If a[j-1] > a[j], flip the direction of insertion, i.e., if you last inserted left to right, then now start
inserting the elements of a in m downwards and, if you last inserted downwards, then now start
inserting the elements of a in m left to right. 
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 

public class Q1 {
    public static void main(String[] args) {
        int a[] = { 2, 3, 5, 7, 9, 1, 4, 8, 3, 5, 2, 3, 5, 2, 3, 7, 11, 4, 4, 3 };
        int m[][] = new int[20][20];
        m[0][0] = a[0];

        int row = 0, col = 0;
        boolean directionL = true;

        for (int j = 1; j < 10; j++) {
            if (a[j - 1] > a[j]) {
                directionL = !directionL;
            }

            if (directionL) {
                     col++;
            }
            else {
                row++;
            }
            m[row][col] = a[j];
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
}
