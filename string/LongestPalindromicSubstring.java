package leetcode;

public class LongestPalindromicSubstring
{
	/**
	 * 最长回文字串
	 * 三种方法 1.暴力法o(n3)
	 * 2寻找中心 中心的数量是2*n-1 每个中心往两边扫描 记录最长子串
	 * 3.动态规划 用dp[i][j]记录i到j的子串是不是回文子串 i从后面往前扫描，j从i扫描到结尾
	 */
	/*第2种方法*/
    public String longestPalindrome2(String s) {
        String res = "";
        if(s == null || s.length() == 0)
            return res;
        int maxLen = 0;
        for(int i = 0; i < 2*s.length()-1;i++)
        {
            int left = i/2;
            int right = i/2;
            if(i%2 == 1)
                right++;
            String str = palin(s,left,right);
            if(maxLen < str.length())
            {
                maxLen = str.length();
                res = str;
            }
        }
        return res;
    }
    public String palin(String s, int left, int right)
    {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    
    /*第3种方法*/
    public String longestPalindrome3(String s) {
        String res = "";
        if(s == null || s.length() == 0)
            return res;
        int maxLen = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i>=0 ; i--)
        {
            for(int j = i; j < s.length();j++)
            {
                if(s.charAt(i) == s.charAt(j) && (j-i <=2 || dp[i+1][j-1]))
                {
                    dp[i][j] = true;
                    if(maxLen < j-i+1)
                    {
                        maxLen = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
}
