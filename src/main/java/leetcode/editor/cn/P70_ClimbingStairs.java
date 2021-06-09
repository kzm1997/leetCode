//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1684 👎 0


package leetcode.editor.cn;

//爬楼梯

public class P70_ClimbingStairs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P70_ClimbingStairs().new Solution();

        System.out.println(solution.CountNumber(10, 0));
        System.out.println(solution.climbStairs(10));
        System.out.println(solution.climbStairs(10) - solution.climbStairs3(10));
    }
//力扣代码  f(x)=f(x-1)+f(x-2)  base: f(0)=0 f(1)=1  f(2)=2
//

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            int pd[] = new int[n + 1];
            pd[1] = 1;
            pd[2] = 2;
            for (int j = 3; j <= n; j++) {
                pd[j] = pd[j - 1] + pd[j - 2];
            }
            return pd[n];
        }


        public int climbStairs2(int n) {
            int p = 0, q = 0, r = 1;
            for (int i = 1; i <= n; ++i) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }

        public int climbStairs3(int n) {
            int pd[] = new int[n + 1];
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }
            if (n == 3) {
                return 3;
            }
            pd[1] = 1;
            pd[2] = 2;
            pd[3] = 5;
            pd[4] = 6;
            for (int j = 5; j <= n; j++) {
                pd[j] = pd[j - 1] + pd[j - 4];
            }
            return pd[n];
        }


        long CountNumber(int n, int status) {
            if (n < 1) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                //上一步是走的两步， 则只能全走一步
                if (status == 2) {
                    return 1;
                }
                //上一步是走的1步， 则可以全走一步，或者直接走两步
                if (status == 1) {
                    return 2;
                }
            }

            if (n > 2) {
                if (status == 0) {
                    return CountNumber(n - 1, 1) + CountNumber(n - 2, 2);
                }
                if (status == 1) {
                    return CountNumber(n - 1, 1) + CountNumber(n - 2, 2);
                }
                if (status == 2) {
                    return CountNumber(n - 1, 1);
                }
            }
            return 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}