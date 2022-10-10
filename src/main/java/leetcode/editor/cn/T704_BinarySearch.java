//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 1009 👎 0


package leetcode.editor.cn;
//Java：二分查找
public class T704_BinarySearch{
    public static void main(String[] args) {
        Solution solution = new T704_BinarySearch().new Solution();
        // TO TEST

        int search = solution.search(new int[]{1, 4, 7, 9, 10, 23, 33, 44, 45, 46, 80},2333);

        System.out.println(search);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return -1;
        }
        int length= nums.length;
        int middle=length/2;
        
        int min=0;
        int max=length-1;
        
        while (nums[min]<max){  
            if (target>nums[middle]){
                min=middle;
                middle=(min+max)/2;
            }else if (target<nums[middle]){
                max=middle;
                middle=(min+max)/2;
            }else {
                return middle;
            }
        }
        return -1;
    }
    
 
    
   
    
}
//leetcode submit region end(Prohibit modification and deletion)

}
