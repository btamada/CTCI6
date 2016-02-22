import java.util.Stack;

/**
 *  Stacks and Queues
 *
 *  Problem 3.2
 *
 *  How would you design a stack which, in addition to push and pop, has a function min()
 *  which returns the minimum element?  Push, pop, and min should all operate in O(1) time.
 *
 */
public class CTCI_3p2 {

    public static void main(String... args) {
        MyStack2 s = new MyStack2();
        s.push(5);
        s.push(4);
        s.push(10);
        s.push(0);
        s.push(99);
        s.push(89);
        System.out.println(s.min());
    }

    /*private static class MyStack<T> {
        private MyStackNode top = null;
        private T minData = null;

        private class MyStackNode<T extends Comparable<T>> {
            T data;
            MyStackNode next;

            protected MyStackNode(T data) {
                this.data = data;
                this.next = null;
            }
        }

        protected void push(T item) {
            MyStackNode newNode = new MyStackNode(item);
            if(top == null) {
                top = newNode;
                return;
            }
            newNode.next = top;
            top = newNode;
        }

        protected T pop() {
            if(top == null) throw new EmptyStackException();
            T data = top.data;
            top = top.next;
            return data;
        }

        protected T getMin() {
            if(minData == null) throw new EmptyStackException();
            return this.minData;
        }

        protected void setMin() {
            if(top == null) throw new EmptyStackException();
            MyStackNode curr = top;
            while(curr != null) {

            }
        }

        protected boolean isEmpty() {
            return top == null;
        }
    }*/

    /**
     *  Stack Method Implementations
     *
     *  push()
     *  if the val is less than or equal to current min val
     *      push it to the local stack
     *  push the value onto the parent stack
     *
     *  pop()
     *  pop the item off the top of the stack
     *  check if the item is the same as the min value on top of local stack
     *  return that value
     *
     *  min()
     *  if empty return the max integer value
     *  else return the item at the top of the stack
     */
    private static class MyStack2 extends Stack<Integer> {
        Stack<Integer> s;

        public MyStack2() {
            s = new Stack<Integer>();
        }

        // O(1)
        public void push(int val) {
            if(val <= min()) {
                s.push(val);
            }
            super.push(val);
        }

        // O(1)
        public Integer pop() {
            int val = super.pop();
            if(val == min()) {
                s.pop();
            }
            return val;
        }

        // O(1)
        public int min() {
            if(s.isEmpty()) {
                return Integer.MAX_VALUE;
            } else {
                return s.peek();
            }
        }

    }

}
