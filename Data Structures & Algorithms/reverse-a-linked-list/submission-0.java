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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        ListNode temp = head.next;
        ListNode prev = null;

        current.next = prev;
        
        while(temp != null){
            prev = current;
            current = temp;
            temp = temp.next;
            current.next = prev;
        }
            
        return current;

    }
}
