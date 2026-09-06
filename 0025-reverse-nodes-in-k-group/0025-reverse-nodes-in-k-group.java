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
    public ListNode kthNode(ListNode start, int k) {
        ListNode temp = start;
        for (int i = 1; i < k; i++) {
            if (temp == null) {
                return null;
            }
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverse(ListNode start) {
        ListNode prev = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
       
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode newHead = null;

      while(temp != null){
         
         ListNode kth = kthNode(temp, k);
        if(kth == null){
          break;
        } 
            ListNode nextNode = kth.next;

            kth.next = null;
            
            ListNode reverse = reverse(temp);

            if(newHead == null){
                newHead = reverse;
            }

            if(prevNode != null){
                prevNode.next = reverse;
            }
            prevNode = temp;
             prevNode.next = nextNode; 
           temp = nextNode;
        
      }
        return newHead;
    }
}