//https://leetcode.com/problems/snapshot-array/description/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Snapshot_Array {
    public static void main(String[] args) {
        SnapshotArray ob = new SnapshotArray(3);
        ob.set(0, 5);
        System.out.println(ob.snap());
        ob.set(0, 6);
        System.out.println(ob.get(0, 0));
    }
}

class SnapshotArray {
    private Map<Integer, TreeMap<Integer, Integer>> snaps;
    private int snapId;

    public SnapshotArray(int length) {
        snaps = new HashMap<>();
        snapId = 0;

        for (int i = 0; i < length; i++) {
            TreeMap<Integer, Integer> mp = new TreeMap<>();
            mp.put(0, 0);
            snaps.put(i, mp);
        }
    }

    public void set(int index, int val) {
        snaps.get(index).put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> snapMap = snaps.get(index);
        Map.Entry<Integer, Integer> entry = snapMap.floorEntry(snapId);
        return entry.getValue();
    }
}
