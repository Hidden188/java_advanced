package myUtils;

/**
 * 双链表的实现，带头结点（不带数据）的双链表，为了更高效，该类包含指向尾部的指针tail
 */
public class List {

	/**
	 * 单链表和双链表
	 * 1 双链表的节点结构
	 * typedef struct dlink_node
	 * {
	 * 	struct dlink_node *prev
	 * 	struct dlink_node *next
	 * 	void val
	 * }
	 * 2 删除节点pindex
	 * pindex->next->prev = pindex->prev;
	 * pindex->prev->next = pindex->next;
	 * free(pindex); // 释放节点
	 * 3 添加节点pnode到pindex之前
	 * pnode->prev = pindex->prev;
	 * pnode->next = pindex;
	 * pindex->prev->next = pnode;
	 * pindex->prev = pnode;
	 */
	
	// 节点类Node
	private static class Node {
		Object value;
		Node prev = this;
		Node next = this;
		
		Node(Object v) {
			value = v;
		}
		
		public String toString() {
			return value.toString();
		}
	}
	
	private Node head = new Node(null); // 头节点
	private int size; // 
	
	// 添加到链表的表头
	public boolean addFirst(Object o) {
		addAfter(new Node(o), head);
		return true;
	}
	
	// 将元素添加到聊表表尾
	public boolean addLast(Object o) {
		addBefore(new Node(o), head);
		return true;
	}
	
	public boolean add(Object o) {
		return addLast(o);
	}
	
	// 将元素添加到指定位置
	public boolean add(int index, Object o) {
		addBefore(new Node(o), getNode(index));
		return true;
	}
	
	// 移除指定位置
	public boolean remove(int index) {
		removeNode(getNode(index));
		return true;
	}
	
	// 移除链表表头元素
	public boolean removeFirst() {
		removeNode(head.next);
		return true;
	}
	
	// 移除链表表尾元素
	public boolean removeLast() {
		removeNode(head.prev);
		return true;
	}
	
	// 取到指定位置的元素值
	public Object get(int index) {
		return getNode(index).value;
	}
	
	// 返回链表的大小
	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer("[");
		Node node = head;
		for(int i = 0; i < size; i++) {
			node = node.next;
			if (i > 0) {
				s.append(", ");
			}
			s.append(node.value);
		}
		s.append("]");
		return s.toString();
	}
	
	// 查找链表元素
	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node node = head.next;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	// 在某个元素之前添加元素
	private void addBefore(Node newNode, Node node) {
		newNode.prev = node.prev;
		newNode.next = node;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	// 在某元素之后添加元素
	private void addAfter(Node newNode, Node node) {
		newNode.prev = node;
		newNode.next = node.next;
		newNode.next.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}
	
	// 移除特定元素
	private void removeNode(Node node) {
		node.next.prev = node.prev;
		node.prev.next = node.next;
		node.prev = null;
		node.next = null;
		size--;
	}
	
	
	// 链表的插入和删除
	/*LinkList merge_1(LinkList LA, LinkList LB) {
		LNode *p, *q;
		p = LA;
		q = LB;
		while(p->next != LA)
			p = p->next;
		while(q->next != LB)
			q = q->next;
		p->next = LB->next;
		free(LB);
		q->next = LA;
		return(LA);
	}*/
	
	
}
