package leetcode;

public class ReverseNodesinkGroup
{
	/**
	 * reverse函数的参数是 前置结点和K个结点的后置结点
	 */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 0;
        while(cur != null)
        {
            count++;
            ListNode knode = cur.next;
            if(count == k)
            {
                pre = reverse(pre,knode);
                count = 0;
            }
            cur = knode;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode pre, ListNode knode)
    {
        if(pre == null || pre.next == null) /*健壮性*/
            return pre;
        ListNode last = pre.next;
        ListNode cur = last.next;
        while(cur != knode)
        {
            ListNode temp = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        last.next = cur;
        return last;
    }
}
