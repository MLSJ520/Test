package Client_Server;

import java.util.Set;
import java.util.HashSet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//import javax.swing.text.html.parser.Parser;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
//import org.apache.http.ParseException;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.TableHeader;
import org.htmlparser.tags.TableRow;
import org.htmlparser.tags.TableTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

public class HtmlParserTool {
	private static String ENcode = "GBK";
	static DownLoadPage getpage = new DownLoadPage();

	private static void message(String szMsg) {
		try {
			System.out.println(new String(szMsg.getBytes(ENcode), System.getProperty("file.encoding")));
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		try {
			
			String Content = getpage.Savepage();
			Parser parser = new Parser(Content);
			parser.setEncoding(ENcode);
			//NodeList tableList = null;
			//NodeFilter tableFilter = new NodeClassFilter(TableTag.class);
			
			NodeFilter tableFilter = new HasAttributeFilter("td");
			// NodeList nodes = parser.extractAllNodesThatMatch(filter);
			// NodeFilter filterID = new HasAttributeFilter("a");
			// NodeFilter filterChild = new HasChildFilter(filterA);
			// NodeFilter filter2 = new AndFilter(filterID, filterChild);
			NodeList nodes = parser.extractAllNodesThatMatch(tableFilter);
			if (nodes != null) {
				String nodeContent = null;
				for (int i = 1; i < nodes.size(); i++) {
					
					Node textnode = (Node) nodes.elementAt(i);
					nodeContent = textnode.toPlainTextString();
					message(nodeContent);
					if(nodeContent.equals("名称")){
						
					}
					// message("=================================================");
				   /* TableTag table = (TableTag)nodes.elementAt(i);
					TableRow[] rows = table.getRows();
					for(int r= 0;r<rows.length;r++){
						TableRow tr = rows[r];
						TableHeader[] headers = tr.getHeaders();
						for(int j = 0;j<headers.length;j++){
							System.out.println("tag标签为：" + headers[j].getTagName());
							System.out.println("标签内容为："+headers[j].getStringText());
						}*/
					}
				
				}
			//}
		} catch (Exception e) {
			e.printStackTrace(); 
		}

	}

}
