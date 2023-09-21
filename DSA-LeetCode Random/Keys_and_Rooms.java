// https://leetcode.com/problems/keys-and-rooms/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

public class Keys_and_Rooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);
        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);
        List<Integer> room3 = new ArrayList<>();
        room3.add(2);
        List<Integer> room4 = new ArrayList<>();
        room4.add(0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);

        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int source, boolean[] visited) {
        visited[source] = true;

        for (int i = 0; i < rooms.get(source).size(); i++) {
            int neighbour = rooms.get(source).get(i);
            if (!visited[neighbour]) {
                dfs(rooms, neighbour, visited);
            }
        }
    }
}
