// https://leetcode.com/problems/seat-reservation-manager/description/?envType=daily-question&envId=2023-11-06

import java.util.Arrays;
import java.util.PriorityQueue;

// shows TLE.
class SeatManager {
    int[] arr;

    public SeatManager(int n) {
        arr = new int[n + 1];
        Arrays.fill(arr, -1);
    }

    public int reserve() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                arr[i] = 1;
                return i;
            }
        }

        return 0;
    }

    public void unreserve(int seatNumber) {
        arr[seatNumber] = -1;
    }
}

// ------------------------------------------------------------------------------------------

// accepted.
class SeatManager_2 {
    PriorityQueue<Integer> pq;

    public SeatManager_2(int n) {
        pq = new PriorityQueue<Integer>();
        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
    }

    public int reserve() {
        int seat = pq.poll();
        return seat;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

// ------------------------------------------------------------------------------------------

// accepted.
class SeatManager_3 {
    PriorityQueue<Integer> pq;
    int seatMarker;

    public SeatManager_3(int n) {
        pq = new PriorityQueue<Integer>();
        seatMarker = 1;
    }

    public int reserve() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }

        return seatMarker++;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

public class Seat_Reservation_Manager {
    public static void main(String[] args) {
        SeatManager_3 obj = new SeatManager_3(5);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(2);
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        System.out.println(obj.reserve());
        obj.unreserve(5);
        System.out.println(obj.reserve());
    }
}
