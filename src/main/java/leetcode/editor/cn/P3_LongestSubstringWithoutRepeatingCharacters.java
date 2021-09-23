//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 6151 👎 0


package leetcode.editor.cn;

//无重复字符的最长子串

import java.util.*;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();

        int i = solution.lengthOfLongestSubstring("dvdf");

        System.out.println(i);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            int n = s.length();

            if (n == 0) {
                return 0;
            }

            if (n == 1) {
                return 1;
            }

            int start = 0;
            int end = 0;

            int max=1;

            LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

            while (end < n) {



                while (end<n&&!map.containsKey(s.charAt(end))) {
                    map.put(s.charAt(end), end);
                    end++;
                }

                max=Math.max(map.keySet().size(),max);


                if (end>=n){
                    return max;
                }

                start = map.get(s.charAt(end)) == null ? 0 : map.get(s.charAt(end));

                //移除在重复元素以前的
                Iterator<Character> iterator = map.keySet().iterator();

                while (iterator.hasNext()){
                    Character next = iterator.next();
                    if (map.get(next)<=start){
                        iterator.remove();
                    }
                }

                start++;


            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
