package leetcode;

public class CopyListwithRandomPointer
{
	/**
	 * 复制链表的每个结点跟到该结点的后面
	 * 第二遍把random指针归位
	 * 第三遍拆分链表
	 */
	class RandomListNode
	{
		int label;
		RandomListNode next, random;

		RandomListNode(int x)
		{
			this.label = x;
		}
	};
	public RandomListNode copyRandomList(RandomListNode head)
	{
		if (head == null)
			return head;
		RandomListNode cur = head;
		while (cur != null)
		{
			RandomListNode node = new RandomListNode(cur.label);
			node.next = cur.next;
			node.random = cur.random;
			cur.next = node;
			cur = node.next;
		}
		cur = head;
		while (cur != null)
		{
			if (cur.random != null)
				cur.next.random = cur.random.next;
			cur = cur.next.next;
		}
		RandomListNode newHead = head.next;
		cur = head;
		while (cur != null)
		{
			RandomListNode newNode = cur.next;
			cur.next = newNode.next;
			if (newNode.next != null)
			{
				newNode.next = newNode.next.next;
			}
			cur = cur.next;
		}
		return newHead;
	}
}
