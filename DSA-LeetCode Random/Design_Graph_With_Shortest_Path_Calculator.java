import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Node {
    int node;
    int cost;

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Graph {
    Map<Integer, List<Node>> adj;
    int[] result;
    PriorityQueue<Node> pq;

    public Graph(int n, int[][] edges) {
        adj = new HashMap<>();
        result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(new Node(edge[1], edge[2]));
        }
    }

    public void addEdge(int[] edge) {
        adj.putIfAbsent(edge[0], new ArrayList<>());
        adj.get(edge[0]).add(new Node(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        Arrays.fill(result, Integer.MAX_VALUE);
        result[node1] = 0;
        pq.offer(new Node(node1, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int d = pq.poll().cost;

            for (Node vec : adj.getOrDefault(node, Collections.emptyList())) {
                int adjNode = vec.node;
                int dist = vec.cost;

                if (d + dist < result[adjNode]) {
                    result[adjNode] = d + dist;
                    pq.offer(new Node(adjNode, d + dist));
                }
            }
        }

        return result[node2] == Integer.MAX_VALUE ? -1 : result[node2];
    }
}

public class Design_Graph_With_Shortest_Path_Calculator {
    public static void main(String[] args) {
        int[][] edges = { { 0, 1, 4 }, { 0, 7, 8 }, { 1, 2, 8 }, { 1, 7, 11 }, { 2, 3, 7 }, { 2, 8, 2 }, { 2, 5, 4 },
                { 3, 4, 9 }, { 3, 5, 14 }, { 4, 5, 10 }, { 5, 6, 2 }, { 6, 7, 1 }, { 6, 8, 6 }, { 7, 8, 7 } };

        Graph graph = new Graph(9, edges);

        System.out.println(graph.shortestPath(0, 4));
        System.out.println(graph.shortestPath(0, 8));
        System.out.println(graph.shortestPath(1, 3));
        System.out.println(graph.shortestPath(2, 6));
        System.out.println(graph.shortestPath(3, 7));
        System.out.println(graph.shortestPath(4, 8));
        System.out.println(graph.shortestPath(5, 7));
        System.out.println(graph.shortestPath(6, 8));
    }
}
