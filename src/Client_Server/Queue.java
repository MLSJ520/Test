package Client_Server;

import java.util.LinkedList;

/**
 * ���潫Ҫ���ʵ�URL TODO��
 */
public class Queue {
	// ʹ������ʵ�ֶ���
	private LinkedList<String> queue = new LinkedList<String>();

	// ���
	public void InQueue(String url) {
		queue.addLast(url);
	}

	// ����
	public String OutQueue() {
		return queue.removeFirst().toString();
	}

	// �ж��Ƿ�Ϊ��
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	// �ж϶������Ƿ����TԪ��
	public boolean isContains(String url) {
		return queue.contains(url);
	}
}
