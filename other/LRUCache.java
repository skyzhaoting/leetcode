package leetcode;

import java.util.HashMap;
/**
 * 使用HashMap + 双向链表 模拟LRU
 * HashMap维护结点的位置关系，KEY就是key VALUE是该结点（key 和 value的信息）
 * get 1。表中没有 返回-1；2.表中有但是不是队尾的结点 分为 是队头结点（队头结点后移即可） 不是队头结点(调整结点到队尾)
 * set 1。表中有 修改value值 如果不是队尾调整到队尾 2.表中没有 如果超过容量（删除队头并判断表是否空） 没有超过容量
 * 如果表中没有结点 新结点加入 如果表中有结点 新结点加到队尾 并加入到HashMap中
 * @author liang
 *
 */

public class LRUCache
{
	class Node
	{
		Node pre;
		Node next;
		int key, val;

		public Node(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}

	private int capacity;
	private int num;
	private HashMap<Integer, Node> map;
	private Node first, last;

	public LRUCache(int capacity)
	{
		this.capacity = capacity;
		num = 0;
		map = new HashMap<Integer, Node>();
		first = null;
		last = null;
	}

	public int get(int key)
	{
		Node node = map.get(key);
		if (node == null)
			return -1;
		else if (node != last)
		{
			if (node == first)
				first = first.next;
			else
				node.pre.next = node.next;
			node.next.pre = node.pre;
			last.next = node;
			node.pre = last;
			node.next = null;
			last = node;
		}
		return node.val;
	}

	public void set(int key, int value)
	{
		Node node = map.get(key);
		if (node != null)
		{
			node.val = value;
			if (node != last)
			{
				if (node == first)
					first = first.next;
				else
					node.pre.next = node.next;
				node.next.pre = node.pre;
				last.next = node;
				node.pre = last;
				node.next = null;
				last = node;
			}
		} else
		{
			Node newNode = new Node(key, value);
			if (num >= capacity)
			{
				map.remove(first.key);
				if (first != null)
					first = first.next;
				else
					last = null;
				num--;
			}
			if (first == null || last == null)
				first = newNode;
			else
			{
				last.next = newNode;
			}
			newNode.pre = last;
			last = newNode;
			map.put(key, newNode);
			num++;
		}
	}
}
