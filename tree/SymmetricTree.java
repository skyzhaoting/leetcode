package leetcode;

public class SymmetricTree
{
	/**
	 * 镜像树 用到 same tree的方法
	 */
	public boolean isSymmetric(TreeNode root)
	{
		if (root == null)
			return true;
		return isSame(root.left, root.right);
	}

	public boolean isSame(TreeNode p, TreeNode q)
	{
		if (p == null && q == null)
			return true;
		if (p == null || q == null || p.val != q.val)
			return false;
		return isSame(p.left, q.right) && isSame(p.right, q.left);
	}
}
