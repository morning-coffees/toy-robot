package toyrobot;

public class RobotImpl implements Robot {
	private Coordinate location;
	private Movement nextMove;
	private Table table;
	private String name;

	public RobotImpl(Coordinate location, Movement nextMove, Table table, String robotName) {
		if (table.isValidLocation(location.getX(), location.getY())) {
			table.setOccupant(location.getX(), location.getY(), this);
			this.location = location;
			this.nextMove = nextMove;
			this.table = table;
			this.name = robotName;
		} else {
			throw new IllegalArgumentException("Someone is already here!");
		}
	}

	public void setNextMove(Movement nextMove) {
		this.nextMove = nextMove;
	}

	@Override
	public void move(Movement move) {
		Integer xTmp = location.getX() + move.getX();
		Integer yTmp = location.getY() + move.getY();
		if (isValidCoordinates(xTmp, yTmp)) {
			boolean setOccupantSuccess = table.setOccupant(xTmp, yTmp, this);
			if (setOccupantSuccess) {
				table.removeOccupant(location.getX(), location.getY());
				location.setX(xTmp);
				location.setY(yTmp);
				System.out.println("Robot Moved");
			} else {
				System.out.println("Location on table is not Empty!");
			}
		} else {
			System.out.println("Robot Cannot Move");
		}
	}

	private boolean isValidCoordinates(Integer xTmp, Integer yTmp) {
		return xTmp <= table.getxLength() && yTmp <= table.getyLength() && xTmp >= 0 && yTmp >= 0;
	}

	@Override
	public void move() {
		move(nextMove);
	}

	@Override
	public String report() {
		StringBuilder sb = new StringBuilder();
		sb.append(name);
		sb.append(": ");
		sb.append(location.toString());
		sb.append(",");
		sb.append(nextMove.toString());
		System.out.println(sb.toString());
		return sb.toString();
	}

	public String getName() {
		return name;
	}

}
