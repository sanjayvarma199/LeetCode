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
    //Time O(NlogN)
    //Space O(1)
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode mid = Middle(head);
        ListNode first = sortList(head);
        ListNode Second = sortList(mid);
        return Merge(first , Second);
    }
    
    private ListNode Merge(ListNode l1 , ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                curr.next = l1;
                l1 = l1.next;
            }
            else
            {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        else if(l2 != null) curr.next = l2;
        return dummy.next;
        
    }
    
    private ListNode Middle(ListNode head)
    {
        ListNode slow = head , fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }
}