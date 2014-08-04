package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal
{
	/**
	 * 找到中序序列和后序序列的起始和结束端点
	 * 中序好确定
	 * 后序是起始点+偏移量 结束点-偏移量
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder)
	{
		if (inorder == null || postorder == null
				|| inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
		{
			map.put(inorder[i], i);
		}
		return constructor(inorder, 0, inorder.length - 1, postorder, 0,
				postorder.length - 1, map);
	}

	private TreeNode constructor(int[] inorder, int inL, int inR,
			int[] postorder, int posL, int posR, HashMap<Integer, Integer> map)
	{
		if (inL > inR || posL > posR)
			return null;
		TreeNode root = new TreeNode(postorder[posR]);
		int index = map.get(root.val);
		root.left = constructor(inorder, inL, index - 1, postorder, posL, posL
				+ index - inL - 1, map);
		root.right = constructor(inorder, index + 1, inR, postorder, posR
				- (inR - index), posR - 1, map);
		return root;
	}
}
