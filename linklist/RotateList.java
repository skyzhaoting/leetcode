package leetcode;

public class RotateList
{
	/**
	 * 注意：如果k大于链表的长度 k要对链表的长度取余
	 */
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        int i;
        for(i = 0; i < n; i++)
        {
            if(fast != null)
                fast = fast.next;
            else break;
        }
        if(fast == null)
        {
            n = n%i;
            fast = head;
            for(i = 0; i < n; i++)
            {
                fast = fast.next;
            }
        }
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        /*能处理n=0的情况*/
        fast.next = head;         
        ListNode newHead = slow.next;
        slow.next = null;
        head = newHead;
        return head;
    }
}
