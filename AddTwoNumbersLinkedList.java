//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {   
        int carry = 0;
        ListNode prev = null;
        ListNode head = null;
        
        while((l1 != null) && (l2 != null)) {
            int sum = l1.val + l2.val + carry;
            ListNode l3 = new ListNode(sum%10, null);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;  
            
            if(prev != null){
                prev.next = l3;
            } else {
                head = l3;
            }                
            
            prev = l3;
        }
        
        ListNode l = null;        
        if(l1 != null) {
            l = l1;
        } else if (l2 != null) {
            l = l2;
        }  
        
        while(l != null){
            int sum = l.val + carry;
            ListNode l3 = new ListNode(sum%10, null);
            carry = sum/10;
            l = l.next;
            
            prev.next = l3;
            prev = l3; 
        }
        
        if(carry != 0){
            ListNode l3 = new ListNode(carry, null);   
            prev.next = l3;
        } 
        
        return head;
    }
}

