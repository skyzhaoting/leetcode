package leetcode;

public class RemoveDuplicatesfromSortedList
{
	/**
	 * 与数组操作的方式一样
	 */
	public ListNode deleteDuplicates(ListNode head)
	{
		if (head == null || head.next == null)
			return head;
		ListNode pre = head;
		ListNode p = head.next;
		while (p != null)
		{
			if (pre.val == p.val)
			{
				pre.next = p.next;
				p = p.next;
			} else
			{
				pre = p;
				p = p.next;
			}
		}
		return head;
	}
}
