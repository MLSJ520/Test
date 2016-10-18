import java.awt.EventQueue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LifeGame {
	int Map[][] = new int[23][29];// 1死,2生
	int Map_next[][] = new int[23][29];
	Timer timer;

	public void CreatMap() {
		int row, col, i, j;
		Random random = new Random();
		for (i = 0; i < 23; i++) {
			for (j = 0; j < 29; j++) {
				Map[i][j] = 1;
				Map_next[i][j] = 1;
			}
		}
		for (i = 8; i < 16; i++) {
			for (j = 9; j < 21; j++) {
				row = random.nextInt(23);
				col = random.nextInt(29);
				Map[row][col] = 2;
			}

			// Map[i][j]=2;
		}
	}

	/*
	 * 细胞状态改变判断
	 */
	public void ChangeCellMode(int Row, int Col) {
		int count = 0;
		if (Row != 22 && Map[Row + 1][Col] == 2)
			count++;
		if (Row != 0 && Map[Row - 1][Col] == 2)
			count++;
		if (Row != 22 && Col != 28 && Map[Row + 1][Col + 1] == 2)
			count++;
		if (Row != 22 && Col != 0 && Map[Row + 1][Col - 1] == 2)
			count++;
		if (Col != 28 && Map[Row][Col + 1] == 2)
			count++;
		if (Col != 0 && Map[Row][Col - 1] == 2)
			count++;
		if (Row != 0 && Col != 0 && Map[Row - 1][Col - 1] == 2)
			count++;
		if (Row != 0 && Col != 28 && Map[Row - 1][Col + 1] == 2)
			count++;
		if (count == 3)
			Map_next[Row][Col] = 2;
		else if (count == 2)
			Map_next[Row][Col] = Map[Row][Col];
		else
			Map_next[Row][Col] = 1;
	}

	/*
	 * 整个地图状态更新
	 */
	public void CopyMap() {
		for (int i = 0; i < 23; i++)
			for (int j = 0; j < 29; j++)
				Map[i][j] = Map_next[i][j];
	}

	public void SetTime() {
		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("happy");
			}
		}, 2000);
	}

	public void UpdateMap() {
		for (int i = 0; i < 23; i++)
			for (int j = 0; j < 29; j++)
				ChangeCellMode(i, j);
		CopyMap();
	}

	public static void main(String[] args) {
		// lg.CreatMap();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LGMap frame = new LGMap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// lg.SetTime();
	}

}
