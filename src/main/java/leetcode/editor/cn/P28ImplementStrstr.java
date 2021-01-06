//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 660 👎 0

package leetcode.editor.cn;


//java:实现 strStr()
public class P28ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new P28ImplementStrstr().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            int l = needle.length(), n = haystack.length();
            for (int start = 0; start < n - l + 1; ++start) {
                if (haystack.substring(start, start + l).equals(needle)) {
                    return start;
                }
            }
            return -1;
        }

        /**
         * 双指针
         *
         * @param haystack
         * @param needle
         * @return
         */
        public int strStr2(String haystack, String needle) {
            int l = needle.length(), n = haystack.length();
            if (l == 0) {
                return 0;
            }

            int pn=0;
            while (pn<n-l+1){
                while (pn<n-l+1&&haystack.charAt(pn)!=needle.charAt(0)){
                    ++pn;
                }
                int currentLen=0;
                int pl=0;
                while (pl<l && pn<n && haystack.charAt(pn)==needle.charAt(pl)){
                    ++pn;
                    ++pl;
                    ++currentLen;
                }
                if (currentLen==l){
                    return pn-l;
                }
                pn=pn-currentLen+1;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}