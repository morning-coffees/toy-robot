package toyrobot.blueprint;

public interface RobotController {
	public void start();
	public void receiveCommands();
	void setRobotDetails();
	void setTableDetails();
	void parseCommand(String command, Robot robot);
}
