// Recursion; Scott Schmidt; Illinois State University
// Java version: https://code.sololearn.com/cIkMAxQsNJ0E
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

//The first argument will be the desired sum. 
//Print the list of numbers that add up to the desired sum to the screen.
//If no such set of numbers exists, print the message: "Sum not found." Call your file Sum.java.


//Instead of an array of characters, read the input as a string. 
//Print the resulting sequences to the screen. 
//Call your file Combinations.java.

class Permutation {
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
