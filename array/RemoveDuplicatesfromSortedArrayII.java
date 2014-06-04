package leetcode;

public class RemoveDuplicatesfromSortedArrayII
{
	/**
	 * 时间n 空间1 判断出现次数
	 */
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int i = 0, count = 0;
        for(int j = 0; j < A.length; j++)
        {
            if(j > 0 && A[j] == A[j-1])
            {
                count++;
                if(count>=3)
                    continue;
            }
            else
            {
                count = 1;
            }
            A[i++] = A[j];
        }
        return i;
    }
}
