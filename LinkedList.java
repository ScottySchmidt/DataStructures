// Linked Lists Data Structures; Illinois State University; Scott Schmidt
// Working Java verision: https://code.sololearn.com/cYrcI4wmJ6rA
// Python verision: https://github.com/ScottySchmidt/DataStructures/blob/main/LinkedLists.ipynb

import java.util.ArrayList;
import java.util.LinkedList;

public class SingleList<E> {
        private Node<E> head;
        private int size;
        
        //Default Constructor
        public SingleList() {
                head = null;
                size = 0;
        }
        
        private static class Node<E>{
                private E data;
                private Node<E> next;
            
                private Node(E data) {
                        this.data=data;
                        this.next=null;
                }

                private Node(E data, Node<E> next) {
                        this.data=data;
                        this.next=next;
                }
        }

        //add current SingleList from  @param: ArrayList
        private void addBulk(ArrayList<E> arrList) {
                Node<E> tail;
                if(head == null)
                        tail = null;
                else {
                        tail = head;
                        while(tail.next != null)
                                tail = tail.next;
                }
                for (int i=0; i<arrList.size(); i++) {
                        E item = arrList.get(i);
                        if(head == null) {
                                head = new Node<>(item);
                                tail = head;
                        } else {
                                tail.next = new Node<>(arrList.get(i));
                                tail = tail.next;
                        }
                        size++;
                }
        }
        
        @Override
        public String toString() {
                String str = "";
                Node<E> temp = head;
                while(temp != null) {
                        str = str + temp.data + " ";
                        temp = temp.next;
                }
                return str.trim();
        }

        //reverse linked list
        public void reversedList(){
            Node previous = null;
            Node current = head;
            Node next;
            while(current != null){
            next = current.next;
            current.next = previous; 

            previous = current;
            current = next;
        }
        head = previous;
     }

     // Same as above but return the reversedList:
     public static LinkedList<Integer> returnReversedList() {
             LinkedList<Integer> reverseList = new LinkedList<Integer>();
             return reverseList;
     }

   //print the linked list  
    public void printList() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            //Print each node by incrementing pointer  
            System.out.print(current.data + " ");  
            current = current.next;  
        }  
        System.out.println();  
    }  

    public static void main (String[] args) {
        //ArrayList with numbers:
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(90);
        arrList.add(80);
        arrList.add(70);

        //SingleList Class Test:
        SingleList<Integer> list = new SingleList<>();

        list.addBulk(arrList);
        System.out.println("Original List:");
        System.out.println(list);

        list.reversedList();
        System.out.println("Reverse the List:");
        System.out.println(list);

        ArrayList<Integer> arrList2 = new ArrayList<>();
        arrList2.add(0);
        arrList2.add(10);
        list.addBulk(arrList2);

        list.printList();
        /* 
        Original List:
        90 80 70
        Reverse the List:
        70 80 90
        70 80 90 0 10
        */
        }
}
