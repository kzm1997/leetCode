//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 1299 👎 0


package leetcode.editor.cn;

//零钱兑换

import java.util.Arrays;

public class P322_CoinChange {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P322_CoinChange().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)  动态规划
    class Solution {
        int[] memory;

        public int coinChange(int[] coins, int amount) {
            memory = new int[amount + 1];
            Arrays.fill(memory, -666);

            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            if (memory[amount] != -666) {
                return memory[amount];
            }

            int res = Integer.MAX_VALUE;

            for (int coin : coins) {
                //计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                if (subProblem == -1) continue;
                res = Math.min(res, subProblem + 1);
            }
            res = res == Integer.MAX_VALUE ? -1 : res;
            coins[amount]=res;
            return res;

        }

        /**
         * 暴力穷举
         *
         * @param coins
         * @param amount
         * @return
         */
        public int coinChange2(int[] coins, int amount) {
            if (amount == 0) return 0;
            if (amount < 0) return -1;


            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                //计算子问题的结果
                int subProblem = coinChange(coins, amount - coin);
                //子问题无解则跳过
                if (subProblem == -1) continue;
                //在子问题中选择最优解,然后加1
                res = Math.min(res, subProblem + 1);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}