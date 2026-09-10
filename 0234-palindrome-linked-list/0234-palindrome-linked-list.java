/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode copyHead = new ListNode(head.val);
        ListNode copyTemp = copyHead;
        ListNode temp = head.next;

        while (temp != null) {
            copyTemp.next = new ListNode(temp.val);
            copyTemp = copyTemp.next;
            temp = temp.next;
        }

        ListNode rev_head = reverseList(copyHead);
        temp = head;
        ListNode rev_temp = rev_head;
        while (temp != null) {

            if (temp.val == rev_temp.val) {
                temp = temp.next;
                rev_temp = rev_temp.next;
            } else {
                return false;
            }

        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode ocn = curr;
            curr = curr.next;
            ocn.next = prev;
            prev = ocn;
        }
        curr.next = prev;
        return curr;
    }
}