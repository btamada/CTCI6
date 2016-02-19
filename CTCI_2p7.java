/**
 *  Linked Lists
 *
 *  Problem 2.7
 *
 *  Given two singly linked lists, determine if the two lists intersect.  Return the intersecting node.
 *  Note that the intersection is defined based on reference, not value.  That is, if the kth node of the
 *  first linked list is the exact same node (by reference) as the jth node of the second linked list, then
 *  they are intersecting.
 *
 */
public class CTCI_2p7 {

    public static void main(String... args) {
        // add nodes to list 1
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);

        //print(h1);

        // add nodes to list 2
        Node h2 = new Node(5);
        h2.next = new Node(6);
        h2.next.next = new Node(7);
        h2.next.next.next = new Node(8);
        h2.next.next.next.next = new Node(3);
        h2.next.next.next.next.next = new Node(9);

        //print(h2);

        System.out.println(intersectingLists(h1,h2));
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

    /**
     *
     *  Algorithm Design
     *
     *  @param h1 - head pointer to list 1
     *  @param h2 - head pointer to list 2
     *  @return - boolean value if the lists intersect with each other
     *
     *  iterate through one of the lists
     *      iterate through the other list
     *          if references are same then return true
     *          set the iterator to the next inner node
     *      reset the inner next by pointer to its head
     *      set the iterator for the next outer node
     *  return false
     *
     */
    static boolean intersectingLists(Node h1, Node h2) {
        if(h1 == null || h2 == null) return false;
        Node c1 = h1;
        Node c2 = h2;

        while(c1 != null) {

            while(c2 != null) {

                if(c1 == c2) return true;
                c2 = c2.next;
            }
            c2 = h2;
            c1 = c1.next;
        }

        return false;
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
