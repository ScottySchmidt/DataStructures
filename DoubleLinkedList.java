//Double Linked List; Data Structures; 
//Illinois State University; Scott Schmidt
//Working Java Verision  https://code.sololearn.com/crPPoRZPg584
//Python Verision  https://github.com/ScottySchmidt/DataStructures/blob/main/DoubleLinkedList.ipynb

import java.util.Objects;

public class DoubleLinkLists {

    public static void main(String[] args) {
        System.out.println("Main Test:");
        DoubleLinkedList DL1 = new DoubleLinkedList();


        //Original Names:
        DoubleLinkedList.Node nodeSam = DL1.insertInFront("Sam");
        DoubleLinkedList.Node nodeHarry = DL1.insertInFront("Harry");
        DoubleLinkedList.Node nodeDick = DL1.insertInFront("Dick");
        DoubleLinkedList.Node nodeTom = DL1.insertInFront("Tom");
        System.out.println(DL1);

        // Insert Bill Before Tom:
        DoubleLinkedList.Node nodeBob = DL1.insertBefore(nodeTom, "Bill");

        //Insert Sue Before Sam:
        DoubleLinkedList.Node nodeSue = DL1.insertBefore(nodeSam, "Sue");
        System.out.println(DL1);

        //Remove Bill and Remove Sam:
        DL1.deleteNode(0);
        DL1.deleteNode(2);
        
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

        public void deleteNode(int key) {
        Node temp = head, prev = null;
 
        if ( ( temp != null) && (temp.data.equals(key)) ) {
            head = temp.next; // Changed head
            return;
        }
 
        // Search for the key to be deleted
        while ( ( temp != null) && (!temp.data.equals(key )) ) {
            prev = temp;
            temp = temp.next;
        }
 
        if (temp == null)
            return;
 
        prev.next = temp.next;
    }

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
