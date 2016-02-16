/**
 *  Linked Lists
 *
 *  Problem 2.3
 *
 *  Implement an algorithm to delete a node in the middle (i.e. any node but the first
 *  and last node, not necessarily the exact middle) of a singly linked list, given only
 *  access to that node.
 *
 *  (0) -> (1) -> (3) -> (3) -> (4)
 */
public class CTCI_2p3 {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        printList(head);
        deleteMiddleNode(head.next.next);
        printList(head);
    }

    static void printList(Node head) {
        if(head == null) return;
        Node current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    static void deleteMiddleNode(Node delNode) {
        if(delNode == null) throw new IllegalArgumentException("Invalid Input");
        delNode.data = delNode.next.data;
        delNode.next = delNode.next.next;
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
