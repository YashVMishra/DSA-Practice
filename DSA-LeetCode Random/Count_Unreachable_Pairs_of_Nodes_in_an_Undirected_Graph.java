//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/

import java.util.ArrayList;
import java.util.List;

public class Count_Unreachable_Pairs_of_Nodes_in_an_Undirected_Graph {
    static List<List<Integer>> adj;
    static boolean vis[];

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(countPairs(n, edges));
    }

    public static long countPairs(int n, int[][] edges) {
        adj = new ArrayList<>();
        vis = new boolean[n];
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int edge[] : edges){
            int a = edge[0];
            int b = edge[1];
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        long total = ((long)n*(n-1))/2;
        
        for(int i=0;i<n;i++){
            if(!vis[i])
            {
                int nodes = dfs(i);
                
                long pairs = ((long)nodes*(nodes-1))/2;
                
                total -= pairs;
            }
        }
        
        return total;
    }

    public static int dfs(int u){
        vis[u]=true;
        
        int count = 1;
        
        for(int v: adj.get(u)){
            if(!vis[v])
                count+=dfs(v);
        }
        
        return count;
    }
}
