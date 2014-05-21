package leetcode;

import java.util.ArrayList;

public class PathSumII
{
	/**
	 * 把所有满足条件的路径和记录
	 */
	
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return res;
        ArrayList<Integer> item = new ArrayList<Integer>();
        item.add(root.val);
        helper(root,sum-root.val,item,res);
        return res;
    }
    public void helper(TreeNode root, int sum, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null && sum == 0)
        {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(root.left != null)
        {
            item.add(root.left.val);
            helper(root.left,sum-root.left.val,item,res);
            item.remove(item.size()-1);
        }
        if(root.right != null)
        {
            item.add(root.right.val);
            helper(root.right,sum-root.right.val,item,res);
            item.remove(item.size()-1);
        }
    }
}
