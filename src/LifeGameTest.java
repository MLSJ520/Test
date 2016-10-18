import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class LifeGameTest {
	private static LifeGame lifegame = new LifeGame();

	@Before
	public void setUp() throws Exception {
		lifegame.CreatMap();
		for (int i = 0; i < 23; i++)
			for (int j = 0; j < 29; j++) {
				if (lifegame.Map[i][j] != 2 && lifegame.Map[i][j] != 1 || lifegame.Map_next[i][j] != 1)
					System.out.println(lifegame.Map[i][j] + "Creat Map fail!");
				// fail("Not yet implemented");
			}
	}

	@Test
	public void testCreatMap() {
		// fail("Not yet implemented");
		// lifegame.CreatMap();
	}

	@Test
	public void testChangeCellMode() {
		// fail("Not yet implemented");
		lifegame.ChangeCellMode(0, 0);
		lifegame.ChangeCellMode(22, 0);
		lifegame.ChangeCellMode(22, 28);
		lifegame.ChangeCellMode(0, 28);
		// lifegame.ChangeCellMode(0, 29);
	}

	@Test
	public void testCopyMap() {
		// fail("Not yet implemented");
		lifegame.CopyMap();
	}

	@Test
	public void testUpdateMap() {
		lifegame.UpdateMap();
		// fail("Not yet implemented");
	}

}
