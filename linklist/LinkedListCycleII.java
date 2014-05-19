package leetcode;

public class LinkedListCycleII
{
	/**
	 * 找到链表的的起始点 没有返回NULL 先找到相遇点 从头到链表起始点的距离 = 相遇点到起始点的距离
	 */
	public static ListNode detectCycle(ListNode head)
	{
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while(true)
		{
			if(fast == null || fast.next == null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		slow = head;
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

}
