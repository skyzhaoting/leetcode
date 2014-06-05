package leetcode;

import java.util.Arrays;

public class NextPermutation
{
	/**
	 * 第一遍 从右往左找到非递增序列的第一个数 例如 3 4 8 5 2 2中 分割数4
	 * 第二遍 从右往左找到第一个比分割数大的数 5
	 * 第三遍 交换两个数 从分割数到最后做逆序操作
	 */
	public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1)
            return;
        int i = num.length-2;
        while(i >= 0 && num[i] >= num[i+1])
            i--;
        if(i>=0)
        {
            int j = num.length-1;
            while(j >= 0 && num[j] <= num[i])
                j--;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        Arrays.sort(num,i+1,num.length);
    }
}
