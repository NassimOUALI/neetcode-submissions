/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node curr = head;

        if(curr == null){
            return null;
        }

        Node cpy = new Node(head.val);
        Node cpy_curr = cpy;

        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, cpy);

        while(curr.next != null){
            Node tmp = new Node(curr.next.val);
            map.put(curr.next, tmp);
            curr = curr.next;
            cpy_curr.next = tmp;
            cpy_curr = cpy_curr.next;
        }

        curr = head;
        cpy_curr = cpy;

        while(cpy_curr!= null && curr != null){

            if (curr.random == null){
                cpy_curr.random = null;
            }else{
                cpy_curr.random = map.get(curr.random);
            }

            cpy_curr = cpy_curr.next;
            curr = curr.next;    

        }

        return cpy;

    }
}
