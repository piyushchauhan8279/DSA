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
            head=null;
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







    public static void main(String[] args) {
        Doubly dll=new Doubly();
        dll.addFirst(10);
        dll.addFirst(5);
        dll.addFirst(10);
        dll.addFirst(15);
        dll.addLast(100);

        dll.addMiddle(200,2);
        dll.addMiddle(300,4);
        dll.print();
        System.out.println();
        System.out.println(dll.removeFirst());

        dll.print();
    }
}
















