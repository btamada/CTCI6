import com.sun.tools.internal.xjc.reader.gbind.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 *  Trees and Graphs
 *
 *  Problem 4.1
 *
 *  Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 */
public class CTCI_4p1 {

    public static void main(String... foobar) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> r0 = new ArrayList<>();
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        ArrayList<Integer> r3 = new ArrayList<>();
        ArrayList<Integer> r4 = new ArrayList<>();
        ArrayList<Integer> r5 = new ArrayList<>();
        ArrayList<Integer> r6 = new ArrayList<>();
        adjList.add(r0);
        adjList.add(r1);
        adjList.add(r2);
        adjList.add(r3);
        adjList.add(r4);
        adjList.add(r5);
        adjList.add(r6);
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(4).add(6);
        adjList.get(5).add(4);
        adjList.get(6).add(5);
        System.out.println(findRoute(adjList,6,5));
    }

    private static boolean findRoute(ArrayList<ArrayList<Integer>> myGraph, int start, int finish) {
        if(start == finish) return true;
        for(int i = 0; i < myGraph.size(); ++i) {
            for(int j = 0; j < myGraph.get(i).size(); ++j) {
                if(i == start && myGraph.get(i).contains(finish)) return true;
            }
        }
        return false;
    }

}
