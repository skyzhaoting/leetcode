package leetcode;

public class StringtoInteger
{
	/**
	 * 空格和符号 首先考虑
	 * 结束条件 
	 * 1遇到异常的字符截断 
	 * 2 整数越界的问题(返回最接近的整数) 
	 * 3 字符串结束
	 */
    public int atoi(String str) {
        if(str == null)
            return 0;
        str = str.trim();
        if(str.length() == 0)
            return 0;
        int i = 0;
        boolean isNeg = false;
        if(str.charAt(0) == '-' || str.charAt(0) == '+')
        {
            i++;
            if(str.charAt(0) == '-')
                isNeg = true;
        }
        int res = 0;
        while(i < str.length())
        {
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            int digit = (int)(str.charAt(i) - '0');
            if(isNeg && res > -((Integer.MIN_VALUE+digit)/10))
                return Integer.MIN_VALUE;
            else if(!isNeg && res > ((Integer.MAX_VALUE-digit)/10))
                return Integer.MAX_VALUE;
            res = res*10+digit;
            i++;
        }
        return isNeg?-res:res;
    }
}
