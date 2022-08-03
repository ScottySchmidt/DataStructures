/* 
Sorting Recursion; DataStructures; 
Illinois State University; Scott Schmidt
Java Version:  https://code.sololearn.com/c4keexzn8pTe
Python:  https://github.com/ScottySchmidt/DataStructures/blob/main/SortingRecursion.ipynb

Figure 1 shows a recursive modified version of a selection sort algorithm that we call 
minmaxSelectionSort(). Figure 1 shows a version of minmaxSelectionSort() that contains three errors.

Error1: tab[i] = tab[j]
Error2: if (tab[k] < tab[min])
Error3: Try Catch Clause for ArrayIndexOutOfBoundsException
 */

public class Program12
{
    /* 
    swapElements function:
    @param tab array of int 
    @param i   first number
    @param j   second number
    Switches elements within tab int array
    */
    public static void swapElements(int[] tab, int i, int j) {
        int tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }
    
    /* 
    Sort array by min and max 
    @param tab array of int 
    @param i   first number
    @param j   second number
    */
    public static void minmaxRecursiveSelectionSort(int[] tab, int i, int j)    {
        int min = 0;
        int max = tab.length - 1;
        if (i > j) {
            return;
           // System.out.println("i > than j");
        }

        for (int k = i + 1; k <= j; k++)
        {
        if (tab[k] > tab[max])
            max = k;
            System.out.println("new max, k is: "+ k);
        if (tab[k] < tab[min])
            min = k;
            System.out.println("new min, k is: "+ k);
        }

        try
        {
        swapElements(tab, i, min);
        swapElements(tab, j, max);
        minmaxRecursiveSelectionSort(tab, i + 1, j - 1);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Requested element not found");
        }
     }

        /* 
        ReverseSort function:
        @param array with intergers
        :return new array reversed 
        */
       public static int[] reverseSort(int[] array) {
            int startIndex = 0;
            int endIndex = array.length - 1;
            while(startIndex < endIndex) {
                int temp = array[endIndex];
                array[endIndex] = array[startIndex];
                array[startIndex] = temp;
                startIndex++;
                endIndex--;
            }
            return array;
        }

        /* 
        printArr:
        @param array with intergers
        print out each number in array 
        */
        public static void printArr(int[] array) {
            System.out.println("Reverse Array: ");
            for (int i=0; i<array.length; i++) {
                System.out.print(array[i]+ ",  ");
            }
            System.out.println();
        }

    public static void main(String[] args) {
        int[] myIntArray = {1, 3, 7, 5, 9, 4};
        int [] reversedArr = reverseSort(myIntArray);
        printArr(reversedArr);
       
        int len=myIntArray.length-1;
		minmaxRecursiveSelectionSort(myIntArray, 0, len);
        
	}
}
