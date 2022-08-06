/* 
Final; DataStructures; Illinois State University; Scott Schmidt
Java Version:  https://code.sololearn.com/cYQlunQIAfcR

Write a program that has a main() function that calls a recursive method repeatPrint(String s, .....) 
that prints out the string s as shown in the example below:
 */

public class Q3 {
    /* function repeatPrint
    @param str as a String to print
    @param letter as int 
    @param index as int keeps track of index
     */
    public static void repeatPrint(String str, int letter, int index) {

        if (letter == str.length() && index == str.length()) {
            return;
        }

        if (letter == str.length()) {
            index += 1;
        }

        if (index == 0) {
            for (int i = 0; i < str.length() - letter; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < letter + 1; i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();

            //repeatFunction
            repeatPrint(str, letter + 1, index);
        } else {

            for (int i = index - 1; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();

            //repeat Function:
            repeatPrint(str, letter, index);
        }
    }

    public static void main(String[] args) {
        repeatPrint("CHICAGO", 0, 0);
    }
}
