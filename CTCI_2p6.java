import java.util.LinkedList;

/**
 *  Linked Lists
 *
 *  Problem 2.6
 *
 *  Implement a function to check if a linked list is a palindrome.
 *
 */
public class CTCI_2p6 {

    public static void main(String... args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        ll.add(4);

        System.out.println(isPalindrome(ll));
    }

    static boolean isPalindrome(LinkedList<Integer> ll) {
        if(ll == null || ll.size() == 0) return false;
        for(int i = 0; i < ll.size(); ++i) {
            if(ll.get(i) != ll.get(ll.size() - 1 - i)) return false;
        }
        return true;
    }

}
