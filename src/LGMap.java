import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LGMap extends JFrame {

	private JPanel contentPane;
	public LifeGame lGame = new LifeGame();
	Timer timer;
	Graphics g;
	Graphics2D g2d;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { LGMap frame = new LGMap();
	 * frame.setSize(800, 600); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	public Graphics getG() {
		return g;
	}

	/**
	 * Create the frame.
	 */
	public LGMap() {
		this.setSize(800, 600);
		this.setTitle("生命游戏");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/// setBounds(100, 100, 762, 439);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lGame.CreatMap();

		final JButton Stop = new JButton("\u6682\u505C");
		Stop.setBounds(653, 115, 71, 23);
		contentPane.add(Stop);
		Stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = Stop.getText();
				if (text.equals("暂停")) {
					timer.stop();
					Stop.setText("继续");
				}
				if (text.equals("继续")) {
					timer.start();
					Stop.setText("暂停");
				}

			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
		g2d = (Graphics2D) g;
		int row, col, i, j;
		for (i = 0; i < 23; i++) {
			for (j = 0; j < 29; j++) {
				row = 50 + j * 20;
				col = 50 + i * 20;
				if (lGame.Map[i][j] == 1) {
					g2d.setColor(Color.white);
					g2d.drawOval(row, col, 20, 20);

					g2d.setColor(Color.black);
					g2d.fillOval(row, col, 20, 20);

				}
				if (lGame.Map[i][j] == 2) {
					g2d.setColor(Color.white);
					g2d.drawOval(row, col, 20, 20);
					g2d.setColor(Color.red);
					g2d.fillOval(row, col, 20, 20);
				}

			}
		}

		final JButton Start = new JButton("\u5F00\u59CB");

		Start.setBounds(653, 30, 71, 23);
		contentPane.add(Start);

		Start.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// lGame.CreatMap();
				timer = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						lGame.UpdateMap();
						;
						repaint();
					}
				});
				// 开启计时器
				timer.restart();
				Start.setEnabled(false);
				// timer.start();
			}
		});
		/*
		 * for(int i=50;i<630;i+=20) for(int j=50;j<510;j+=20) {
		 * g.draw3DRect(i,j,20,20,true); g.setColor(Color.blue); g.fill3DRect(i,
		 * j, 20, 20, true);
		 * 
		 * }
		 */
	}
}
