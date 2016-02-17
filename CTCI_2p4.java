/**
 *  Linked Lists
 *
 *  Problem 2.4
 *
 *  Write code to partition a linked list around a value x, such that all nodes less than x come
 *  before all nodes greater than or equal to x.  If x is contained within the list, the values of x
 *  only need to be after the elements less tan x.  The partition element x can appear anywhere in the
 *  "right partition"; it does not need to appear between the left and right partitions.
 *
 */
public class CTCI_2p4 {

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(4);
        //print(partitionListiIterative(head, 3));
        print(partitionListRecursive(head, 2));
    }

    static void print(Node head) {
        if(head == null) return;
        Node current = head;

        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    /**
     *
     *  Algorithm Design
     *  Time: O(N)
     *  Space: O(N)
     *
     *  Create a new node with value x
     *  loop through the original linked list and build a new linked list
     *      if the next value in the linked list is less than or equal to x, create new node and point to the next front node
     *      if the next value is great than x, create a new node and point to the next rear node
     *  exit when we reach a null value (end of linked list)
     *
     *  return the head to the new linked list
     *
     */

    static Node partitionListiIterative(Node head, int x) {
        if(head == null) return head;
        Node xNode = new Node(x);
        Node frontPointer = xNode;
        Node rearPointer = xNode;
        Node current = head;

        while(current != null) {
            if(current.data < xNode.data) {
                Node temp = new Node(current.data);
                temp.next = frontPointer;
                frontPointer = temp;
            } else if(current.data > xNode.data) {
                rearPointer.next = new Node(current.data);
                rearPointer = rearPointer.next;
            }
            current = current.next;
        }
        return frontPointer;
    }

    /**
     *
     *  Algorithm Design
     *  Time: O(N)
     *  Space: O(N)
     *
     */

    static Node partitionListRecursive(Node head, int x) {
        return head;
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
