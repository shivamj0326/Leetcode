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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        
       
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        
        ListNode min = null;
        ListNode temp = stack.peek();
        
        while(!stack.isEmpty()){
            if(min == null){
                min = stack.pop();
                continue;
            }
            else{
                ListNode c = stack.pop();
                if(c.val >= min.val){
                    c.next = min;
                    min = c;
                    temp = c;
                }
            }
        }
        
        return temp;
    }
}