package leetcode;


public class LinkedListCycle
{
	/**
	 * 判断链表是否有环 经典题目 快慢指针 注意：指针为空问题
	 */
	public static boolean hasCycle(ListNode head)
	{
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
}
