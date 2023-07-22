import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Edge {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class Traversals {
    public static void main(String[] args) {

        /*
         * 1 --- 3
         * / | \
         * 0 | 5 --- 6
         * \ | /
         * 2 --- 4
         */

        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];

        buildGraph(graph);
        BFS(graph);

        boolean[] visited = new boolean[V];
        DFS(graph, 0, visited);
    }

    public static void buildGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    public static void BFS(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        // taking starting point as 0 index.
        q.add(0);

        while (!q.isEmpty()) {
            int current = q.poll();

            if (!visited[current]) {
                System.out.print(current + " ");
                visited[current] = true;

                for (int i = 0; i < graph[current].size(); i++) {
                    Edge e = graph[current].get(i);
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    public static void DFS(ArrayList<Edge>[] graph, int current, boolean[] visited) {
        System.out.print(current + " ");
        visited[current] = true;

        for (int i = 0; i < graph[current].size(); i++) {
            Edge e = graph[current].get(i);

            if (!visited[e.dest]) {
                DFS(graph, e.dest, visited);
            }
        }
    }
}
