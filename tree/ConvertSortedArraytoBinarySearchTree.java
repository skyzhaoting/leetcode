package leetcode;

public class ConvertSortedArraytoBinarySearchTree
{
	/**
	 * 升序数组 --- 》 BST
	 */
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0)
            return null;
        return createBST(num,0,num.length-1);
    }
    public TreeNode createBST(int[] num, int left, int right)
    {
        if(left > right)
            return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = createBST(num,left,mid-1);
        root.right = createBST(num,mid+1,right);
        return root;
    }
}
