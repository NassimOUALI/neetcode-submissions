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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode offset = head;
        for(int i = 0; i<n; i++){
            offset = offset.next;
        }

        ListNode delete = head;
        ListNode prev = null;

        while(offset != null){
            offset = offset.next;
            prev = delete;
            delete = delete.next;
        }
        if (head == delete){
            return delete.next;
        }

        prev.next = delete.next;

        return head;

    }
}
