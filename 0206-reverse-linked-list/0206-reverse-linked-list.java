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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev= null;
        ListNode curr = head;
        
        while(curr.next!= null){
           ListNode ocn = curr;
           curr = curr.next;
           ocn.next= prev;
           prev = ocn;
        }
        curr.next= prev;
        return curr;
    }
}