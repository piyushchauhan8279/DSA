package LinkedList;

public class Singly {

    public  static Node head;
    public  static Node tail;
    public  static int size=0;

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    // function to print linkedlist:-

    public  void print(Node head){
        Node temp=head;

        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("null");
    }

    // function to add node at the starting of linkedlist

    public  void addFirst(int data){
        Node newNode =new Node(data);
        size++;

        // if linkedlist is empty

        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    // function to add element in the last of linkedlist:-

    public  void addLast(int data){
        Node newNode =new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
        }
       tail.next=newNode;
       tail=newNode;
    }

    // function to add node in the middle of the linkedlist

    public  void addMiddle(int data,int idx){
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while (i<idx-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    // function to remove node from first of linkedlist

    public int removeFirst(){
        if(size==0){
            System.out.println("Empty LinkedList");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    // function to remove the node from the last of linkedlist :-
    public int removeLast(){
        if(size==0){
            System.out.println("Empty LinkedList");
            return Integer.MAX_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        Node prev=head;
        int i=0;
        while(i<size-2){
            prev=prev.next;
            i++;

        }
        int val=prev.next.data;
        prev.next=null;
        size--;
        tail=prev;
        return val;
    }

    public int removeMiddle(int idx){
        if(idx<0 || idx>size-1){
            System.out.println("invalid idx");
            return Integer.MAX_VALUE;
        }
        if(size==0){
            System.out.println("empty linkedlist");
            return Integer.MAX_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }

        int i=0;
        Node temp=head;
        while(i<idx-1){
            temp=temp.next;
            i++;
        }
        int val=temp.next.data;
        if(idx==size-1){
            // removing tail node
            tail=temp;
            temp.next=null;

        }else{
            temp.next=temp.next.next;

        }


        size--;
        return val;
    }

    // function to search a key in a ll using loops

    public int searchKey(int key){
        Node temp=head;
        int pos=1;
        while(temp!=null){
            if(temp.data==key){
                return pos;
            }
            temp=temp.next;
            pos++;
        }
        return -1;
    }

    // function to search a key in ll using recursion
    public int searchKey2(int key){
        return helper(key,head);
    }

    public int helper(int key,Node head){
        if(head==null) return -1;
        if(head.data==key) return 1;
        int i=helper(key,head.next);
        if(i==-1){
            return -1;
        }
        return i+1;
    }

    // function to reverse a ll:-

    public Node reverse(Node head){
        // 3 variables:-
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    // function to remove nth node from the end of linkedlist:-

    // remove from end == size-n+1

    public void removeFromEnd(int n){
        if(n==0) return;
        Node temp=head;
        if(n==size){
            head=head.next;
            return;
        }

        for(int i=1;i<size-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;



    }




    public static void main(String[] args) {
        Singly s=new Singly();
        s.addLast(1);
        s.addLast(2);
        s.addLast(3);
        s.addLast(4);
        s.addLast(5);

        s.print(head);
        System.out.println();

        s.removeFromEnd(1);
        s.print(head);



    }
}
