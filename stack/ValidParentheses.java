package leetcode;

import java.util.LinkedList;

public class ValidParentheses
{
	/**
	 * 栈的应用 括号匹配
	 */
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0 ; i < s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ')')
                if(stack.isEmpty() || stack.pop() != '(')
                    return false;
            if(s.charAt(i) == ']')
                if(stack.isEmpty() || stack.pop() != '[')
                    return false;
            if(s.charAt(i) == '}')
                if(stack.isEmpty() || stack.pop() != '{')
                    return false;
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
