package toyrobot;

public interface Robot {

	public void move(Movement move);
	public void move();
	
	public String getName();
	
	public String report();
}
