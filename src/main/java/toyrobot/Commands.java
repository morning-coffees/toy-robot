package toyrobot;

public enum Commands {

	LEFT,
	RIGHT,
	MOVE,
	REPORT,
	PLACE;
	
	public static Commands getEquivalent(String command) { 
		return switch (command.toUpperCase()) {
		case "LEFT" -> LEFT;
		case "RIGHT" -> RIGHT;
		case "MOVE" -> MOVE;
		case "REPORT" -> REPORT;
		case "PLACE" -> PLACE;
		default -> null;
		};
	}
}
