// Testing; Data Structures; Illinois State University; Scott Schmidt
// Working Java verision:  https://code.sololearn.com/c944B5Ex9QUv
// Python verision https://github.com/ScottySchmidt/DataStructures/blob/main/Testing.ipynb

import java.util.ArrayList;

public class Testing
{
    /*  
    method search
    @param arr as int ArrayList
    @param target as int
    @param start  first index int 
    @param finish last index int
    return index of target num in the ArrayList
    */    
    public int search(int[] arr, int target, int start, int finish) {
        int num=-1;
        for (int i=0; i< arr.length; i++) {
            if (arr[i]==target) {
                return i;
            }
        } 
        return num;
    }

      /*  
    method arraySearch
    @param arr as int ArrayList
    @param target as int
    @param start  first index int 
    @param finish last index int
    return finds the last occurrence of a target element in an array.
    */    


  
    /*  
    method findLargest()  index of largest element in array
    @param arr as int ArrayList
    @param target as int
    @param start  first index int 
    @param finish last index int
    return index of largest element in array
    */    


    public static void main(String[] args) {
		System.out.println("main");

        ArrayList<Integer> arrList = new ArrayList<Integer>();

        int arr1[]={1,2,3, 6, 4};
        arrList.add(arr1);
        int test1=search(arr1, 2, 0, arrList.length);
        System.out.println(test1);
	}
}
