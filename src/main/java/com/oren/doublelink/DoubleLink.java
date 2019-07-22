package com.oren.doublelink;

import javax.crypto.interfaces.PBEKey;

/**
 * Java实现双链表
 */
public class DoubleLink<T> {

	/**表头*/
	private DNode<T> head;
	/**节点数*/
	private int nCount;

	private class DNode<T> {
		/**前驱节点*/
		public DNode preNode;
		/**后继节点*/
		public DNode nextNode;
		/**值(基本类型、引用类型)*/
		public T value;

		/**构造函数*/
		public DNode(DNode preNode, DNode nextNode, T value) {
			this.preNode = preNode;
			this.nextNode = nextNode;
			this.value = value;
		}
	}

	/**双链表构造函数*/
	public DoubleLink() {
		/**创建空链表(只有表头：前驱节点、后继节点都是自己)*/
		this.head = new DNode(null, null, null);
		head.preNode = head.nextNode = head;
		/**初始化数量*/
		nCount = 0;
	}

	/**节点数*/

	public int size() {
		return nCount;
	}

	/**
	 * 书否为空
	 */
	public boolean isEmpty() {
		return nCount == 0;
	}

	/**
	 * 获取第index位置的节点
	 * @param index
	 * @return
	 */
	private DNode<T> getNode(int index) {
		/**参数合法性校验*/
		if (index < 0 || index > nCount) {
			throw new IndexOutOfBoundsException();
		}
		/**正向查找*/
		if (index < nCount / 2) {
			DNode<T> lNode = head.nextNode;
			for (int i = 0; i < index; i++) {
				lNode = lNode.nextNode;
			}
			return lNode;
		}
		/**反向查找*/
		DNode<T> rnode = head.preNode;
		int rIndex = nCount - (index +1);
		for (int j = 0; j < rIndex; j++) {
			rnode = rnode.preNode;
		}
		return rnode;
	}

	/**
	 * 获取第index位置节点的值
	 * @param index
	 * @return
	 */
	public T get(int index) {
		return getNode(index).value;
	}

	/**
	 * 获取第一个节点的值
	 * @return
	 */
	public T getFirst() {
		return getNode(0).value;
	}

	/**
	 * 获取最后一个节点的值
	 * @return
	 */
	public T getLast() {
		return get(nCount - 1);
	}

	/**
	 * 在第index位置插入节点
	 * @param index
	 * @param t
	 */
	public void insert(int index, T t) {
		if (index == 0) {
			DNode<T> node = new DNode<T>(head, head.nextNode, t);
			head.nextNode.preNode = node;
			head.nextNode = node;
			nCount++;
			return;
		}

		DNode<T> node = getNode(index);
		/**
		 * 当前节点的前驱节点是原节点的前驱节点
		 * 当前节点的后继节点是原节点
		 */
		DNode<T> cur = new DNode(node.preNode, node, t);
		node.preNode.nextNode = cur;
		node.preNode = cur;
		nCount++;
		return;
	}

	/**
	 * 将节点插入第一个节点处
	 * @param t
	 */
	public void insertFirst(T t) {
		insert(0, t);
	}

	/**
	 * 将节点追加到链表的末尾
	 * @param t
	 */
	public void appendLast(T t) {
		DNode<T> node = new DNode<T>(head.preNode, head, t);
		head.preNode.nextNode = node;
		head.preNode = node;
		nCount++;
		return;
	}

	/**
	 * 删除index位置的节点
	 * @param index
	 */
	public void del(int index) {
		DNode<T> iNode = getNode(index);
		iNode.preNode.nextNode = iNode.nextNode;
		iNode.nextNode.preNode = iNode.preNode;
		nCount--;
		return;
	}

	/**
	 * 删除第一个节点
	 */
	public void delFirst() {
		del(0);
	}

	/***
	 * 删除最后一个节点
	 */
	public void delLast() {
		del(nCount - 1);
	}

}
