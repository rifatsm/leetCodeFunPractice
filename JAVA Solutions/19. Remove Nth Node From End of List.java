19. Remove Nth Node From End of List.java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution: Two Pointers
// Runtime: 6 ms
// TC: O(n)
// SC: O(1)
/* Approach: Two Pointers
*   1. Create two pointers "first" and "second" and point to the head
*   2. Iterate the "first" pointer to "n" steps ahead of the "second"
*   3. If the "first" pointer is at the end, return the list from "head.next"
*   4. Otherwise, iterate both "first" and "second" until we find the end 
*   5. Delete the node by "second" pointer
*   6. Return the "head"
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode first = head;
        ListNode second = head;
        
        for(int i = 0; i < n; i++){
            if(first.next != null)
                first = first.next;
            else
                return head.next; // If the "n" th element from the end is the "head"
        }
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        
        return head;
    }
}