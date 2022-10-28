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
        int n = lists.length;
        
        if(n == 0)
            return null;
        
        return mergeKListsHelper(lists, 0, n - 1);     
    }
    
    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        if(start >= end)
            return lists[start];
        
        int mid = start + (end - start)/2 ;
        
        ListNode one = mergeKListsHelper(lists, start, mid);
        ListNode two = mergeKListsHelper(lists, mid + 1, end);
        
        ListNode mergedNode = merge(one, two);
        
        return mergedNode;
    }
    
    public ListNode merge(ListNode list1, ListNode list2){
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode dummy = new ListNode();
        ListNode pointer = dummy;
       
        while(temp1 != null && temp2 != null){
           if(temp1.val < temp2.val){
               dummy.next = temp1;
               temp1 = temp1.next;
           }
            else{
                dummy.next = temp2;
                temp2 = temp2.next;
            }
            dummy = dummy.next;
           
        }
        if(temp1 != null){
            dummy.next = temp1;
        }
        if(temp2 != null){
            dummy.next = temp2;
        }
        return pointer.next;
    }
}