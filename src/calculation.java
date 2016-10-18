import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class calculation extends JFrame implements ActionListener {
	JPanel pnl1 = new JPanel();
	JPanel pnl2 = new JPanel();
	JTextField text = new JTextField("0");
	static String[] name = { "7", "8", "9", "*", "4", "5", "6", "/", "1", "2", "3", "+", "0", ".", "=", "-" };
	JButton[] btn = new JButton[name.length];
	JButton Backspace = new JButton("CE");

	public calculation() {
		super("calculation");
		this.setSize(200, 200); // 框架大小
		this.setResizable(false); // 可见
		this.setLocationRelativeTo(null); // 设置在桌面中间*/
		this.setVisible(true);
		// getContentPane().setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("North", pnl2);
		getContentPane().add("Center", pnl1);
		pnl2.setLayout(new BorderLayout());
		pnl2.add(text);
		pnl2.add(Backspace);
		pnl2.add("Center", text);
		pnl2.add("East", Backspace);
		// container.setLayout(null);
		// text.setBounds(50, 60, 300, 530);
		text.setBackground(Color.LIGHT_GRAY);
		text.setHorizontalAlignment(JTextField.RIGHT);
		GridLayout grid = new GridLayout(4, 4);
		pnl1.setLayout(grid);
		// pnl1.setBounds(50, 60, 500, 500);

		for (int i = 0; i < name.length; i++) {
			btn[i] = new JButton(name[i]);
			// btn[i].setSize(20,20); //按钮大小
			pnl1.add(btn[i]); // 将按钮加入面板中
			btn[i].addActionListener(this); // 监听者向mainJFrame注册
		}
		// getContentPane().add(text);

		// btn1=new JButton("0")

		Backspace.addActionListener(this);
		text.addActionListener(this);
		pack();
	}

	public static void main(String[] args) {
		new calculation();
		// System.out.println(total);
	}

	String operator = "=";
	boolean isFirstDigit = true;
	boolean firstOpe = true;
	double numble = 0.0;
	static String total = null;
	double a;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		Object target = e.getSource();
		String label = e.getActionCommand();
		if (target == Backspace)
			handelBs();
		else if ("0123456789.".indexOf(label) > 0)
			handelnum(label);
		else
			handelch(label);

	}

	public void handelnum(String Key) {
		// TODO Auto-generated method stub
		// total.concat(Key);
		if (isFirstDigit) {
			isFirstDigit = false;
			text.setText("");
		}
		text.setText(text.getText() + Key);

	}

	public void handelch(String Key) {
		// TODO Auto-generated method stub
		if (isFirstDigit)
			operator = Key;
		else {
			switch (operator) {
			case "+":
				numble += Double.valueOf(text.getText());
				break;
			case "-":
				numble -= Double.valueOf(text.getText());
				break;
			case "*":
				numble *= Double.valueOf(text.getText());
				break;
			case "/":
				numble /= Double.valueOf(text.getText());
				break;
			case "=":
				numble = Double.valueOf(text.getText());
				break;
			default:
				break;
			}
			text.setText("" + numble);
			operator = Key;
			isFirstDigit = true;
		}
	}

	private void handelBs() {
		// TODO Auto-generated method stub
		// System.out.println("0");
		text.setText("");
		isFirstDigit = true;
		operator = "=";
	}

}
