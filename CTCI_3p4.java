import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  Stacks and Queues
 *
 *  Problem 3.4
 *
 *  Implement a MyQueue class which implements a queue using two stacks.
 *
 */
public class CTCI_3p4 {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.enqueue(10);
        mq.enqueue(20);
        mq.enqueue(30);
        mq.enqueue(40);
        mq.print();
        System.out.println("Dequeued Item: " + mq.dequeue());
        mq.enqueue(50);
        System.out.println("Dequeued Item: " + mq.dequeue());
        mq.print();
    }

    /**
     *
     * Approach:
     * One half of the stack pops elements out like dequeue
     * Other half of the stack pushes elements onto the queue like enqueue
     *
     * How do you pop from the inQueue and into the outQueue?
     *
     *
     */
    private static class MyQueue {
        Stack<Integer> outQueue = new Stack<>();
        Stack<Integer> inQueue = new Stack<>();

        public void print() {
            if(inQueue.isEmpty() && outQueue.isEmpty()) throw new EmptyStackException();

            // move all stack items from outQueue to inQueue
            while(!inQueue.isEmpty()) {
                outQueue.add(inQueue.pop());
            }

            // move the stacks items back over to the outQueue stack
            while(!outQueue.isEmpty()) {
                int temp = outQueue.pop();
                System.out.println(temp);
                inQueue.add(temp);
            }

        }

        /**
         * TC: O(1)
         * SC: O(1)
         *
         * Pop the first item off the stack of outQueue
         *
         * @param val - the value to place onto the queue
         */
        public void enqueue(int val) {
            inQueue.add(val);
        }

        /**
         * TC: O(N)
         * SC: O(N)
         *
         * Move all stack items from the the inQueue to the outQueue.  Dequeue the first stack item in outQueue
         * then move all of the stack items back into outQueue.
         *
         * @return
         */
        public int dequeue() {
            if(inQueue.isEmpty() && outQueue.isEmpty()) throw new EmptyStackException();

            // move all stack items from outQueue to inQueue
            while(!inQueue.isEmpty()) {
                outQueue.add(inQueue.pop());
            }

            // pop the first stack item from the outQueue
            int deqItem = outQueue.pop();

            // move the stacks items back over to the outQueue stack
            while(!outQueue.isEmpty()) {
                inQueue.add(outQueue.pop());
            }

            return deqItem;
        }

    }

}
