package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode target = findNthFromEnd(dummy, n+1);
            target.next = target.next.next;
            return dummy.next;
        }

        private ListNode findNthFromEnd(ListNode head, int n) {
            ListNode p1 = head;
            ListNode p2 = head;

            for (int i = 0; i < n; i++) {
                p1 = p1.next;
            }
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }

            return p2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here
        
    }
}