import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MDsecurity {
	
	public final static String MD5(String str) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', };
		byte[] btInput = str.getBytes();
		try {
			// ���MD5ժҪ�㷨��MessageDigest����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��������ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] code = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
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
		String H = null;  //Ԫ�ַ���ժҪ
		int count1 = 0;
		char[] m = new char[100];
		char[] m1 = new char[100];
		char[] H1 = new char[32];
		char[] H2 = new char[32];
		Random random = new Random();
		String content1 = "HappyBirthdayToyouhappybirthdaytoyouYouareMyPrettyGirlCountingStars"; //50λ��Ϣ
		String content2 = null;
		m1 = content1.toCharArray();
		m = content1.toCharArray();
		H = MD5(content1);
		System.out.println("ԭ�ַ�����\n"+H+"\n�޸ĺ�:");
		H1 = H.toCharArray();  //ԭ�ַ�����MDcode
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
			System.out.print("-------���ƶȣ�");
			System.out.println((float)count*100/H1.length + "%");
			count1++;
		}
		
	}
	public static void main(String[] args) {
		/*System.out.println(MDsecurity.MD5("����"));
		System.out.println(MDsecurity.MD5("����"));
		System.out.println(MDsecurity.MD5("��Ҫ����"));
		System.out.println("---------------");
		System.out.println(MDsecurity.MD5("abcdefg"));
		System.out.println(MDsecurity.MD5("abcdefg"));
		System.out.println(MDsecurity.MD5("abcdefh"));*/
		Compare();
	
    }
}