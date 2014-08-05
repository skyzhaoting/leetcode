package leetcode;

public class BinaryTreeMaximumPathSum
{
	/**
	 * 返回值是 自身的值 + （左子树， 右子树，0） 之中的最大值，为了供父结点计算自身的最长路径
	 * 结点自身的最长路径为 自身的值 + 左子树 > 0 ? 左子树：0 + 右子树 > 0 ? 右子树：0
	 */
    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root)
    {
        findMaxPathSum(root);
        return maxPath;
    }
    private int findMaxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int left = findMaxPathSum(root.left);
        int right = findMaxPathSum(root.right);
        int cur = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
        if(cur > maxPath)
            maxPath = cur;
        return root.val + Math.max(left,Math.max(right,0));
    }
}
