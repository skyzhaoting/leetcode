package leetcode;

public class RemoveDuplicatesfromSortedListII
{
	/**
	 * pre指向上一个不重复的元素
	 */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        while(p != null && p.next != null)
        {
            if(p.val == p.next.val)
            {
                while(p.next != null && p.val == p.next.val)
                    p = p.next;
                pre.next = p.next;
                p = p.next;
            }
            else
            {
                pre = p;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
