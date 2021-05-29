//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 哈希表 数学 
// 👍 171 👎 0


package leetcode.editor.cn;

//错误的集合

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P645_SetMismatch{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P645_SetMismatch().new Solution();
	 	 solution.findErrorNums(new int[]{1,2,2,4});
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
		Set<Integer> set=new HashSet<>();
		int repeat=0;
		int repeatTotal=0;
		int total=0;
		int origin=0;
       for (int i=0;i<nums.length;i++){
            if (!set.contains(nums[i])){
            	 set.add(nums[i]);
            	 repeatTotal=repeatTotal+nums[i];
			}else {
            	repeat=nums[i];
			}
	   }
       origin= nums.length * (nums.length+ 1) / 2-repeatTotal;

       return new int[]{repeat,origin};
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}