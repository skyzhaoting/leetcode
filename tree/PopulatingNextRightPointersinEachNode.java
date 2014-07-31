package leetcode;

public class PopulatingNextRightPointersinEachNode
{
	/**
	 * 如果左子树不空 左子树的next是右子树
	 * 如果右子树不空 右子树的next是父结点的next的左孩子
	 */
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null && root.next != null)
        {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
