/**
 *  Linked Lists
 *
 *  Problem 2.2
 *
 *  Implement an algorithm to find the kth to last element of a singly linked list.
 *
 */
public class CTCI_2p2 {

    public static void main(String... args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        int k = 0;
        System.out.println(kthLastElement(head, k));
    }

    static int kthLastElement(Node head, int k) {
        if(head == null || k < 0) throw new IllegalArgumentException("Invalid Input");
        if(head.next == null) return head.data;
        int len = 0;
        Node current = head;
        while(current != null) {
            len++;
            current = current.next;
        }
        if(k >= len) throw new IllegalArgumentException("Invalid Input");
        current = head;
        int counter = 1;
        while(counter++ < (len-k)) {
            current = current.next;
        }

        return current.data;
    }

    private static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

}
