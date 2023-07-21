//https://leetcode.com/problems/intersection-of-two-linked-lists/description/

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

public class Intersection_LL {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = headA.next.next;

        ListNode ans = getIntersectionNode(headA, headB);

        System.out.println(ans.val);
    }

    // lengthy code.
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode temp_1 = headA;
        ListNode temp_2 = headB;
        int size_A = 0;
        int size_B = 0;

        while (temp_1 != null) {
            size_A++;
            temp_1 = temp_1.next;
        }

        while (temp_2 != null) {
            size_B++;
            temp_2 = temp_2.next;
        }

        temp_1 = headA;
        temp_2 = headB;

        int diff = Math.abs(size_A - size_B);

        if (size_A > size_B) {
            while (diff-- > 0) {
                temp_1 = temp_1.next;
            }
        }

        else {
            while (diff-- > 0) {
                temp_2 = temp_2.next;
            }
        }

        while (temp_1 != temp_2) {
            temp_1 = temp_1.next;
            temp_2 = temp_2.next;

            if (temp_1 == null || temp_2 == null) {
                return null;
            }
        }

        return temp_1;
    }

    // simple code but the complexity remains the same.
    public static ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {

        ListNode temp_1 = headA;
        ListNode temp_2 = headB;

        while (temp_1 != temp_2) {
            temp_1 = temp_1 != null ? temp_1.next : headB;
            temp_2 = temp_2 != null ? temp_2.next : headA;
        }

        return temp_1;
    }

}
