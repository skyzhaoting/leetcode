package leetcode;

public class SingleNumberII
{
	/**
	 * 数组中只有一个数字出现了一次 
	 * 位操作 用一个大小32的数组统计每个数字 每一位出现的次数 出现3次的数字对3取余后是0 
	 */
    public int singleNumber(int[] A) {
        int[] digits = new int[32];
        for(int i = 0; i < 32; i++)
        {
            for(int j = 0; j < A.length; j++)
            {
                digits[i] += (A[j]>>i)&1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++)
        {
            res += (digits[i]%3)<<i;
        }
        return res;
    }
}
