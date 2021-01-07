//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 308 👎 0

package leetcode.editor.cn;

import javafx.beans.binding.When;

//java:验证回文串
public class P125ValidPalindrome{
    public static void main(String[] args){
        Solution solution = new P125ValidPalindrome().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();

        int left = 0;
        int right = lowerCase.length() - 1;
        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(lowerCase.charAt(left))) {
                left++;
            }


            while (left < right && !Character.isLetterOrDigit(lowerCase.charAt(right))) {
                right--;
            }


            if (lowerCase.charAt(left) != lowerCase.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}