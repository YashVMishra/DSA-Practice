//https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/

import java.util.Arrays;

class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public boolean union(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset != yset) {
            if (rank[xset] < rank[yset]) {
                parent[xset] = yset;
            }

            else {
                parent[yset] = xset;
            }

            if (rank[xset] == rank[yset]) {
                rank[xset]++;
            }

            return true;
        }

        return false;
    }
}

public class Checking_Existence_of_Edge_Length_Limited_Paths {
    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = { { 0, 1, 2 }, { 1, 2, 4 }, { 2, 0, 8 }, { 1, 0, 16 } };
        int[][] queries = { { 0, 1, 2 }, { 0, 2, 5 } };

        System.out.println(Arrays.toString(distanceLimitedPathsExist(n, edgeList, queries)));
    }

    public static boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU dsu = new DSU(n);
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i };
        }

        Arrays.sort(queries, (a, b) -> Integer.compare(a[2], b[2]));
        Arrays.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        int i = 0;
        boolean[] res = new boolean[queries.length];

        for (int[] q : queries) {
            while (i < edgeList.length && edgeList[i][2] < q[2]) {
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            if (dsu.find(q[0]) == dsu.find(q[1])) {
                res[q[3]] = true;
            }
        }

        return res;
    }

}
