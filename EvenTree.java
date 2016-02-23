import java.util.Scanner;

/**
 * Created by Bryan Tamada on 1/4/16.
 */
public class EvenTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // # of vertices
        int M = sc.nextInt(); // # of edges
        int countOfRemovedEdges = 0;

    }

    class Node {
        int data;
        int size;
        Node[] children;

        public Node(int data) {
            this.data = data;
            this.size = 1;
            this.children = new Node[26];
        }
    }

}
