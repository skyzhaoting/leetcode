package leetcode;

public class ClimbingStairs
{
	/**
	 * 爬楼梯问题 递归和动态规划 使用动态规划 
	 * 节省空间的做法
	 */
	public int climbingStairs(int n)
	{
		int[] step = {1,1,2};
		for (int i = 3; i <= n; i++)
		{
			step[i%3] = step[(i-1)%3] + step[(i-2)%3];
		}
		return step[n%3];
	}
}
