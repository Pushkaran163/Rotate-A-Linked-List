class Node{
    int data;
    Node next;

    Node (int data){
        this.data = data;
        this.next = null;
    }
}

public class Java{

    static Node rotate(Node head, int k){
        if(k == 0 || head == null){
            return head;
        }

        Node curr = head;
        int len = 1;

        while(curr.next != null){
            curr = curr.next;
            len ++;
        }

        k %= len;

        if(k == 0){
            return head;
        }
        curr.next = head;

        curr = head;
        for(int i=1; i<k; i++){
            curr = curr.next;
        }
        head = curr.next;

        curr.next = null;

        return head;
    }

    static void printList(Node node){
        while(node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        // head.next.next.next.next = new Node(50);
        // head.next.next.next.next.next = new Node(60);

        printList(head);

        head = rotate(head, 6);

        printList(head);
    }
}