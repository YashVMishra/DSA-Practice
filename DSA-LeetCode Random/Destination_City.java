// https://leetcode.com/problems/destination-city/description/?envType=daily-question&envId=2023-12-15

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Destination_City {
    public static void main(String[] args) {
        List<List<String>> paths = List.of(List.of("London", "New York"), List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));

        System.out.println(destCity(paths));
    }

    // using HashMap
    public static String destCity(List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();

        for (List<String> path : paths) {
            map.put(path.get(0), 1);
        }

        for (List<String> path : paths) {
            if (!map.containsKey(path.get(1))) {
                return path.get(1);
            }
        }

        return "";
    }

    // --------------------------------------------------------------------------------------------

    // using HashSet
    public static String destCity_2(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }

        return "";
    }
}
