package Client_Server;

import java.util.HashSet;
import java.util.Set;

/**
 * 保存已经访问的URL，使用HashSet
 *
 */
public class VistedQueue {
	private Set<String> VisitedUrl = new HashSet<String>(); // 已访问的队列
	private Queue unVisitedUrl = new Queue(); // 未访问的队列
	// 添加新URL到未访问的队列中

	public void addVisitedUrl(String Url) {
		VisitedUrl.add(Url);
	}

	// 添加新URL到已访问的队列中
	public void addunVisitedUrl(String Url) {
		unVisitedUrl.InQueue(Url);
	}

	// 获得已访问过的URL的数目
	public int getVisiteedNum() {
		return VisitedUrl.size();
	}

	// 判断URL T是否存在
	public boolean isContains(String url) {
		return VisitedUrl.contains(url);
	}
	// 判断队列是否为空

	public boolean isVisitedUrlEmpey() {
		return VisitedUrl.isEmpty();
	}
}
