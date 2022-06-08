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

    //add value to ArrayList at beginning
    public void addFirst(String value) {
        data.add(0, value);
        System.out.println(data);
    }

    //add two values at beginning of ArrayList
    public void addFirstTwo(String entry1, String entry2) {
        data.add(0, entry2);
        data.add(0, entry1);
        System.out.println(data);
    }

    //remove first item of ArrayList
    public void removeFirst(){
        if (data.size()>0) {
            data.remove(0);
            System.out.println("Removed first index. New data:");
            System.out.println(data);
        } else {
            System.out.println("Data list is empty cannot delete");
        }
    }

    //return index of value; return -1 if value not found
    public int indexOf(String value) {
            for (int i =0; i<data.size(); i++) {
                if (data.get(i).equals(value)) {
                    System.out.println(i+ " found");
                    return i;
                } 
        }
        System.out.println("-1 not found");
        return -1;
    }
}

public class TWArrayListTest1 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();

        TWArrayList tw1 = new TWArrayList(list, 0, 0);
        tw1.addFirst("sun1");
        tw1.addFirst("sun2");
        tw1.addFirst("sun3");
        tw1.addFirstTwo("sun4", "sun5");
        tw1.removeFirst();
        tw1.indexOf("NOT EXISTS"); //correctly returns -1
        tw1.indexOf("sun1"); //correctly returns 3
    }
}

public class TWArrayListTest2 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        
        TWArrayList tw2 = new TWArrayList(list, 0, 0);
        tw2.addFirst("sun1");
        tw2.addFirst("sun2");
        tw2.removeFirst();
        tw2.removeFirst();
        tw2.removeFirst(); //prints Data list is empty cannot delete
    }
}

public class TWArrayListTest3 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        
        TWArrayList tw3 = new TWArrayList(list, 0, 0);
        tw3.addFirstTwo("sun1", "sun2");
        tw3.addFirstTwo("sun3", "sun4");
        tw3.indexOf("sun1");
        tw3.indexOf("sun3");
        tw3.indexOf("sun4");
    }
}
