package leetcode;

public class LengthofLastWord
{
	/**
	 * 去掉结尾的空格就可以
	 */
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int len = 0;
        s = s.trim();
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i) != ' ')
                len++;
            else break;
        }
        return len;
    }
			
}
