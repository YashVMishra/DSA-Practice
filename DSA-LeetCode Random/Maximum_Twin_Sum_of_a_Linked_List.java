//https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/

public class Maximum_Twin_Sum_of_a_Linked_List {
    public static void main(String[] args) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int[] head = { 1, 100000 };

        for (int i = 0; i < head.length; i++) {
            temp.next = new ListNode(head[i]);
            temp = temp.next;
        }

        System.out.println(pairSum(dummy.next));
        System.out.println(pairSum_2(dummy.next));
    }

    // uses extra space.
    public static int pairSum(ListNode head) {
        int len = 0;
        ListNode temp = head;

        // finding length.
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // creating a new array.
        int[] arr = new int[len];

        // filling the new array
        temp = head;
        int index = 0;
        while (temp != null) {
            arr[index] = temp.val;
            index++;
            temp = temp.next;
        }

        // calculating the maximum twin sum.
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= (len / 2) - 1; i++) {
            ans = Math.max(ans, arr[i] + arr[len - i - 1]);
        }

        return ans;
    }

    public static int pairSum_2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int maxVal = 0;

        // finding the mid of the LL.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing the LL from the slow Node.
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        // calculating the maximum twin sum.
        while (prev != null) {
            maxVal = Math.max(maxVal, head.val + prev.val);
            prev = prev.next;
            head = head.next;
        }

        return maxVal;
    }
}
