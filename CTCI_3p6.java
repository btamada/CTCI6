import java.util.LinkedList;

/**
 *  Stacks and Queues
 *
 *  Problem 3.6
 *
 *  Am animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
 *  People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can
 *  select whether they would prefer a dog or a cat ( and will receive the oldest animal of that type).  They
 *  cannot select which specific animal they would like.  Create the data structures to maintain this system
 *  and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.  You may use the built-in
 *  LinkedList data structure.
 *
 */
public class CTCI_3p6 {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        enqueue(ll,"dog");
        enqueue(ll,"cat");
        enqueue(ll,"dog");
        enqueue(ll,"cat");
        enqueue(ll,"cat");
        enqueue(ll,"cat");
        enqueue(ll,"dog");
        enqueue(ll,"dog");
        enqueue(ll,"cat");
        enqueue(ll,"dog");
        dequeueAny(ll);
        dequeueAny(ll);
        dequeueAny(ll);
        dequeueAny(ll);
        dequeueAny(ll);
        dequeueAny(ll);
        enqueue(ll,"cat");
        enqueue(ll,"cat");
        enqueue(ll,"cat");
        dequeueCat(ll);
        printList(ll);
        dequeueDog(ll);
        printList(ll);
    }

    static void printList(LinkedList<String> ll) {
        if(ll == null || ll.isEmpty()) return;
        for(int i = 0; i < ll.size(); ++i) {
            System.out.println(ll.get(i));
        }
        System.out.println();
    }

    static void enqueue(LinkedList<String> ll, String pet) {
        if(ll == null) return;
        ll.add(pet);
    }

    static String dequeueAny(LinkedList<String> ll) {
        if(ll == null || ll.isEmpty()) return "";
        return ll.remove();
    }

    static String dequeueDog(LinkedList<String> ll) {
        if(ll == null || ll.isEmpty()) return "";
        for(int i = 0; i < ll.size(); ++i) {
            if(ll.get(i).equals("dog")) {
                return ll.remove(i);
            }
        }
        return "No more dogs...";
    }

    static String dequeueCat(LinkedList<String> ll) {
        if(ll == null || ll.isEmpty()) return "";
        for(int i = 0; i < ll.size(); ++i) {
            if(ll.get(i).equals("cat")) {
                return ll.remove(i);
            }
        }
        return "No more cats...";
    }

}
