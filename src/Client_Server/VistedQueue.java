package Client_Server;

import java.util.HashSet;
import java.util.Set;

/**
 * �����Ѿ����ʵ�URL��ʹ��HashSet
 *
 */
public class VistedQueue {
	private Set<String> VisitedUrl = new HashSet<String>(); // �ѷ��ʵĶ���
	private Queue unVisitedUrl = new Queue(); // δ���ʵĶ���
	// �����URL��δ���ʵĶ�����

	public void addVisitedUrl(String Url) {
		VisitedUrl.add(Url);
	}

	// �����URL���ѷ��ʵĶ�����
	public void addunVisitedUrl(String Url) {
		unVisitedUrl.InQueue(Url);
	}

	// ����ѷ��ʹ���URL����Ŀ
	public int getVisiteedNum() {
		return VisitedUrl.size();
	}

	// �ж�URL T�Ƿ����
	public boolean isContains(String url) {
		return VisitedUrl.contains(url);
	}
	// �ж϶����Ƿ�Ϊ��

	public boolean isVisitedUrlEmpey() {
		return VisitedUrl.isEmpty();
	}
}
