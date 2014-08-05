package leetcode;

public class SumRoottoLeafNumbers
{
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    private int sumNumbers(TreeNode root, int sum)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.val + sum*10;
        return sumNumbers(root.left,sum*10+root.val) + sumNumbers(root.right,sum*10+root.val);
    }
}
