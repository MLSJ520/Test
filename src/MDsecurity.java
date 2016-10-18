import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MDsecurity {
	
	public final static String MD5(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', };
		byte[] btInput = str.getBytes();
		try {
			// 获得MD5摘要算法的MessageDigest对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用输入的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] code = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			char strChar[] = new char[code.length * 2];
			int k = 0;
			for (int i = 0; i < code.length; i++) {
				byte byte1 = code[i];
				strChar[k++] = hexDigits[byte1 >>> 4 & 0xf];
				strChar[k++] = hexDigits[byte1 & 0xf];
			}
			return new String(strChar);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void Compare(){
		String H = null;  //元字符串摘要
		int count1 = 0;
		char[] m = new char[100];
		char[] m1 = new char[100];
		char[] H1 = new char[32];
		char[] H2 = new char[32];
		Random random = new Random();
		String content1 = "HappyBirthdayToyouhappybirthdaytoyouYouareMyPrettyGirlCountingStars"; //50位信息
		String content2 = null;
		m1 = content1.toCharArray();
		m = content1.toCharArray();
		H = MD5(content1);
		System.out.println("原字符串：\n"+H+"\n修改后:");
		H1 = H.toCharArray();  //原字符串的MDcode
		while(count1<10){
		    int i = random.nextInt(31);
			m[i] = (char) (random.nextInt(26)+64);
			content2 = m.toString();
			m[i] = m1[i];
			m = m1.clone();
			H = MD5(content2);
			System.out.println(H);
			H2 = H.toCharArray();
			
			int count = 0;
			for(int j = 0;j<H1.length;j++){
				if(H1[j] == H2[j]){
					count++;
				}	
			}
			System.out.print("-------相似度：");
			System.out.println((float)count*100/H1.length + "%");
			count1++;
		}
		
	}
	public static void main(String[] args) {
		/*System.out.println(MDsecurity.MD5("加密"));
		System.out.println(MDsecurity.MD5("加密"));
		System.out.println(MDsecurity.MD5("我要加密"));
		System.out.println("---------------");
		System.out.println(MDsecurity.MD5("abcdefg"));
		System.out.println(MDsecurity.MD5("abcdefg"));
		System.out.println(MDsecurity.MD5("abcdefh"));*/
		Compare();
	
    }
}