/**
Illinois State University; Data Structures; Scott Schmidt 
https://code.sololearn.com/c5iQZRmb2U9b   Java working version
https://github.com/ScottySchmidt/DataStructures/blob/main/big0Array.ipynb  Python working version
*/ 

import java.util.ArrayList; 

public class count {
    public static void main(String[] args) {
        int n=10;
      // fragment A:
        int countA=0;
         for (int i =0; i<n; i++) {
            for (int j=0; j<n; j++) {
                //System.out.println(i+ " "+j);
                countA++;
            }
         }
		System.out.println(countA+ " countA");

        //fragment B:
        int countB=0;
          for (int i =0; i<n; i++) {
            for (int j=0; j<2; j++) {
                //System.out.println(i+ " "+j);
                countB++;
      }
    }
    System.out.println(countB+ " countB");
    }
}
/**
100 countA
20 countB
*/

public class TWArrayList {
    ArrayList<Object> data;
    int size;
    int capacity;

     /**
    TWArrayList Constructor:
    * @param data as List
    * @param size as int
    * @param capacity as int
    */
    public TWArrayList (ArrayList<Object> data, int size, int capacity) {
        this.data=data;
        this.size=size;
        this.capacity=capacity;
    }

    //return size of ArrayList
    public int getSize() {
        return data.size();
    }

    //return capacity
    public int getCapacity(){
        return capacity;
    }

    //add value to ArrayList
    public void addFirst(String value) {
        data.add(value);
        System.out.println(data);
    }
}

public class TWArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        TWArrayList tw1 = new TWArrayList(list, 0, 0);
        tw1.addFirst("sun1");
    }
}
