package leetcode;

import java.util.LinkedList;

public class LargestRectangleinHistogram
{
	/**
	 * 用栈 类似longest valid parentheses的方法
	 */
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < height.length; i++)
        {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()])
            {
                int index = stack.pop();
                int area = stack.isEmpty() ? i*height[index] :(i-stack.peek()-1) * height[index];
                max = Math.max(max,area);
            }
            stack.push(i);
        }
        /**最后要判断栈是否为空*/
        while(!stack.isEmpty())
        {
            int index = stack.pop();
            int area = stack.isEmpty() ? height.length*height[index] :(height.length-stack.peek()-1) * height[index];
            max = Math.max(max,area);
        }
        return max;
    }
}
