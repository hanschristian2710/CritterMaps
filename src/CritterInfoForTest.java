public class CritterInfoForTest implements CritterInfo, CritterConstants {
	private String[] animals;

	public CritterInfoForTest(String[] animals) {
		this.animals = animals;

	}

	public String getNeighbor(int direction) {
		// create animals around the current position
		if (direction == SOUTH || direction == NORTH) {
			return animals[0];
		} else if (direction == WEST || direction == EAST) {
			return animals[1];
		} else {
			return animals[1];
		}
	}

}
