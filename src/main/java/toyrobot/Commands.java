package toyrobot;

public enum Commands {

	LEFT,
	RIGHT,
	MOVE,
	REPORT;
	
	public static Commands getEquivalent(String command) { 
		return switch (command) {
		case "LEFT" -> LEFT;
		case "RIGHT" -> RIGHT;
		case "MOVE" -> MOVE;
		case "REPORT" -> REPORT;
		default -> null;
		};
	}
}
