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
    public int getDecimalValue(ListNode head) {
        int ans=0;
        while(head!=null){
            if(head.val==1)ans++;
            if(head.next!=null)ans<<=1;
            System.out.println(ans);
            head=head.next;
        }
        return ans;
    }
}