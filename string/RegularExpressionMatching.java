package leetcode;

public class RegularExpressionMatching
{
	/**Implement regular expression matching with support for '.' and '*'.
	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
	*/
	
	/**
	 * 两种方法
	 * 第一种：brute force 假设s走到i位置 p走到j位置 递归
	 * 1.如果p[j+1] ！= ‘*’ 判断s[i]和p[j]是否相等（'.'也可以）如果不同返回false，相同递归到下一层i+1,j+1
	 * 2. 如果p[j+1] == ‘*’ 如果s[i]和p[j]相等	 递归判断（i,j+2）,(i+1,j+2),(i+2,j+2) j+2跳过当前字符和*
	 */
	//第一种方法
    public static boolean isMatch1(String s, String p) {
        return helper(s,p,0,0);
    }
    public static boolean helper(String s, String p, int i, int j)
    {
        if(j == p.length())
            return i == s.length();
        if(j == p.length()-1 || p.charAt(j+1) != '*')
        {
            if(i == s.length() || p.charAt(j) != s.charAt(i) && p.charAt(j) != '.')
                return false;
            else
                return helper(s,p,i+1,j+1);
        }
        while(i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'))
        {
            if(helper(s,p,i,j+2))
                return true;
            i++;
        }
        return helper(s,p,i,j+2);
    }
    
	/** 第二种：动态规划
	* 维护一个布尔数组res[i][j],代表s的前i个字符和p的前j个字符是否匹配(注意这里res的维度是s.length()+1,p.length()+1)
	* 1.p[j+1]不是'*'。只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'.',也是相同），并且res[i][j]==true，则res[i+1][j+1]也为true，res[i+1][j+1]=false; 
	* 2.p[j+1]是'*'，但是p[j]!='.'。那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true： 
    *   1)res[i+1][j]为真（'*'只取前面字符一次）; 
    *   2)res[i+1][j-1]为真（'*'前面字符一次都不取，也就是忽略这两个字符）; 
    *   3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](这种情况是相当于i从0到s.length()扫过来，如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）。 
    * 3.p[j+1]是'*'，并且p[j]=='.'。因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]中只要有i+1是true，那么剩下的res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]就都是true了。 	
	 */
    
    //第二种方法
	public static boolean isMatch2(String s, String p) {
	    if(s.length()==0 && p.length()==0)
	        return true;
	    if(p.length()==0)
	        return false;
	    boolean[][] res = new boolean[s.length()+1][p.length()+1];
	    res[0][0] = true;
	    for(int j=0;j<p.length();j++)
	    {
	        if(p.charAt(j)=='*')
	        {
	            if(j>0 && res[0][j-1]) res[0][j+1]=true;
	            if(j<1) continue;
	            if(p.charAt(j-1)!='.')
	            {
	                for(int i=0;i<s.length();i++)
	                {
	                    if(res[i+1][j] || j>0&&res[i+1][j-1] 
	                    || i>0 && j>0 && res[i][j+1]&&s.charAt(i)==s.charAt(i-1)&&s.charAt(i-1)==p.charAt(j-1))
	                        res[i+1][j+1] = true;
	                }
	            }
	            else
	            {
	                int i=0;
	                while(j>0 && i<s.length() && !res[i+1][j-1] && !res[i+1][j])
	                    i++;
	                for(;i<s.length();i++)
	                {
	                    res[i+1][j+1] = true;
	                }
	            }
	        }
	        else
	        {
	            for(int i=0;i<s.length();i++)
	            {
	                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
	                    res[i+1][j+1] = res[i][j];
	            }
	        }
	    }
	    return res[s.length()][p.length()];
	}
	
	
}
