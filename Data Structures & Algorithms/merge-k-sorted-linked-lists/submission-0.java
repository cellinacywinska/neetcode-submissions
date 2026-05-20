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
        List<Integer> nodes = new ArrayList<>();

        for (ListNode l : lists){
            while (l!=null){
                nodes.add(l.val);
                l=l.next;
            }
        }

        Collections.sort(nodes);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int n : nodes){
            ListNode newNode = new ListNode(n);
            curr.next=newNode;
            curr=curr.next;
        }

        return dummy.next;
    }
}
