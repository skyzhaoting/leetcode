package leetcode;

public class ReverseLinkedListII
{
	/**
	 * 找到翻转的那段链表翻转 最后把 这段链表和原链表连起来
	 */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode pre = null;
        ListNode p = head;
        int i = 1;
        for(;i < m; i++)
        {
            pre = p;
            p = p.next;
        }
        ListNode tail = p;
        ListNode temp = p;
        p = p.next;
        ListNode q = p.next;
        for(; i < n; i++)
        {
            q = p.next;
            p.next = temp;
            temp = p;
            p = q;
        }
        if(pre != null)
        {
            pre.next = temp;
            tail.next = q;
            return head;
        }
        else
        {
            tail.next = q;
            return temp;
        }
        
    }
}
