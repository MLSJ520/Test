public class flower {
	public static void main(String[] args) {
		int i, a, b, c;
		System.out.println("ˮ�ɻ����У�");
		for (i = 100; i <= 999; i++) {
			a = i / 100;
			b = i % 100 / 10;
			c = i % 10;
			if (i == (a * a * a + b * b * b + c * c * c))
				System.out.println(+i);
		}
	}
}