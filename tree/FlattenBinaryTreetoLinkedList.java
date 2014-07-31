package leetcode;

public class FlattenBinaryTreetoLinkedList
{
	/**
	 * 递归的思想 引入pre全局变量 记录上次访问的结点 
	 * 提前记录树的右子树 以免被覆盖
	 */
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode right = root.right;
        if(pre != null)
        {
            pre.left = null;
            pre.right = root;
        }
        pre = root;
        flatten(root.left);
        flatten(right);
    }
}
