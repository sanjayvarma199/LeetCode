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
    //Time O(M+N)
    //Space O(M+N)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
        {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode l1 = list1 , l2 = list2 , ans = head;
        
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                head.next = new ListNode(l2.val);
                l2  = l2.next;
            }
            
            head = head.next;
        }
        if(l1 != null) head.next = l1;
        if(l2 != null) head.next = l2;
        
        return ans.next;
    }
}