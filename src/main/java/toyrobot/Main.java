package toyrobot;

import toyrobot.blueprint.RobotController;
import toyrobot.blueprint.implementation.RobotControllerImpl;

public class Main {

	public static void main(String[] args) {
		RobotController rc = new RobotControllerImpl();
		rc.start();
//		Table table = new TableImpl(5,4);
//		Robot robot = new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, "R_1");
//		Robot robot2 = new RobotImpl(new Coordinate(0, 1), Movement.EAST, table, "R_2");
//
//		robot2.move();
//		robot.move(Movement.NORTH);
//		robot2.move(Movement.EAST);
//		table.printTable();
//		robot.move(Movement.WEST);
//		table.printTable();
////		table.setOccupant(0, 1, robot);
//		robot.move(Movement.EAST);
//		table.printTable();
//		robot.move(Movement.NORTH);
//		table.printTable();
//		robot.move(Movement.EAST);
//		robot.move(Movement.EAST);
//		robot.move(Movement.EAST);
//		robot.move(Movement.EAST);
//		robot.move(Movement.EAST);
//		robot.move(Movement.SOUTH);
//		table.printTable();
//		robot.report();
//		robot2.report();
	}

}
