//https://leetcode.com/problems/intersection-of-two-linked-lists/description/

import java.util.HashSet;

public class Intersection_of_Two_Linked_Lists {
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

        System.out.println(getIntersectionNode(headA, headB).val);
        System.out.println(getIntersectionNode_2(headA, headB).val);
        System.out.println(getIntersectionNode_3(headA, headB).val);
    }

    // using extra memory.
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }

            temp = temp.next;
        }

        return null;
    }

    // just find the length of the two LL and iterate the temp node to difference
    // of the two lengths.
    public static ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode temp1 = headA, temp2 = headB;

        while (temp1 != null) {
            lenA++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            lenB++;
            temp2 = temp2.next;
        }

        int diff = Math.abs(lenA - lenB);
        temp1 = headA;
        temp2 = headB;

        if (lenA > lenB) {
            while (diff > 0) {
                temp1 = temp1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                temp2 = temp2.next;
                diff--;
            }
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == null || temp2 == null) {
                return null;
            }
        }

        return temp1;
    }

    public static ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA.next != null ? tempA.next : headB;
            tempB = tempB.next != null ? tempB.next : headA;
        }

        return tempA;
    }
}
