package leetcode;

public class RemoveElement
{
	/**
	 * 扫描一遍 o（n） 双指针
	 */
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0)
            return 0;
        int i = 0;
        for(int j = 0; j < A.length; j++)
        {
            if(A[j] != elem)
            {
                A[i++] = A[j];
            }
        }
        return i;
    }
}
