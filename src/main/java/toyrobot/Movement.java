package toyrobot;

public enum Movement {

	NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

	private Integer x;
	private Integer y;

	Movement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Movement getLeft(Movement movement) {
		return switch (movement) {
		case NORTH	-> WEST;
		case WEST	-> SOUTH;
		case SOUTH	-> EAST;
		case EAST	-> NORTH;
		};
	}

	public Movement getRight(Movement movement) {
		return switch (movement) {
		case NORTH	-> EAST;
		case EAST	-> SOUTH;
		case SOUTH	-> WEST;
		case WEST	-> NORTH;
		};
	}
}
