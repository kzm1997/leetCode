//给定一个整数数组，判断是否存在重复元素。
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//
//
// 示例 1:
//
//
//输入: [1,2,3,1]
//输出: true
//
// 示例 2:
//
//
//输入: [1,2,3,4]
//输出: false
//
// 示例 3:
//
//
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
// Related Topics 数组 哈希表 排序
// 👍 501 👎 0


package leetcode.editor.cn;

//存在重复元素

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P217_ContainsDuplicate{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P217_ContainsDuplicate().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsDuplicate(int[] nums) {

    	if (nums.length==0){
    		return false;
		}

		Set set=new HashSet();
		for (int num : nums) {
			if (set.contains(num)){
				return true;
			}else{
				set.add(num);
			}
		}

		return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
