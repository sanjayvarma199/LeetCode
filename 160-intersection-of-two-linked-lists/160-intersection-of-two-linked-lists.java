/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Time O(M+N)
    //Space O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA < lenB)
        {
            return getIntersectionNode(headB , headA);
        }
        
        int diff = lenA - lenB;
        while(diff > 0)
        {
            headA = headA.next;
            diff--;
        }
        
        while(headA != null && headB != null && headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return (headA == headB) ? headA : null;
    }
    private int getLength(ListNode head)
    {
        int len = 0;
        while(head != null)
        {
            len++;
            head = head.next;
        }
        return len;
    }
}