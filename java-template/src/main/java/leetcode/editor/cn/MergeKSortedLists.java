package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    //leetcode submit region begin(Prohibit modification and deletion)
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
            ListNode dummy = new ListNode(0), p = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
            for (ListNode node : lists) {
                if (node != null) {
                    pq.offer(node);
                }
            }
            while(!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                p = p.next;
                if(node.next != null) {
                    pq.offer(node.next);
                }
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        
    }
}