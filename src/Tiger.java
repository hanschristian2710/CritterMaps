import java.awt.Color;

public class Tiger extends Critter {

	private boolean scissor = true; // tiger will return scissor first
	private Color color;
	private int counter = 1;
	private int[] wantedMovement = { SOUTH, WEST, NORTH, EAST };

	public int fight(String opponent) {
		// Tiger always return scissor first then paper
		if (scissor) {
			scissor = false; // scissor will be false
			return SCISSORS;
		} else {
			scissor = true; // scissor will be true
			return PAPER;
		}
	}

	public Color getColor() {
		return color;
	}

	public Tiger(Color color) {
		super();
		this.color = color;
	}

	public int getMove(CritterInfo info) {
		// tiger will move south in the first 5 steps, then 5 steps west,
		// then 5 steps north, then 5 steps east, and repeats
		int i = (counter - 1) / 5;
		counter++;
		if (counter == 21) { // when the counter tiger steps have reached 21,
								// counter will be set back to 1
			counter = 1;
		}
		return wantedMovement[i];

	}

	public String toString() {
		return "T"; // displays tiger as T
	}

}
