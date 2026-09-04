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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode check = head.next;
        while (check != null) {
           while (check != null && check.val == curr.val){
                check = check.next;
            }
            if (check == null) {
                curr.next = null;
                return head;
            } else {
                curr.next = check;
                curr = check;
                check = check.next;
            }
        }
        return head;
    }
}