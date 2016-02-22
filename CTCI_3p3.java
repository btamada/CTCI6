import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *  Stacks and Queues
 *
 *  Problem 3.3
 *
 *  Imagine you have a stack of plates.  If the stack gets too high, it might topple.  Therefore, in
 *  real life, we would likely start a new stack when the previous stack exceeds some threshold.  Implement
 *  a data structure SetOfStacks that mimics this.  SetOfStacks should be composed of several stacks and should
 *  create a new stack once the previous one exceeds the capacity.  SetOfStacks.push() and SetOfStacks.pop() should
 *  behave identically to a single, regular stack.
 *
 *
 *  FOLLOW UP:
 *  Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *
 */
public class CTCI_3p3 {

    public static void main(String... foobar) {
        SetOfStacks s = new SetOfStacks(10);
        s.push(10);
    }

    /**
     *  Algorithm Design
     *
     *  create a constant holding the capacity of the stack
     *
     *  push() - uses the parent's push method
     *  pop() - uses the parent's pop method
     *  popAt() [FU] - pop an item from a specified index
     *
     */
    private static class SetOfStacks extends Stack<Integer> {
        private ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        private int capacity;

        public SetOfStacks(int capacity) {
            this.capacity = capacity;
        }

        /**
         *
         * Algorithm Design
         *
         * 4 Stacks in ArrayList
         *
         * Case 1:
         * If an element is popped off the last element of the last stack then we don't need to do anything
         *
         * Case 2:
         * If we pop an element off anywhere else then we could do a couple of things:
         *  1) Shift all the elements from the succeeding stacks over
         *      TC: O(S * E)
         *  2) Do not make any changes
         *      TC: O(
         *
         * @param index - the index of the element to pop off the stack
         * @return - the element popped off the stack
         */
        public Integer popAt(int index) {
            if(stacks.isEmpty()) throw new EmptyStackException();
            if(index >= stacks.size()) throw new IllegalArgumentException();
            Stack<Integer> stkInd = stacks.get(index);
            return stkInd.pop();
        }

        public void push(int val) {
            // add new stack if arraylist is empty
            if(stacks.isEmpty()) {
                Stack<Integer> newStack = new Stack();
                newStack.add(val);
                stacks.add(newStack);
                return;
            }
            // get the latest stack in the arraylist
            Stack<Integer> lastStack = stacks.get(stacks.size()-1);
            if(lastStack.size() == this.capacity) {
                Stack<Integer> ns = new Stack();
                ns.add(val);
                stacks.add(ns);
            } else {
                lastStack.add(val);
            }
        }

        public Integer pop() {
            // arraylist is empty
            if(stacks.isEmpty()) throw new EmptyStackException();
            Stack<Integer> lastStack = stacks.get(stacks.size()-1);
            return lastStack.pop();
        }
    }

}
