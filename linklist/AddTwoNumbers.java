package leetcode;

public class AddTwoNumbers
{
	/**
	 * 建一个以dummy的头结点新链表 方便链表的插入
	 * 注意本题的进位 如果最后进位不为0 新建一个结点
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;
        while(l1 != null || l2 != null)
        {
            if(l1 != null)
            {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                carry += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(carry%10);
            pre = pre.next;
            carry = carry/10;
        }
        if(carry > 0)
        {
            pre.next = new ListNode(carry);
        }
        return dummy.next;
        
    }
}
