package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal
{
	public ArrayList<Integer> inorderTraversal1(TreeNode root)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		inorderTravel(root, res);
		return res;
	}

	public void inorderTravel(TreeNode root, ArrayList<Integer> res)
	{
		if (root == null)
			return;
		inorderTravel(root.left, res);
		res.add(root.val);
		inorderTravel(root.right, res);
	}
	
    public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty())
        {
            if(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
