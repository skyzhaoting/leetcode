package leetcode;

public class ConvertSortedListtoBinarySearchTree
{
	/**
	 * 与数组一样，找链表的中点使用快慢指针 这次采用左闭又开区间
	 * 快慢指针找中点 采用代码的方法 参考LinkedListCycle
	 */
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return createBST(head,null);
    }
    public TreeNode createBST(ListNode start,ListNode end)
    {
        if(start == end)
            return null;
        ListNode mid = start;
        ListNode fast = start;
        while(fast != end && fast.next != end)
        {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = createBST(start,mid);
        root.right = createBST(mid.next,end);
        return root;
    }
}
