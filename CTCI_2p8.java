/**
 *  Linked Lists
 *
 *  Problem 2.8
 *
 *  Given a circular linked list, implement an algorithm that returns the node at the
 *  beginning of the loop.
 *
 *  Example:
 *
 *  Input: A -> B -> C -> D -> E -> C
 *  Output: C
 *
 */
public class CTCI_2p8 {

    public static void main(String... args) {
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        h.next.next.next.next.next = h.next.next;

        System.out.println(circList(h).data);
    }

    /**
     * Algorithm Design
     *
     * @param head - the pointer to the head of the list
     * @return - the node at the beginning of the loop
     *
     * keep a reference to a node that jumps 1 node
     * keep a reference to a node that jumps 2 nodes
     * iterate through the list until the slow node meet the fast node
     * return either of the nodes as they should meet at the beginning of the loop
     *
     */
    static Node circList(Node head) {
        if(head == null || head.next == null) return head;

        Node tortoise = head;
        Node hare = head.next;

        while(tortoise != hare) {
            tortoise = tortoise.next; // jump 1 node
            hare = hare.next.next; // jump 2 nodes
        }

        return tortoise;
    }

    static void print(Node h) {
        if(h == null) return;
        Node curr = h;
        while(curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();
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
