//Double Linked List; Data Structures; 
//Illinois State University; Scott Schmidt
//Working Java Verision  https://code.sololearn.com/crPPoRZPg584
//Python Verision  https://github.com/ScottySchmidt/DataStructures/blob/main/DoubleLinkedList.ipynb

import java.util.Objects;

public class DoubleLinkLists {

    public static void main(String[] args) {
        DoubleLinkedList DL1 = new DoubleLinkedList();

        //Original Names:
        DoubleLinkedList.Node nodeSam = DL1.insertInFront("Sam");
        DoubleLinkedList.Node nodeHarry = DL1.insertInFront("Harry");
        DoubleLinkedList.Node nodeDick = DL1.insertInFront("Dick");
        DoubleLinkedList.Node nodeTom = DL1.insertInFront("Tom");
        DL1.printNodes();
        System.out.println(DL1);

        // Insert Bill Before Tom:
        DL1.insertBefore(nodeTom, "Bill");

        //Insert Sue Before Sam:
        DL1.insertBefore(nodeSam, "Sue");

        System.out.println("\nInserts After:");
        DL1.printNodes();
        
       
        //Remove Bill and Remove Sam:
        DL1.deleteNode(0);
        DL1.deleteNode(3);
        
        System.out.println(DL1);
    }

    public static class DoubleLinkedList {
        Node head;

        @Override
        public String toString() {
            Node current = head;
            StringBuilder sb = new StringBuilder();

            while (current != null) {
                sb.append(current.data).append(" ");
                current = current.next;
            }

            return sb.toString();
        }

        // delete Node by positon:
        public void deleteNode(int position) 
        {
        System.out.println("Deleting Node");
        if (head == null)
            return;
  
        Node temp = head;

        if (position == 0) {
            head = temp.next; 
            return;
        }
  
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;
  
        if (temp == null || temp.next == null)
            return;
  
        Node next = temp.next.next;
        temp.next = next; 
        }
    
        //insert data before given node:
        public Node insertBefore(Node givenNode, String data) {
            Node newNode = new Node(data);
            newNode.prev = givenNode.prev;
            givenNode.prev = newNode;
            newNode.next = givenNode;

            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            }

            return newNode;
        }
        //regular add Node:
        public Node insertInFront(String data) {
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = null;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;
            return newNode;
        }

        //print all nodes: 
        public void printNodes() {  
            Node current = head;  
            if(head == null) {  
                System.out.println("Doubly linked list is empty");  
                return;  
            }  
            System.out.println("Nodes of doubly linked list: ");  
            while(current != null) {  
                System.out.print(current.data + " ");  
                current = current.next;  
            }  
    }
    

        public static class Node {
            String data;
            Node prev;
            Node next;
            Node(String d) {
                data = d;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return data == node.data;
            }
        }
    }
}
