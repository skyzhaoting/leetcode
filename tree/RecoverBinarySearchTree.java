package leetcode;

public class RecoverBinarySearchTree
{
	/**
	 * 找到两个结点  中序遍历 第一次逆序对的第一个元素 和 第二个元素（或者第二逆序对的第二个元素）
	 */
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    private void inorder(TreeNode root)
    {
        if(root == null)
            return;
        inorder(root.left);
        if(firstElement == null && root.val < lastElement.val)
        {
            firstElement = lastElement;
            secondElement = root;
        }
        else if(firstElement != null && root.val < lastElement.val)
        {
            secondElement = root;
        }
        lastElement = root;
        inorder(root.right);
    }
}
