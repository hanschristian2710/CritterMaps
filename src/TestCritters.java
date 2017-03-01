import java.awt.Color;

import junit.framework.TestCase;

public class TestCritters extends TestCase implements CritterConstants {

	// stone testing
	public void testStone() {
		Stone st = new Stone();
		// should not move (don't need any CritterInfo
		assertTrue(st.getMove(null) == CENTER);
		// S is the initial of stone
		assertTrue(st.toString().equals("S"));
		// stone is in gray color
		assertTrue(st.getColor().equals(Color.GRAY));
		// stone always return rock
		String[] opponent = { "S", "T", "L", "B", "W" };
		for (String s : opponent) {
			assertTrue(st.fight(s) == ROCK);
		}
	}

	// bear testing
	public void testBear() {
		Bear br = new Bear();
		// bear should move in north or west
		assertTrue(br.getMove(null) == NORTH || br.getMove(null) == WEST);
		// B is the initial of bear
		assertTrue(br.toString().equals("B"));
		// bear has brown color
		assertTrue(br.getColor().equals(new Color(128, 128, 64)));
		// bear always return scissors
		String[] opponent = { "S", "T", "L", "B", "W" };
		for (String s : opponent) {
			assertTrue(br.fight(s) == SCISSORS);
		}

	}

	// lion testing
	public void testLion() {
		// moves the given number of steps in a random direction, then chooses a
		// new random direction and repeats
		int steps = (int) (Math.random() * 10) + 5;
		Lion lion = new Lion(steps);
		int[] dir = new int[4];
		int currentDir = 0; // irrelevant
		for (int i = 1; i <= 10000; i++) {
			int d = lion.getMove(null);
			if (i % steps == 1) {
				currentDir = d;
			} else {
				assertTrue(d == currentDir);
			}
			if (d == WEST) {
				dir[0]++;
			} else if (d == EAST) {
				dir[1]++;
			} else if (d == NORTH) {
				dir[2]++;
			} else {
				dir[3]++;
			}
		}

		double y = 0;
		for (int val : dir) {
			y = Math.abs(val - 2500) / 2500.0;
		}
		assertTrue(y <= 0.2);
		// L is the initial of the Lion
		assertTrue(lion.toString().equals("L"));
		// lion has color of yellow
		assertTrue(lion.getColor().equals(Color.YELLOW));
		// lion always return paper
		String[] opponent = { "S", "T", "L", "B", "W" };
		for (String s : opponent) {
			assertTrue(lion.fight(s) == PAPER);
		}

	}

	// tiger testing
	public void testTiger() {
		// color pass through constructor
		Tiger tg = new Tiger(Color.ORANGE);
		// tiger should move 5 steps south, 5 steps west,
		// 5 steps north, 5 steps east
		int[] tgMove = { SOUTH, WEST, NORTH, EAST };
		int count = 0;
		int i = 1;
		for (int steps = 1; steps < 10000; steps++) {
			count = (i - 1) / 5;
			i++;
			if (i == 21) {
				i = 1;
			}
			assertTrue(tg.getMove(null) == tgMove[count]);
		}
		// T is the initial of tiger
		assertTrue(tg.toString().equals("T"));
		// tiger has color that is passed through the constructor
		assertTrue(tg.getColor().equals(Color.ORANGE));
		// tiger always return scissors and paper
		String[] opponent = { "S", "T", "L", "B", "W" };
		int tigerFight = 0;
		for (String s : opponent) {
			tigerFight = tg.fight(s);
		}
		assertTrue(tigerFight == SCISSORS || tigerFight == PAPER);

	}

	// wolf testing
	public void testWolf() {
		Wolf w = new Wolf();
		// Create a set of animals around the wolf on the movement
		// in this case, wolf has only 2 opponent tiger and wolf itself
		CritterInfoForTest ci = new CritterInfoForTest(
				new String[] { "T", "W" });

		if (w.getMove(ci) == WEST) {
			assertTrue(w.getMove(null) == EAST);
		} else if (w.getMove(ci) == SOUTH) {
			assertTrue(w.getMove(null) == NORTH);
		} else if (w.getMove(ci) == EAST) {
			assertTrue(w.getMove(null) == WEST);
		}
		// W is the initial of the wolf
		assertTrue(w.toString().equals("W"));
		// wolf return different type of skill when meet other animals
		assertTrue(w.fight("S") == PAPER);
		assertTrue(w.fight("T") == SCISSORS);
		assertTrue(w.fight("B") == ROCK);
		assertTrue(w.fight("L") == SCISSORS);
	}
}
