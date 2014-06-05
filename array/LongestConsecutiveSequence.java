package leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence
{
	/**
	 * 无序数组的最长连续序列
	 * 最简单的想法就是先排序 然后一次扫猫 与当前最长的字符串比较 注意重复数字
	 * O(n)的做法是先将数字都存到哈希表中 然后遍历数组 再在哈希表中找当前数字两端的连续数字 找到后删除
	 * 然后比较当前串的长度是不是最长
	 */
	public int longestConsecutive(int[] num)
	{
		if (num == null || num.length == 0)
			return 0;
		int max = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int number : num)
		{
			set.add(number);
		}
		for (int number : num)
		{
			if (set.contains(number))
			{
				int cur = number + 1;
				int count = 1;
				while (set.contains(cur))
				{
					set.remove(cur);
					cur++;
					count++;
				}
				cur = number - 1;
				while (set.contains(cur))
				{
					set.remove(cur);
					cur--;
					count++;
				}
				if (count > max)
					max = count;
			}
		}
		return max;
	}
}
