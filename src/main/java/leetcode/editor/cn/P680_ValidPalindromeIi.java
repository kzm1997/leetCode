//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 357 👎 0


package leetcode.editor.cn;

//验证回文字符串 Ⅱ

public class P680_ValidPalindromeIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P680_ValidPalindromeIi().new Solution();
        boolean abc = solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga");
        System.out.println(abc);
    }

    //力扣代码 ""
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            boolean flag = true;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                  if (validPalindrome(s,i+1,j)||validPalindrome(s,i,j-1)){
                      return true;
                  }else {
                      return false;
                  }
                }
            }
            if (i>=j){
                return true;
            }
            return false;
        }


        public boolean validPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}