import java.util.Iterator;
import java.util.LinkedList;

/**
 *  Linked Lists
 *
 *  Problem 2.5
 *
 *  1) You have two numbers represented by a linked list, where each node contains a single
 *  digit.  The digits are stored in reverse order, such that the 1's digit is at the head of the list.
 *  Write a function that adds the two numebrs and returns the sum as a linked list.
 *
 *  Example:
 *  Input: (7 -> 1 -> 6) + (5 -> 9 -> 2) == 617 + 295
 *  Output: 2 -> 1 -> 9 == 912
 *
 *  2) Follow Up: Suppose the digits are stored in forward order.  Repeat the above problem.
 *
 *  Input: (6 -> 1 -> 7) + (2 -> 9 -> 5) == 617 + 295
 *  Output: 9 -> 1 -> 2 == 912
 *
 */
public class CTCI_2p5 {

    public static void main(String[] args) {
        LinkedList<Integer> ll1 = new LinkedList<>();
        LinkedList<Integer> ll2 = new LinkedList<>();

        ll1.add(6);
        ll1.add(1);
        ll1.add(7);

        ll2.add(2);
        ll2.add(9);
        ll2.add(5);

        printLinkedList(addListsForward(ll1,ll2));
    }

    static LinkedList<Integer> addListsForward(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
        if(ll1 == null || ll2 == null || ll1.size() == 0 || ll2.size() == 0) return null;
        int l1Sum = 0;
        int l2Sum = 0;
        int sum = 0;
        int c1 = 0;
        int c2 = 0;

        c1 = ll1.size() - 1;
        c2 = ll2.size() - 1;

        Iterator<Integer> i1 = ll1.iterator();
        while(i1.hasNext()) {
            l1Sum += i1.next() * Math.pow(10,c1--);
        }

        Iterator<Integer> i2 = ll2.iterator();
        while(i2.hasNext()) {
            l2Sum += i2.next() * Math.pow(10,c2--);
        }

        sum = l1Sum + l2Sum;

        LinkedList<Integer> newList = new LinkedList<>();

        while(sum > 0) {
            int remainder = sum % 10;
            newList.addFirst(remainder);
            sum /= 10;
        }

        return newList;
    }

    /**
     *
     *  Algorithm Design
     *
     *  int l1Sum = 0;
     *  int l2Sum = 0;
     *  int sum = 0;
     *
     *  loop through both linked lists to find their individuals sum
     *
     *  add each sum to the total sum
     *
     *  e.g.
     *  7 * 10^0 == 7 * 1 == 7 | sum == 7
     *  1 * 10^1 == 1 * 10 == 10 | sum == 17
     *  6 * 10^2 == 6 * 100 == 600 | sum 617
     *
     *  do the same thing with the second list | sum == 912
     *
     *  Node newHead = null;
     *
     *  while(sum > 0) {
     *      sum mod 10, add remainder to our new list
     *      if(newHead == null) newHead = new Node(remainder);
     *      else {
     *          Node current = newHead;
     *          while(current.next != null) {
     *              current = current.next;
     *          }
     *          current.next = new Node(remainder);
     *      }
     *      sum /= 10;
     *
     *      e.g.
     *      912 % 10 == 2 | add to list | 2 ->
     *      91 % 10 == 1 | add to list | 2 -> 1
     *      9 % 10 == 9 | add to list | 2 -> 1 -> 9
     *  }
     *
     *  return newHead;
     *
     * @param head1 - linked list #1
     * @param head2 - linked list #2
     * @return - linked list with summed result
     */
    static Node addListsReverse(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;
        int l1Sum = 0;
        int l2Sum = 0;
        int sum = 0;
        int c1 = 0;
        int c2 = 0;

        Node currHead1 = head1;
        while(currHead1 != null) {
            l1Sum += currHead1.data * Math.pow(10,c1++);
            currHead1 = currHead1.next;
        }

        Node currHead2 = head2;
        while(currHead2 != null) {
            l2Sum += currHead2.data * Math.pow(10,c2++);
            currHead2 = currHead2.next;
        }

        sum = l1Sum + l2Sum;

        Node newHead = null;

        while(sum > 0) {
            int remainder = sum % 10;
            if(newHead == null) newHead = new Node(remainder);
            else {
                Node current = newHead;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = new Node(remainder);
            }
            sum /= 10;
        }

        return newHead;
    }

    static void printLinkedList(LinkedList<Integer> ll) {
        if(ll == null || ll.size() == 0) return;
        Iterator<Integer> it = ll.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + "->");
        }
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
