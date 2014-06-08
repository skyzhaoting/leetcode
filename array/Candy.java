package leetcode;

public class Candy
{
	/**
	 * 两遍扫描 第一遍从左到右 每个孩子跟左边的孩子比最少的糖果数
	 * 第二遍从右到左 和右边的孩子比 结果加两个之中最大的数
	 */
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0)
            return 0;
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        for(int i = 1; i < ratings.length;i++)
        {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
            else
                candies[i] = 1;
        }
        int res = candies[ratings.length-1];
        for(int i = ratings.length-2;i>=0;i--)
        {
            int cur = 1;
            if(ratings[i] > ratings[i+1])
            {
                cur = candies[i+1]+1;
            }
            res += Math.max(cur,candies[i]);
            candies[i] = cur;
        }
        return res;
        
    }
}
