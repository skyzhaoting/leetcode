package leetcode;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal
{
	/**
	 * 找到中序序列和前序序列的起始和结束端点
	 * 中序好确定
	 * 前序是起始点+偏移量 结束点-偏移量
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder)
	{
		if (preorder == null || inorder == null
				|| preorder.length != inorder.length)
			return null;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++)
		{
			map.put(inorder[i], i);
		}
		return constructor(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1, map);
	}

	private TreeNode constructor(int[] preorder, int preL, int preR,
			int[] inorder, int inL, int inR, HashMap<Integer, Integer> map)
	{
		if (preL > preR || inL > inR)
			return null;
		TreeNode root = new TreeNode(preorder[preL]);
		int index = map.get(root.val);
		root.left = constructor(preorder, preL + 1, index - inL + preL,
				inorder, inL, index - 1, map);
		root.right = constructor(preorder, preL + index - inL + 1, preR,
				inorder, index + 1, inR, map);
		return root;
	}
}
