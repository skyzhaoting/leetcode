package leetcode;

public class LongestCommonPrefix
{
	/**
	 * 最长公共前缀 
	 * 暴力法
	 */
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs == null || strs.length == 0)
            return res;
        int i,j = 0;
        while(true)
        {
            for(i = 0; i < strs.length; i++)
            {
                if(j >= strs[i].length() || strs[0].charAt(j) != strs[i].charAt(j))
                    break;
            }
            if(i < strs.length)
                break;
            res += strs[0].charAt(j);
            j++;
        }
        return res;
    }
}
