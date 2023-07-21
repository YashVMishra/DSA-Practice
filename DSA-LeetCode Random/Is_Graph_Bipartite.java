import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    // color code
    // 0 --> not colored
    // 1 --> blue
    // -1 --> red

    // using BFS.
    public static boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;

                while (!q.isEmpty()) {
                    Integer node = q.poll();

                    for (int n : graph[node]) {
                        if (colors[n] == colors[node]) {
                            return false;
                        } else if (colors[n] == 0) {
                            q.add(n);
                            colors[n] = -colors[node];
                        }
                    }
                }
            }
        }

        return true;
    }

    // DFS solution.
    public static boolean isBipartite_2(int[][] graph) {
        int[] colors = new int[graph.length];

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0 && !isValidColor(graph, 1, colors, i)) {
                return false;
            }
        }

        return true;
    }

    // DFS solution.
    public static boolean isValidColor(int[][] graph, int reqCol, int[] colors, int node) {
        if (colors[node] != 0) {
            return colors[node] == reqCol;
        }

        colors[node] = reqCol;

        for (int n : graph[node]) {
            if (isValidColor(graph, -reqCol, colors, n) == false) {
                return false;
            }
        }

        return true;
    }
}
