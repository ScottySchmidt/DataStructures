/* 
Sorting Recursion; DataStructures; Illinois State University;
https://code.sololearn.com/c4keexzn8pTe

Figure 1 shows a recursive modified version of a selection sort algorithm that we call (in this
assignment) minmaxSelectionSort(). Figure 1 shows a version of minmaxSelectionSort() that
contains three errors.
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
            System.out.println("i should not be > than j");
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

    public static void main(String[] args) {
        int[] myIntArray = {1, 2, 3, 4, 6};
        int [] reversed = reverseSort(myIntArray);
        System.out.println(reversed+ " reversed");
        int len=myIntArray.length-1;
		minmaxRecursiveSelectionSort(myIntArray, 0, 3);
	}
}
