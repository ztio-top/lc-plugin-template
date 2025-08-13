package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MinimumWindowSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();

            for(char c : t.toCharArray()){
                need.put(c, need.getOrDefault(c, 0) +1);
            }

            int left =0, right = 0;
            int valid = 0;
            int start = 0, length = Integer.MAX_VALUE;
            while(right < s.length()){
                char c = s.charAt(right);
                right++;
                if(need.containsKey(c)){
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if(window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }

                while(valid == need.size()){
                    if(right - left < length){
                        start = left;
                        length = right - left;
                    }
                    char h = s.charAt(left);
                    left++;
                    if(need.containsKey(h)){
                        window.put(h, window.get(h) - 1);
                        if(need.get(h).equals(window.get(h) + 1)){
                            valid--;
                        }
                    }
                }

            }

            return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
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