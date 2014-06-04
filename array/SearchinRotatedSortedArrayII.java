package leetcode;

public class SearchinRotatedSortedArrayII
{
	/**
	 * 一个旋转数组，已经旋转过很多次，找出其中的某个元素
	 * 二分查找的变种，如果中间的数比左边缘大 左边一定有序 判断数字是否在左边 右边同样
	 * 考虑有重复数字 如果没有重复数字复杂度是logn 有重复数字是n
	 */
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0)
           return false;
       int l = 0;
       int r = A.length-1;
       while(l<=r)
       {
           int mid = (l + r)/2;
           if(A[mid] == target)
               return true;
           if(A[mid] > A[l])
           {
               if(target < A[mid] && target >= A[l])
                   r = mid - 1;
               else
                   l = mid + 1;
           }
           else if(A[mid] < A[l])
           {
               if(target<=A[r] && target>A[mid])  
                   l = mid + 1;  
               else  
                   r = mid - 1; 
           }
           else
               l++;
       }
       return false;
   }
}
