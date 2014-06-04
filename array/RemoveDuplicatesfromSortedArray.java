package leetcode;

public class RemoveDuplicatesfromSortedArray
{
	/**
	 * 时间复杂度n 空间1
	 */
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int i = 1;
        for(int j = 1; j < A.length; j++)
        {
            if(A[j] != A[j-1])
            {
                A[i++] = A[j];
            }
        }
        return i;
    }
}
