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
    //Time O(Nlogk)
    //Space O(K)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        
        PriorityQueue<ListNode> PQ = new PriorityQueue<>((a , b) -> (a.val - b.val));
        
        for(ListNode node : lists)
        {
            if(node == null) continue;
            PQ.add(node);
        }
        
        while(!PQ.isEmpty())
        {
            ListNode curr = PQ.poll();
            if(curr.next != null)
            {
                PQ.add(curr.next);
            }
            dummy.next = curr;
            dummy = dummy.next;
        }
        return result.next;
    }
}