package leetcode;

public class ImplementstrStr
{
	/**
	 * 暴力方法 字符串匹配 
	 */
    public String strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() == 0)
            return haystack;
        if(needle.length() > haystack.length())
            return null;
        for(int i = 0 ; i <= haystack.length() - needle.length(); i++)
        {
            boolean flag = true;
            for(int j = 0; j < needle.length(); j++)
            {
                if(haystack.charAt(i+j) != needle.charAt(j))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
