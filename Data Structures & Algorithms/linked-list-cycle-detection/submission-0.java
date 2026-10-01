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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head.next == null) return false;
        ListNode curr = head;
        ListNode tmp = head.next.next;
        while(tmp!=null){
            if (tmp == curr)
                return true;
            
            if (tmp.next == null){
                break;
            }
            tmp = tmp.next.next;
            curr = curr.next;
        }
        return false;
    }
}
