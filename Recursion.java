//Recursion; Data Structures; Scott Schmidt; Illinois State University
//https://code.sololearn.com/c4ZUSIu5EB6U
//https://code.sololearn.com/cIkMAxQsNJ0E

import java.util.*;
import java.util.List;

public class Global {
   static boolean found=false;
}

public class Recursion {
    public static void main(String[] args) throws Exception {
        int[] nums3 = {7, 4, 3};
        System.out.println("\nOriginal array: "+Arrays.toString(nums3));
        List<List<Integer>> result3 = new Recursion().permute(nums3);
        System.out.println("\nPossible permutations of the said array:");
        getList(result3, 20);

        int[] nums2 = {5, 2, 9};
        System.out.println("\nOriginal array: "+Arrays.toString(nums2));
        List<List<Integer>> result2 = new Recursion().permute(nums2);
        System.out.println("\nPossible permutations of the said array:");
        getList(result2, 11);  // result2.forEach(System.out::println);	
	  }

    public static void getList(List<List<Integer>> lists, int find){
    for (int i =0; i<lists.size(); i++) {
        List<Integer> list = lists.get(i); 
        findNum(list, find); //System.out.println(list);
        }
        if (Global.found==false) {
          System.out.println(find+ " not found.");
        }
    }

    public static void findNum(List<Integer> list, int find) {
      int sum=0;

      for (int i=0; i<list.size(); i++) {
        sum=sum+list.get(i);
        if (sum==find) {
           System.out.println(list);
           System.out.println(sum + " sum found");
           Global.found=true;
        }
      }
    }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Permutation(0, nums, result);
    return result;
  }

  private void Permutation(int i, int[] nums, List<List<Integer>> result) {
    if (i == nums.length - 1) {
      List<Integer> list = new ArrayList<>();
      for (int n : nums) list.add(n);
      result.add(list);
    } else {
      for (int j = i, l = nums.length; j < l; j++) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        Permutation(i + 1, nums, result);
        temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
      }
    }
  }
}



//Recursion; Data Structures; Scott Schmidt; Illinois State University
//https://code.sololearn.com/c4ZUSIu5EB6U
//https://code.sololearn.com/cIkMAxQsNJ0E

import java.util.*; 
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class p10 {
    //Instead of an array of characters, read the input as a string. 
    //Print the resulting sequences to the screen. 
    //Call your file Combinations.java.
    private static List<String> permutation(String prefix, String str) {
        List<String> permutations = new ArrayList<>();
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i)));
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> perms = permutation("", "abcd");

        String[] array = new String[perms.size()];
        for (int i = 0; i < perms.size(); i++) {
            array[i] = perms.get(i);
        }
        int x = array.length;

        for (final String anArray : array) {
            System.out.println(anArray);
        }
    }
}
