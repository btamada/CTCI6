import java.util.HashSet;

/**
 *  Linked Lists
 *
 *  Problem 2.1
 *
 *  - Write code to remove duplicates from an unsorted linked list.
 *  - How would you solve this problem is a temporary buffer is not used?
 */
public class CTCI_2p1 {

    public static void main(String... args) {
        Node head = new Node(0);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(0);

        //removeDuplicatesBuffer(head); // remove duplicates w/ buffer
        //removeDuplicatesNoBuffer(head); // remove duplicates w/o buffer

        printList(head); // print out the linked list
    }

    static void printList(Node head) {
        if(head == null) return;
        Node current = head;
        while(current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    /**
     *
     *  Algorithm Design
     *
     *  Time: O(N**2)
     *  // inner loop (n - 1) + (n - 2) + (n - 3) ... 2, 1
     *  // n(n - 1) / 2 -> O(n**2)
     *  Space: O(1)
     *
     *  loop through the entire linked list to find the length
     *      increment the counter "n" each iteration
     *
     *  loop n times
     *      loop through the remainder of the linked list
     *          keep track of the first value
     *              if find a duplicate in the next node then set the current node's next
     *              pointer to point to the next next node
     *
     */
    static void removeDuplicatesNoBuffer(Node head) {
        if(head == null) return;
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /**
     *
     *  Algorithm Design
     *  Time: O(N)
     *  Space: O(N)
     *
     *  Use a HashMap to keep track of the nodes we already visited
     *
     *  loop through the entire linked list
     *     if the key is not already in the hashmap then we will insert it into the hashmap
     *     else the key is already in the hashmap
     *          check the current node's next pointer
     *              if pointing another node then we will set the next point to the next next node
     *     set current node to the next node in the linked list
     *  exit the loop when the current node is equal to null
     */
    static void removeDuplicatesBuffer(Node n) {
        if(n == null || n.next == null) return;
        HashSet<Integer> set = new HashSet<>();
        Node prev = null;
        while(n != null) {
            if(set.contains(n.val)) {
                prev.next = n.next;
            } else {
                set.add(n.val);
                prev = n;
            }
            n = n.next;
        }
    }

    private static class Node {
        int val;
        Node next;

        private Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

}
