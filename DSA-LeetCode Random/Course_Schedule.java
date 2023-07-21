//https://leetcode.com/problems/course-schedule/description/

public class Course_Schedule {
    public static void main(String[] args) {
        int[][] arr = { { 0, 10 }, { 3, 18 }, { 5, 5 }, { 6, 11 }, { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 } };
        System.out.println(canFinish(20, arr));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;

        boolean[][] adj = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(adj, i, visited, explored)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isCyclic(boolean[][] adj, int i, boolean[] visited, boolean[] explored) {
        visited[i] = true;

        for (int j = 0; j < adj.length; j++) {
            if (adj[i][j]) {

                if (!visited[j]) {

                    if (isCyclic(adj, j, visited, explored))
                        return true;
                }

                else if (!explored[j])
                    return true;
            }
        }

        explored[i] = true;
        return false;
    }
}
