package leetcode;

public class RemoveNthNodeFromEndofList
{
	/**
	 * 注意 一个结点 倒数第一个的测试用例
	 */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        for(int i = 0; i < n; i++)
        {
            if(fast != null)
                fast = fast.next;
        }
        if(fast == null)
            return head.next;
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
