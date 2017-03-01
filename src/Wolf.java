import java.awt.Color;

public class Wolf extends Critter {

	private int[] wolfFight = { ROCK, PAPER, SCISSORS };
	private int[] wolfDir = { SOUTH, WEST, NORTH, EAST };

	public int fight(String opponent) {
		// wolf fight differently when meet other animal
		if (opponent.equals("S")) {
			return wolfFight[1]; // paper
		} else if (opponent.equals("B")) {
			return wolfFight[0]; // rock
		} else if (opponent.equals("L")) {
			return wolfFight[2]; // scissors
		} else if (opponent.equals("T")) {
			return wolfFight[2]; // scissors
		} else {
			return wolfFight[rand.nextInt(wolfFight.length)]; // random
		}
	}

	public Color getColor() {
		// the wolf will be displayed in random colors
		Color randomColor = new Color(rand.nextInt(256), rand.nextInt(256),
				rand.nextInt(256));
		return randomColor;
	}

	public int getMove(CritterInfo info) {
		// using getNeighbor to find out what is around the wolf
		String south = info.getNeighbor(SOUTH);
		String west = info.getNeighbor(WEST);
		String north = info.getNeighbor(NORTH);
		String east = info.getNeighbor(EAST);

		// the movement of the wolf is basically to avoid tiger and itself,
		// but the wolf still can meet the tiger
		// in this game, the wolf will be dominant to other animals
		if (south == "T" || south == "W") {
			return wolfDir[2]; // north
		} else if (west == "T" || west == "W") {
			return wolfDir[3]; // east
		} else if (north == "T" || north == "W") {
			return wolfDir[0]; // south
		} else if (east == "T" || east == "W") {
			return wolfDir[1]; // west
		} else {
			return wolfDir[rand.nextInt(wolfDir.length)];
		}
	}

	public String toString() {
		// display wolf as WOLF
		return "W";
	}

}
