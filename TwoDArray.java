/*
Scott Schmidt; Illinois State University; Data Structures
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; // import the ArrayList class

public class Main
{
    public static void main(String[] args) {
    int len=5;
    int values[][] = new int[len][len];
    int grandTotal=0;
    
    for (int i = 0; i < values.length; i++) {
        int rowTotal=0;
        for (int j = 0; j < values[i].length; j++) {
            values[i][j] = ((int) (Math.random() * 10));
            rowTotal+=values[i][j]; //track row total
            grandTotal+=values[i][j];
            System.out.print(values[i][j] + "  ");
        }
        System.out.print(" | " + rowTotal);
        System.out.println();
    }
    
    // finding the column sum:
    int i, j, sum = 0;
    List<Integer> colList = new ArrayList<Integer>();
    for (i = 0; i < len; ++i) {
        for (j = 0; j < len; ++j) {
            sum = sum + values[j][i];  // Add the element
        }
        colList.add(sum);
        grandTotal+=sum;
        //System.out.println(sum);
        sum = 0; // Reset the sum
    }
    for (int c : colList) {
        System.out.print(c+ " ");
    }
    System.out.println( " | " + grandTotal);
    System.out.println("Done.");
    }
}

/*
6  0  7  6  3   | 22
2  5  0  2  9   | 18
0  3  0  4  7   | 14
5  4  5  0  7   | 21
0  3  2  3  2   | 10
13 15 14 15 28  | 170
Done.
Done
*/  
