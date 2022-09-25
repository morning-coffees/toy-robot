package toyrobot;

public enum Movement {

	NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

	private Integer x;
	private Integer y;

	Movement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static Movement getEquivalent(String movement) {
		return switch (movement) {
		case "NORTH" -> NORTH;
		case "EAST" -> EAST;
		case "SOUTH" -> SOUTH;
		case "WEST" -> WEST;
		default -> null;
		};
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public Movement getLeft() {
		return switch (this) {
		case NORTH -> WEST;
		case WEST -> SOUTH;
		case SOUTH -> EAST;
		case EAST -> NORTH;
		};
	}

	public Movement getRight() {
		return switch (this) {
		case NORTH -> EAST;
		case EAST -> SOUTH;
		case SOUTH -> WEST;
		case WEST -> NORTH;
		};
	}
}
