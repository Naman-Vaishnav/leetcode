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
        ListNode ans=null;
        for(ListNode cur:lists){
            ans=merge(ans,cur);
        }
        return ans;
    }

    ListNode merge(ListNode l1,ListNode l2){
        if(l1==null||l2==null)return (l1==null)?l2:l1;
        if(l1.val<l2.val){
             l1.next=merge(l1.next,l2);
             return l1;
        }
        else{
             l2.next=merge(l1,l2.next);
             return l2;
        }

    }

}