package LinkedList;

public class Doubly {

    public static Node head;
    public static Node tail;
    public static int size=0;

    public static  class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

        // function to add node in the starting of linkedlist:-

        public void addFirst(int data){
            Node newNode =new Node(data);
            size++;
            if(head==null || tail==null){
                head=tail=newNode;
                return;
            }
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }

        // function to print the doubly linkedlist:-

    public void print(){
        Node curr=head;
        System.out.print("null <-> ");
        while(curr!=null){
            System.out.print(curr.data+" <-> ");
            curr=curr.next;
        }
        System.out.print("null");
        System.out.println();
    }

    // function to add node in the last of double linkedlist:-
    public void addLast(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }

        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;
        tail.next=null;

    }

    // function to add element in the middle of linkedlist:-

    public void addMiddle(int data,int idx){
        Node newNode =new Node(data);
        size++;
        if(head==null ){
            head=tail=newNode;
            return;
        }
        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }

        newNode.next=temp.next;
        temp.next.prev=newNode;
        newNode.prev=temp;
        temp.next=newNode;
    }

    // function to remove node form the starting of the linkedlist:-

    public int removeFirst(){

        if(head==null){
            System.out.print("Empty Linked List");
            return Integer.MAX_VALUE;
        }
        if(head.next==null){
            head=tail=null;
            size=0;
            return Integer.MAX_VALUE;

        }
        size--;
        int val=head.data;
        head=head.next;
        head.prev=null;
        return val;
    }

    //function to remove element from the end of the linkedlist:-

    public int removeLast(){
        if(head==null){
            System.out.println("empty ll");
            return Integer.MIN_VALUE;
        }
        else if(head.next==null){
            head=tail=null;
            return Integer.MIN_VALUE;

        }
        int val=tail.data;
        tail=tail.prev;
        tail.next=null;
        return val;
    }

    // function to remove middle of a linked list:-

    public int removeMiddle(int idx) {
        if (head == null) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }

        // If removing the first node
        if (idx == 0) {
            return removeFirst();
        }

        Node temp = head;
        int i = 0;

        // Traverse to the node before the target index
        while (i < idx - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }

        // Check if idx is out of bounds
        if (temp.next == null) {
            System.out.println("Index out of bounds");
            return Integer.MIN_VALUE;
        }

        // If removing the last node
        if (temp.next.next == null) {
            return removeLast();
        }

        // Standard middle node removal
        int val = temp.next.data;
        temp.next = temp.next.next;
        if (temp.next != null) {
            temp.next.prev = temp; // Ensure `prev` is updated properly
        }

        return val;
    }


    public static void main(String[] args) {
        Doubly dll=new Doubly();
        dll.addFirst(2);
        dll.addFirst(1);


        dll.addLast(5);

        dll.addMiddle(3,2);
        dll.addMiddle(4,3);
        dll.print();

        System.out.println(dll.removeFirst());


        System.out.println(dll.removeLast());

        dll.print();

        System.out.println(dll.removeMiddle(1));

        dll.print();


    }
}
















