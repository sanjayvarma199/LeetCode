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
        ListNode curr = head , prev = null;
        boolean duplicate = false;
        while(curr != null)
        {
            while(curr != null && prev != null &&  prev.val == curr.val)
            {
                duplicate = true;
                curr = curr.next;
            }
            if(duplicate)
            {
                prev.next = curr;
                duplicate = false;
            }
            prev = curr;
            if(curr != null) curr = curr.next;
        }
        return head;
    }
}