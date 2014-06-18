package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams
{
	/**
	 * 异构词 两种方法 一种哈希表记录 一种排序
	 * 这道题用HASHMAP key是排序后的字符串 value是这个字符串在数组中的索引
	 */
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if(strs == null || strs.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < strs.length; i++)
        {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String str = new String(charArray);
            if(map.containsKey(str))
            {
                if(map.get(str) >= 0)
                {
                    res.add(strs[map.get(str)]);
                    map.put(str,-1);/*碰到异构词 把第一个词加进来后 把索引置-1 以免重复添加*/
                }
                res.add(strs[i]);
            }
            else
            {
                map.put(str,i);
            }
        }
        return res;
    }
}
