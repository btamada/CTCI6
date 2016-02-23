import java.util.Stack;

/**
 *  Stacks and Queues
 *
 *  Problem 3.5
 *
 *  Write a program to sort a stack such that the smallest items are on the top.  You can use
 *  an additional temporary stack, but you may not copy the elements into any other data structure
 *  (such as an array).  The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 */
public class CTCI_3p5 {

    public static void main(String... foobar) {
        Stack<Integer> myStack = new Stack<>();
        myStack.add(10);
        myStack.add(4);
        myStack.add(55);
        myStack.add(100);
        myStack.add(1);
        myStack.add(0);
        myStack.add(17);

        sortStack(myStack);

        printStack(myStack);

    }

    static void printStack(Stack<Integer> s) {

        Stack<Integer> tmpStack = new Stack<>();

        while(!s.isEmpty()){
            int tmp = s.pop();
            System.out.println(tmp);
            tmpStack.add(tmp);
        }

        while(!tmpStack.isEmpty()){
            s.add(tmpStack.pop());
        }
    }

    /**
     *  Algorithm Design
     *
     *  @param s - the stack to sort
     *
     *  Note: You can use a temporary stack.
     *
     *  iterate through the original stack
     *      iterate through the item(s) on the temporary stack
     *           place the top stack item from the original stack in its correct place on the temp stack
     *           move the items placed on the original stack back to the temp stack
     *           keep a counter to keep track of how many items are moved back to the original stack
     *
     *  iterate through temp stack to move the items from temp stack -> original stack so smallest items on top
     *
     */
    static void sortStack(Stack<Integer> s) {
        if(s == null || s.isEmpty()) return;
        Stack<Integer> tmpSt = new Stack<>(); // holder for sorting stack items
        int counter = 0; // counter to keep track of items held in original stack
        tmpSt.add(s.pop()); // place first item onto the temp stack
        // sort the original stack items
        while(!s.isEmpty()) {
            int orgStTop = s.pop();

            // if the stack item is greater than we place it on the top of the temp stack
            if(orgStTop > tmpSt.peek()) {
                tmpSt.add(orgStTop);
            } else { // if the stack item is less than or equal to the top of the temp stack
                // find the correct place on the temp stack to put the new stack item
                while (!tmpSt.isEmpty() && tmpSt.peek() > orgStTop) {
                    s.add(tmpSt.pop());
                    counter++;
                }

                // add the item into its correct place onto the temp stack
                tmpSt.add(orgStTop);

                // add the items back onto the temp stack
                while (counter > 0) {
                    tmpSt.add(s.pop());
                    counter--;
                }
            }
        }

        // add the items back onto the original stack so smallest items on top
        while(!tmpSt.isEmpty()) {
            s.add(tmpSt.pop());
        }
    }

}
