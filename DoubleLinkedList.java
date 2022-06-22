/* 
Double Linked List; Data Structures; 
Illinois State University; Scott Schmidt
Working Java Verision  https://code.sololearn.com/crPPoRZPg584
Python Verision  https://github.com/ScottySchmidt/DataStructures/blob/main/DoubleLinkedList.ipynb


--------------------------------------------------------------
## Part A
Node < String > nodeRef = tail.prev;    # new node becomes second last in LinkedLinked
nodeRef.prev.next = tail;            # second last node from LinkedList gets removed  
tail.prev = nodeRef.prev             # sets linkedList to previous Node


## Part B
Node < String > NodeRef # temp new head
head = new node< > ("Tamika"); # head becomes new node
head.next = nodeRef; # head becomes next node
nodeRef.prev = head; # old head to new head 

## Part C
Node < String > node Ref = new Node< > ("Shakira") # new node Shakira created
nodeRef.prev = head; # previous Node becomes head of LinkedList
nodeRef.next = head.next; # next node becoomes next LinkedList
head.next.prev = nodeRef  # head of LinkedList gets removed and becomes next
head.next = nodeRef; # set head to new node
*/


import java.util.Objects;

public class DoubleLinkLists {

    public static void main(String[] args) {
        DoubleLinkedList DL1 = new DoubleLinkedList();

        //ORIGINAL LINKED LIST:
        DoubleLinkedList.Node nodeSam = DL1.insertInFront("Sam");
        DoubleLinkedList.Node nodeHarry = DL1.insertInFront("Harry");
        DoubleLinkedList.Node nodeDick = DL1.insertInFront("Dick");
        DoubleLinkedList.Node nodeTom = DL1.insertInFront("Tom");
        System.out.println(DL1);

        //INSERTS BEFORE:
        DL1.insertBefore(nodeTom, "Bill"); // Insert Bill Before Tom:
        DL1.insertBefore(nodeSam, "Sue"); //Insert Sue Before Sam:
        DL1.insertBefore(nodeHarry, "Will"); // Insert Will Before Harry:
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
        System.out.println("\nDeleting Node at position: " + position );
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
            System.out.println("Add New Node: "+ data);
            newNode = head;
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
            //System.out.println("Nodes of doubly linked list: ");  
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
