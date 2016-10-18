class adm {
	String name;
	String pwd;

	adm(String newname, String newpwd) {
		name = newname;
		pwd = newpwd;
	}

	void show() {
		System.out.print("–’√˚£∫" + name);
		System.out.println("√‹¬Î£∫" + pwd);
	}
}

class Demo {
	public static void main(String[] args) {
		adm my1 = new adm("admin1", "111111");
		adm my2 = new adm("admin2", "222222");
		my1.show();
		my2.show();
	}
}