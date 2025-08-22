package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
//            while(fast.next != null && fast.next.next != null){  // 两个中点 前边那个
            while(fast != null && fast.next != null){   //两个中点 后边那个
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        
    }
}