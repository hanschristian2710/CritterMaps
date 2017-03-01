import java.awt.Color;

public class Lion extends Critter {

	private int steps;
	private int[] movesDir = { NORTH, SOUTH, EAST, WEST };
	private int counter;
	private int thenMove;

	public Lion(int steps) {
		super();
		this.steps = steps;
		counter = steps;
	}

	public int getSteps() {
		return steps;
	}

	public int fight(String opponent) {
		return PAPER; // Lion always return paper
	}

	public Color getColor() {
		return Color.YELLOW; // Lion has yellow color
	}

	public int getMove(CritterInfo info) {
		// moves the given number of steps in a random direction
		// then choose a new random direction and repeat

		if (counter == steps) { // if counter has equaled the number of
								// steps in the given direction, it will
								// choose a new random direction
			thenMove = movesDir[rand.nextInt(movesDir.length)];
			counter = 1;
			return thenMove;
		} else {
			counter++;
			return thenMove;
		}
	}

	public String toString() {
		return "L"; // displays lion as L
	}
}
