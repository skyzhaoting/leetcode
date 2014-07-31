package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal
{
	/**
	 * 用两个栈模拟 
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root)
	{
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> level = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		boolean line = true;
		while (!stack1.isEmpty() || !stack2.isEmpty())
		{
			TreeNode cur;
			if (line)
			{
				cur = stack1.pop();
				level.add(cur.val);
				if (cur.left != null)
				{
					stack2.push(cur.left);
				}
				if (cur.right != null)
				{
					stack2.push(cur.right);
				}
				if (stack1.isEmpty())
				{
					res.add(level);
					level = new ArrayList<Integer>();
					line = !line;
				}
			} else
			{
				cur = stack2.pop();
				level.add(cur.val);
				if (cur.right != null)
				{
					stack1.push(cur.right);
				}
				if (cur.left != null)
				{
					stack1.push(cur.left);
				}
				if (stack2.isEmpty())
				{
					res.add(level);
					level = new ArrayList<Integer>();
					line = !line;
				}
			}
		}
		return res;
	}
}
