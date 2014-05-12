package leetcode;

public class ScrambleString
{
	/**
	 * 三维动态规划题目 维护一个res[k][i][j]表示s2从j开始长度为k的子串是否可以由s1从i开始长度为k的子串转换而成
	 * 
     * 初始条件：res[1][i][j] = (s1[i] == s2[j] ? true : false)
     * res[k][i][j] = ( res[c][i][j] && res[k-c][i+c][j+c] )  ||  
     * ( res[c][i][j+k-c] && res[k-c][i+c][j] ) 
     * (c = 1,2,3...k-1, 它表示子串分割点到子串起始端的距离) ，只要一个子问题返回真，就可以停止计算
	 *
	 */
	public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length())
            return false;
        if(len == 0)
            return false;
        boolean[][][] res = new boolean[len+1][len][len];
        for(int i = 0; i < len; i++)
            for(int j = 0; j < len; j++)
            {
                res[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        for(int k = 2; k <= len; k++)
        {
            for(int i = 0; i <= len-k; i++)
            {
                for(int j = 0; j <= len-k; j++)
                {
                    res[k][i][j] = false;
                    for(int c = 1; c < k && !res[k][i][j];c++)
                    {
                        res[k][i][j] = (res[c][i][j]&&res[k-c][i+c][j+c] || res[c][i][j+k-c]&&res[k-c][i+c][j]);
                    }
                }
            }
        }
        return res[len][0][0];
    }
}
