import java.util.Scanner;

class rectangle { // triangle circular
	float l;
	float w;

	rectangle(float l1, float w1) {
		l = l1;
		w = w1;
	}

	float area() {
		return l * w;
	}

	void show() {
		Scanner in = new Scanner(System.in);
		System.out.print("��Ϊ��");
		l = in.nextFloat();
		System.out.print("");
		System.out.print("��Ϊ��");
		w = in.nextFloat();
	}
}

class triangle {
	float h;
	float l;

	triangle(float h1, float l1) {
		h = h1;
		l = l1;
	}

	float area() {
		return h * l;
	}

	void show() {
		Scanner in = new Scanner(System.in);
		System.out.print("��Ϊ��");
		h = in.nextFloat();
		System.out.print("");
		System.out.print("��Ϊ��");
		l = in.nextFloat();
	}
}

class circular {
	float r;

	circular(float r1) {
		r = r1;
	}

	double area() {
		return 3.14 * r * r;
	}

	void show() {
		System.out.print("�뾶Ϊ��");
		Scanner in = new Scanner(System.in);
		r = in.nextFloat();
	}
}

public class Area {
	public static void main(String[] args) {

		System.out.println("��״���ͣ�");
		System.out.println("1.������");
		System.out.println("2.Բ��");
		System.out.println("3.������");
		System.out.print("������ѡ�(1/2/3)");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("�����볤���ε���ϸ��Ϣ��");
			rectangle one = new rectangle(0, 0);

			one.show();
			System.out.println(" ");
			System.out.println("�ó����ε����Ϊ��" + one.area());
		}
			;
			break;
		case 2: {
			System.out.println("������Բ�ε���ϸ��Ϣ��");
			circular two = new circular(2);
			two.show();
			System.out.println(" ");
			System.out.println("��Բ�ε����Ϊ��" + two.area());
		}
			;
			break;
		case 3: {
			System.out.println("�����볤���ε���ϸ��Ϣ��");
			triangle three = new triangle(3, 2);
			three.show();
			System.out.println(" ");
			System.out.println("�������ε����Ϊ��" + three.area());
		}
			;
			break;
		}
	}
}