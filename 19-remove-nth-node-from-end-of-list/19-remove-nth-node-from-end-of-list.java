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
    //Time O(N)
    //Space O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy , fast = head;
        
        //Move the fast pointer to the right positon
        while(n > 0)
        {
            fast = fast.next;
            n--;
        }
        
        //Now move both fast and slow for which slow reaches the right position
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}