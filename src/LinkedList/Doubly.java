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
    }

    public static void main(String[] args) {
        Doubly dll=new Doubly();
        dll.addFirst(10);
        dll.addFirst(5);
        dll.addFirst(10);
        dll.addFirst(15);
        dll.print();




    }
}
