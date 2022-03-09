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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;
        while(head != null)
        {
            if(head.next != null && head.val == head.next.val)
            {
                while(head.next != null && head.val == head.next.val)
                {
                    head = head.next;
                }
                curr.next = head.next;
            }
            else
            {
                curr = curr.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}