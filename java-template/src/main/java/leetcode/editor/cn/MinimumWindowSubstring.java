package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> window = new HashMap<>();
            Map<Character, Integer> need = new HashMap<>();
            for(char c : t.toCharArray()){
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0, right = 0;
            int valid = 0;
            int start = 0, len = Integer.MAX_VALUE;
            while(right < s.length()){
                char c = s.charAt(right);
                if(need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    //Integer对象比较一定要用equals而不是==
                    if(window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }
                right++;
//            System.out.print("left:%d, right:%d\n", left, right);
                while((valid == need.size()) && (left < right)){
                    char c1 = s.charAt(left);
                    if(need.containsKey(c1)){
                        if (window.get(c1).equals(need.get(c1))) {
                            int l = right - left;
                            if (l < len) {
                                start = left;
                                len = l;
                            }
                            valid--;
                        }
                        window.put(c1, window.get(c1) -1);
                    }
                    left++;
                }
            }
            if(len == Integer.MAX_VALUE){
                return "";
            }

            return s.substring(start, start + len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        // put your test code here
        String s = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);

    }
}