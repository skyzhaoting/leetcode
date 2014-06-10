package leetcode;

public class SwapNodesinPairs
{
	/**
	 * 注意指针的链接 尤其循环的时候 注意指针的丢失
	 * 创建一个dummy头指针 再建一个pre指针==dummy很有必要
	 * --------------测试的时候完整测试 每一层循环----------------------
	 */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode first = head;
        ListNode second = head.next;
        while(second != null)
        {
            first.next = second.next;
            second.next = first;
            pre.next = second;
            pre = first;
            first = first.next;
            if(first != null)
                second = first.next;
            else break;
        }
        return dummy.next;
    }
}
