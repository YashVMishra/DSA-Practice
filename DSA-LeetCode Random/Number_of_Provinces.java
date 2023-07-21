//https://leetcode.com/problems/number-of-provinces/

public class Number_of_Provinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}
