package leetcode;

import java.util.LinkedList;

public class LongestValidParentheses
{
	/**
	 * 最长括号匹配 用栈实现 栈存储括号的位置信息
	 * 左括号入栈 右括号判断 
	 * 如果栈空 把起始位置后移 如果栈不空 弹栈 栈空 当前元素减去起始位置+1 栈不空 当前元素到弹栈的上一个位置
	 */
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                stack.push(i);
            else
            {
                if(stack.isEmpty())
                    start = i+1;
                else
                {
                    stack.pop();
                    max = stack.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());
                }
                    
            }
        }
        return max;
    }
}
