import java.awt.Color;

public class Bear extends Critter {
	// first bear movement is north
	// set the first movement of north to be true
	private boolean goNorth = true;

	public int fight(String opponent) {
		return SCISSORS; // Bear always return scissors
	}

	public Color getColor() {
		Color brown = new Color(128, 128, 64);
		return brown; // Bear has brown color
	}

	public int getMove(CritterInfo info) {
		// the movement of the bear will be north first then west
		// and repeat
		if (goNorth) {
			goNorth = false; // north direction will be false
			return NORTH;

		} else {
			goNorth = true; // north direction will be true
			return WEST;
		}
	}

	public String toString() {
		return "B"; // displays bear as B
	}

}
