package toyrobot;

public interface Robot {

	public void move(Movement move);
	public void move();


	public Movement getNextMove();
	public void setNextMove(Movement nextMove);
	
	public String getName();
	
	public String report();
}
