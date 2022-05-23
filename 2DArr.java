/*
Scott Schmidt; Illinois State University; Data Structures
*/

public class Main
{
    public static void main(String[] args) {
    int values[][] = new int[5][5];
    for (int i = 0; i < values.length; i++) {
        // do the for in the row according to the column size
        int rowTotal=0;
        for (int j = 0; j < values[i].length; j++) {
            // multiple the random by 10 and then cast to in
            values[i][j] = ((int) (Math.random() * 10));
            rowTotal+=values[i][j];
            System.out.print(values[i][j] + "  ");
        }
        
        System.out.print("| " + rowTotal);
        System.out.println();
    }
    System.out.println("Done");
    }
}

/*
4  8  6  2  6  | 26
0  6  8  8  4  | 26
7  5  4  4  2  | 22
8  8  2  4  3  | 25
6  7  8  2  4  | 27
Done
*/  
