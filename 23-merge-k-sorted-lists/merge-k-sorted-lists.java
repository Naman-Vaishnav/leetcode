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
        //N->size in each list
        //N*K*K (N+2*N+3*N+...+K*N)
        // ListNode ans=null;
        // for(ListNode cur:lists){
        //     ans=merge(ans,cur);
        // }
        // return ans;

        //N LogK
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));

        for(ListNode cur:lists)
            if(cur!=null)pq.add(cur);
        ListNode head=null,tail=null;
        while(pq.size()>0){

            ListNode min=pq.poll();
            if(head==null)head=min;
            if(tail!=null)tail.next=min;
            tail=min;

            if(min.next!=null)pq.add(min.next);

        }
        return head;

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