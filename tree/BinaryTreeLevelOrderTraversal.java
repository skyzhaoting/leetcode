package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal
{
	/**
	 * 层序遍历
	 */
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		ArrayList<Integer> level = new ArrayList<Integer>();
		while (!queue.isEmpty())
		{
			TreeNode cur = queue.poll();
			if (cur != null)
			{
				level.add(cur.val);
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			} else
			{
				res.add(level);
				/*清空的操作 用clear把res中的level也清空了*/
				level = new ArrayList<Integer>();
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return res;
	}
}
