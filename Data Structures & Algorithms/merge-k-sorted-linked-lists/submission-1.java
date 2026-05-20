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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val-b.val);

        for (ListNode node : lists){
            if (node!=null){
                minHeap.add(node);
            }
        }

        while (!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();

            curr.next = smallest;
            curr = curr.next;

            if (smallest.next!=null){
                minHeap.add(smallest.next);
            }
        }

        return head.next;
    }
}
