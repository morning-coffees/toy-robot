package toyrobot.blueprint;

import toyrobot.Coordinate;
import toyrobot.Movement;

public interface Robot {

	public void move(Movement move);
	public void move();
	public void setNextMove(Movement nextMove);
	public Movement getNextMove();
	public String getName();
	public String report();
	public Coordinate getLocation();
}
