//Double Linked List; Data Structures; 
//Illinois State University; Scott Schmidt
//Working Java Verision  https://code.sololearn.com/cySmtVG72DKr
//Python Verision  https://github.com/ScottySchmidt/DataStructures/blob/main/DoubleLinkedList.ipynb

class DoublyLinkedList {    
    class Node{  
        String item;  
        Node previous;  
        Node next;  
   
        public Node(String item) {  
            this.item = item;  
        }  
    }  
    Node head, tail = null;  
   
    //add a node to the list  
    public void addNode(String item) {  
        Node newNode = new Node(item);  
   
        if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
            tail.next = newNode;  
            newNode.previous = tail;  
            tail = newNode;  
            tail.next = null;  
        }  
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
            System.out.print(current.item + " ");  
            current = current.next;  
        }  
    }  

    public static void main(String[] args) {  
        System.out.println("Main");
        DoublyLinkedList dl_List = new DoublyLinkedList();  

        //Add nodes to the list:  
        dl_List.addNode("Sam");  
        dl_List.addNode("Harry");  
        dl_List.addNode("Dick");  
        dl_List.addNode("Tom");  

        dl_List.printNodes(); 

        //Delete node:

        //print the nodes of DoublyLinkedList:  
       
    }  
}  
