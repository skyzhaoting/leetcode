package leetcode;

public class PathSum
{
	/**
	 * 判断一棵二叉树的从根到叶子结点的路径和是否等于给定的值
	 * 递归 如果是叶子结点并且值和剩下的值相等 就找到路径
	 */
	public boolean hasPath(TreeNode root, int sum)
	{
		if(root == null)
			return false;
		if(root.left == null && root.right == null && root.val == sum)
			return true;
		return hasPath(root.left,sum-root.val) || hasPath(root.right, sum-root.val);
	}
}