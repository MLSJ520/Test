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
		System.out.print("长为：");
		l = in.nextFloat();
		System.out.print("");
		System.out.print("宽为：");
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
		System.out.print("高为：");
		h = in.nextFloat();
		System.out.print("");
		System.out.print("底为：");
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
		System.out.print("半径为：");
		Scanner in = new Scanner(System.in);
		r = in.nextFloat();
	}
}

public class Area {
	public static void main(String[] args) {

		System.out.println("形状类型：");
		System.out.println("1.长方形");
		System.out.println("2.圆形");
		System.out.println("3.三角形");
		System.out.print("请输入选项：(1/2/3)");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("请输入长方形的详细信息：");
			rectangle one = new rectangle(0, 0);

			one.show();
			System.out.println(" ");
			System.out.println("该长方形的面积为：" + one.area());
		}
			;
			break;
		case 2: {
			System.out.println("请输入圆形的详细信息：");
			circular two = new circular(2);
			two.show();
			System.out.println(" ");
			System.out.println("该圆形的面积为：" + two.area());
		}
			;
			break;
		case 3: {
			System.out.println("请输入长方形的详细信息：");
			triangle three = new triangle(3, 2);
			three.show();
			System.out.println(" ");
			System.out.println("该三角形的面积为：" + three.area());
		}
			;
			break;
		}
	}
}