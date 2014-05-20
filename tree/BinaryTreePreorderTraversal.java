package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal
{
	/**
	 * 先序遍历 递归和迭代
	 */
	public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorderTravel(root,res);
        return res;
    }
    public void preorderTravel(TreeNode root,ArrayList<Integer> res)
    {
        if(root == null)
            return;
        res.add(root.val);
        preorderTravel(root.left,res);
        preorderTravel(root.right,res);
    }
    /* 迭代*/
    public ArrayList<Integer> preorderTraversal2(TreeNode root) 
	{
    	ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty())
		{
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
		}
		return res;
	}
    /*迭代 方法2 */
    public ArrayList<Integer> preorderTraversal3(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty())
        {
            if(root != null)
            {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}
