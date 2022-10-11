//给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 
//
// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学 字符串 👍 85 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//Java：计算器
public class T面试题_1626_CalculatorLcci {
    public static void main(String[] args) {
        Solution solution = new T面试题_1626_CalculatorLcci().new Solution();

        System.out.println(solution.calculate("(1+(4+51+2)-3)+(6+8)"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * /*
         * 双栈：
         * 数字栈numStack存储计算过程中的数字结果
         * 操作栈opStack存储的除了数字的其他字符，包括'+'，'-'，'('等
         * 预处理:去除空格、开头若为'-'则加一个0进去numStack、"(-"变为"(0-"
         * 1.遇到数字 直接统计完整数字放入numStack
         * 2.遇到'(' 直接入opStack等待匹配')'
         * 3.遇到')' 计算出栈中所有与'('之间的运算结果并放入numStack
         * 4.遇到'+'or'-' 先将前面能计算的先计算以防止倒回来计算有减号会出错，然后入opStack
         */
        // 预处理(记住要接回来)
        public int calculate(String s) {

            s = s.replaceAll(" ", "");
            s = s.replaceAll("\\(-", "(0-");
            Deque<Integer> numStack = new LinkedList<>();
            Deque<Character> opStack = new LinkedList<>();
            if (s.charAt(0) == '-') numStack.addFirst(0);
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    // 1.遇到数字
                    int j = i, num = 0;
                    while (j < n && Character.isDigit(s.charAt(j))) {
                        num = num * 10 + (s.charAt(j) - '0');
                        j++;
                    }
                    numStack.addFirst(num);
                    i = j - 1;  // i跳到最后一位数字处(因为最后还会增加1)
                } else if (c == '(') {
                    // 2.遇到'('
                    opStack.addFirst('(');
                } else if (c == ')') {
                    // 3.遇到')'
                    while (!opStack.isEmpty() && opStack.peekFirst() != '(') calc(numStack, opStack);
                    if (!opStack.isEmpty()) opStack.pollFirst();    // 记住将'('也出栈
                } else {
                    // 4.遇到'+'or'-'
                    while (!opStack.isEmpty() && opStack.peekFirst() != '(') calc(numStack, opStack);   // 前面能计算的计算
                    opStack.addFirst(c);    // '+'or'-'入栈
                }
            }
            // 最后再进行一次最外层数字的计算，表示没有括号包住的数字
            while (!opStack.isEmpty()) calc(numStack, opStack);
            return numStack.peekFirst();    // 最后numStack只剩下一个数字直接返回
        }

        // 根据numStack与opStack进行一次计算
        void calc(Deque<Integer> numStack, Deque<Character> opStack) {
            if (opStack.isEmpty() || numStack.size() < 2) return;
            int b = numStack.pollFirst(), a = numStack.pollFirst();
            int ans = opStack.pollFirst() == '+' ? a + b : a - b;
            numStack.addFirst(ans);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
