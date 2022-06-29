// Testing; Data Structures; Illinois State University; Scott Schmidt
// Working Java verision:  https://code.sololearn.com/c944B5Ex9QUv
// Python verision  https://github.com/ScottySchmidt/DataStructures/blob/main/Testing.ipynb

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
    public static int search(int[] arr, int target, int start, int finish) {
        int num=-1;
        for (int i=start; i< finish; i++) {
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

    public static int arraySearch(int[] arr, int target, int start, int finish) {
        int num=-1;
        for (int i=start; i<finish; i++) {
            if (arr[i]==target) {
                num=i;
            }
        }
        return num;
    }
 
    /*  
    method findLargest()  index of largest element in array
    @param arr as int ArrayList
    @param start  first index int 
    @param finish last index int
    return index of largest element in array
    */    
    public static int findLargest(int[] arr, int start, int finish) {
        System.out.println("Finding Largest:");
        int maxNum= -999;
        int maxIndex= -1;
        for (int i=start; i<finish; i++) {
            int num=arr[i];
            if(num>maxNum) {
                maxNum=num;
                maxIndex=i;
                //System.out.println("new max num: "+ num);
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {

        //TEST1:
	System.out.println("Testing Array1:");
        int arr1[]={6, 3, 2, 6, 4, 100};
        int len1=arr1.length;

        int test1=search(arr1, 4, 0, len1);  
        int last1=arraySearch(arr1, 3, 0, len1);
        int max1=findLargest(arr1, 0, len1 );

        System.out.println(test1);
        System.out.println(last1);
        System.out.println(max1);

      
        //TEST2:
        System.out.println("\nTesting Array2:");
        int arr2[]={4, 13,21,30, 6, 4, 5};   
        int len2=arr1.length;
        
        int test2=search(arr2, 30, 0, len2);
        int last2=arraySearch(arr2, 4, 0, len2);
        int max2=findLargest(arr2, 0, len2);

        System.out.println(test2);
        System.out.println(last2);
        System.out.println(max2);
	}
}
