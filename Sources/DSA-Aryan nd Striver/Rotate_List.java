//https://leetcode.com/problems/rotate-list/description/

// first convert the LL into a list and then rotate the list k times and then just
// build the LL from the rotated LL>

// for rotation see the question.
// https://leetcode.com/problems/rotate-array/

import java.util.ArrayList;
import java.util.Arrays;

public class Rotate_List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int k = 2;
        ListNode head = buildLL(list);

        display(rotateRight(head, k));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add((int) (temp.val));
            temp = temp.next;
        }

        ArrayList<Integer> rotatedList = rotate(list, k);
        return buildLL(rotatedList);
    }

    // building the LL.
    public static ListNode buildLL(ArrayList<Integer> rotatedList) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        for (int i : rotatedList) {
            head.next = new ListNode(i);
            head = head.next;
        }

        return dummy.next;
    }

    // rotating the list.
    public static ArrayList<Integer> rotate(ArrayList<Integer> list, int k) {
        ArrayList<Integer> temp = new ArrayList<>(list);

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            int index = (i + k) % list.size();
            temp.set(index, element);
        }

        return temp;
    }

    // display function.
    public static void display(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("END");
    }
}
