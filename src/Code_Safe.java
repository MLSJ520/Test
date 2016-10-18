import java.io.IOException;

public class Code_Safe {
	private String Code;
	private char[] rule;
	private char[] code;
	int[] Count_Num;//用于字母计数;
	char[] Count_Num_2;//用于字母频率排序
	
	//float[] Count_Rate;
	
	public void Init(){
		Code = "CHOAZSZWIMZASVILLZYBNLLTZNMWIATHZGILDMZDNLOAROIILYMPOCGNMZSIASUADNYTHZIUTSTNADOAGPZRFIRMN"
				+ "ACZHZSOASPORZDMNAYWHIWNTCHZDTHZGNMZTIAZVZRGOVZUPNADKZZPFOGHTOAG"
				+ "CINCHLNAGPOAGHNSBZCIMZTHZFORSTTIWOAVILLZYBNLLGILDBITHNSNCINCHNADPLNYZR"
				+ "BNCKOALISNAGZLZSILYMPOCSSHZNADHZRTZNMMNTZSHZLPZDCHOANSCIIPTHZORFORSTILYM"
				+ "POCSGILDSOACZTHZACHOAZSZWIMZASVILLZYBNLLTZNMHNSBZZASZZANSNFLNGBZNRZRNMIAGNLL"
				+ "CHOAZSZSPIRTSTZNMSFIROTSTZANCOTYNADFOGHTOAGSPOROT";
		code = Code.toCharArray();
		Code = "*e taoin shrdlcumwfgypb vkjxqz";//agdmzycriqksltnwxuohvbpjfe
		//Z NASIO LTHCMGRPDYBFW VU KXQJE
		rule = Code.toCharArray();
	}
	/*
	 * 程序b
	 * 计算出每个字符的占比
	 */
	public void Count(){
		int Max = 0;
		char temp;
		int num = 0;
		int n = 26;
		Count_Num = new int[27];
		Count_Num_2 = new char[27];
		for(int i = 0;i<code.length;i++){
			Count_Num[code[i]-64]++;
		}
		for(int i = 1;i<27;i++)
			Count_Num_2[i] = (char) (i+64);
		for(int i = 1;i<27;i++){
			Max = Count_Num[i];
			num = i;
			for(int j = i;j<27;j++){
				if(Count_Num[j] > Max){
					num = j;
					Max = Count_Num[j];
				}
			}
			Count_Num[num] = Count_Num[i];
			Count_Num[i] = Max;
			temp = Count_Num_2[num];
			Count_Num_2[num] = Count_Num_2[i];
			Count_Num_2[i] = temp;
		}
		//for(int i = 1;i<27;i++){
			//System.out.print(Count_Num_2[i]);
		//}	
	}
	/*
	 * 选取前40个字符蛮力破解经=并判断
	 */
	
	public void Convert(){
		char ch;
		for(int i = 0;i<code.length;i++){
			ch = code[i];
			switch(ch){
			case 'E':
				code[i] = 'Z';
				break;
			case 'Z':
				code[i] = 'E';
				break;
			case 'A':
				code[i] = 'N';
				break;
			case 'I':
				code[i] = 'O';
				break;
			case 'O':
				code[i] = 'I';
				break;
			case 'N':
				code[i] = 'A';
				break;
			default:
				break;
			}
			System.out.print(code[i]);
		}
		int judge;		
	}
	
	public static void main(String[] args){
		Code_Safe cs = new Code_Safe();
		cs.Init();
		cs.Count();
		cs.Convert();
	}
}

/*
 * 
 *etaoinshrdlcumwfgypbvkjxqz
 *
 *agdmzycriqksltnwxuohvbpjfe
 *可看出e被替换掉z
 *o被替换掉
 *jvrl
 *2 2 5 7 25 9 
 *
33
8
18
13
0
7
16
23
29
0
2
27
17
38
28
13
0
15
30
26
3
5
6
0
10
52
 * */
