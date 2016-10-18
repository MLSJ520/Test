package Client_Server;

import java.util.LinkedList;

/**
 * 保存将要访问的URL TODO表
 */
public class Queue {
	// 使用链表实现队列
	private LinkedList<String> queue = new LinkedList<String>();

	// 入队
	public void InQueue(String url) {
		queue.addLast(url);
	}

	// 出队
	public String OutQueue() {
		return queue.removeFirst().toString();
	}

	// 判断是否为空
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	// 判断队列中是否包含T元素
	public boolean isContains(String url) {
		return queue.contains(url);
	}
}
