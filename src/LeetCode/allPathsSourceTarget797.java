package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class allPathsSourceTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> route = new LinkedList<>();
        travel(graph,0,route,res);
        return res;
    }

    void travel(int[][] graph, int node, LinkedList<Integer> route, List<List<Integer>> res) {
        if (node == graph.length - 1) {
            route.add(node);
            res.add(new LinkedList<>(route));
            route.remove((Integer)node);
            return;
        }

        route.add(node);
        for (Integer i : graph[node]) {
            System.out.println("enter:" + i);
            travel(graph, i, route, res);
        }
        route.remove((Integer)node);
    }
}
