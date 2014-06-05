package leetcode;

public class TrappingRainWater
{
	/**
	 * 扫描两遍
	 * 第一遍从左往右 用数组记录 到当前的高度左边最大的高度（包含自身）
	 * 第二遍从右往左 用数组记录 到当前的高度右边最大的高度（包含自身）
	 * min(左边最大的高度，右边最大的高度)-当前高度 就是储水量
	 */
    public int trap(int[] A) {
        if(A == null || A.length <= 2)
            return 0;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = A[0];
        for(int i = 1; i < A.length; i++)
        {
            left[i] = Math.max(left[i-1],A[i]);
        }
        right[A.length-1] = A[A.length-1];
        for(int i = A.length-2; i >= 0; i--)
        {
            right[i] = Math.max(right[i+1],A[i]);
        }
        int res = 0;
        for(int i = 1; i < A.length-1; i++)
        {
            res += (Math.min(left[i],right[i]) - A[i]);
        }
        return res;
    }
}
