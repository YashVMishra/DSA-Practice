// https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75

public class Number_of_Provinces {
    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;

        for (int i = 0; i < isConnected[node].length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);
            }
        }
    }
}
