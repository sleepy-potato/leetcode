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
    public ListNode middleNode(ListNode head) {
        int numNodes = getNumNodes(head);
        return stepForward(head, numNodes / 2);
    }
    
    private int getNumNodes(ListNode head) {
        int result = 0;
        while (head != null) {
            head = head.next;
            result++;
        }
        return result;
    }
    
    private ListNode stepForward(ListNode head, int numSteps) {
        for (int i = 0; i < numSteps; i++) {
            head = head.next;
        }
        return head;
    }
}
