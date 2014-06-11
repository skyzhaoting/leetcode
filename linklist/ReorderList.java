package leetcode;

public class ReorderList
{
	/**
	 * 第一步找到链表的中点，拆成两个链表
	 * 第二步将第二个链表逆置
	 * 第三步合并两个链表
	 */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        slow = head;
        fast = reverse(head2);
        while(slow != null && fast != null)
        {
            ListNode temp = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = temp;
        }
    }
    
    /*非递归的reverse
     public ListNode reverse(ListNode head)
     {
         if(head == null || head.next == null)
             return head;
         ListNode pre = null;
         ListNode cur = head;
         while(cur != null)
         {
             ListNode temp = cur.next;
             cur.next = pre;
             pre = cur;
             cur = temp;
         }
         return pre;
     }
     */
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        return reverse(head,head.next);
    }
    public ListNode reverse(ListNode current, ListNode next)
    {
        if(next == null) return current;
        ListNode newHead = reverse(current.next,next.next);
        next.next = current;
        current.next = null;
        return newHead;
    }
}
