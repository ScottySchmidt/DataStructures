//Linked Lists for Data Structures; Illinois State University; Scott Schmidt
//Running Java verision: https://code.sololearn.com/co90H726Xit2

public class SingleList <E>{
    private Node<E> head;
    private int size;

    private LinkedList data = new LinkedList(); 

    /* 
    Node Constructor:
    :param: data as E 
    :param: Node <E>  
     */
    private static class Node<E>{
            private E data;
            private Node<E> next;

            private  Node(E data) {
                this.data=data;
                this.next=null;
                System.out.println(data);
    }

   /* 
    Node Constructor:
    :param: data as E 
    :param: Node <E>  
     */
    private Node(E data, Node<E> next)  {
       this.data=data;
       this.next=next;
    }
    /* 
    addBulk method
    :param: @ArrayList 
    appends the current SingleList with all the elements that are in the ArrayList parameter. 
     */
    private void addBulk(ArrayList<String> arrList) {
        System.out.println(arrList);
        for (int i=0; i<arrList; i++) {
            data.add(arrList[i]);
        }
        System.out.println(data);
    }
 

    /* 
    reversedList method 
    :return a reversed version of the current SingleList
    You cannot call any of the methods we created before- and take into account any special cases).
     */
    private LinkedList<String> reversedList() {
        LinkedList<String> revLinkedList = new LinkedList<String>();
        for (int i=data.size()-1; i>=0; i--) {
            revLinkedList.add(data.get(i));
            System.out.println(revLinkedList);
        }
        System.out.println(data);
        return revLinkedList;
    }

    }
} 

public class LinkedListTest2 {
 public static void main(String[] args) {
     //sl=SingleList();
 }
}
