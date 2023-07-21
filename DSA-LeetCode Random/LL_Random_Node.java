//https://leetcode.com/problems/linked-list-random-node/description/

import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// uses extra space.
class Solution {

    ArrayList<Integer> list = new ArrayList<>();

    public Solution(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

// uses constant space.
class Solution_2 {

    int len = 0;
    ListNode headNode;

    public Solution_2(ListNode head) {
        headNode = head;
        ListNode temp = headNode;

        while (temp != null) {
            len++;
            temp = temp.next;
        }
    }

    public int getRandom() {
        int index = (int) (Math.random() * len);

        ListNode temp = headNode;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }
}

public class LL_Random_Node {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Solution ob1 = new Solution(head);
        System.out.println(ob1.getRandom());

        Solution_2 ob2 = new Solution_2(head);
        System.out.println(ob2.getRandom());
    }
}
