package toyrobot.blueprint.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import toyrobot.Commands;
import toyrobot.Coordinate;
import toyrobot.Movement;
import toyrobot.blueprint.Robot;
import toyrobot.blueprint.RobotController;
import toyrobot.blueprint.Table;

public class RobotControllerImpl implements RobotController {

	Scanner input = new Scanner(System.in);
	Table table = new TableImpl(5, 5);
	Map<Integer, Robot> robotList = new HashMap<>();

	@Override
	public void start() {
		setTableDetails();
		setRobotDetails();
		table.printTable();
		if (robotList.size() > 0) {
			receiveCommands();
		} else {
			System.out.println("There are no robots. Ending");
		}
	}

	@Override
	public void setTableDetails() {
		System.out.print("Table # columns: ");
		int x = input.nextInt();
		System.out.print("Table # rows: ");
		int y = input.nextInt();
		table = new TableImpl(x, y);
	}

	@Override
	public void setRobotDetails() {
		System.out.print("How many robots? ");
		int numberOfRobots = input.nextInt();

		for (Integer robotNumber = 1; robotNumber <= numberOfRobots; robotNumber++) {
			System.out.print("Robot " + robotNumber.toString() + " Details (PLACE x,y,DIRECTION): ");
			String command = input.next();
			try {
				if (Commands.PLACE.name().equals(command.toUpperCase())) {
					String parameter = input.next();
					String[] parameters = parameter.split(",");
					if (parameters.length == 3) {
						Integer x = Integer.parseInt(parameters[0]);
						Integer y = Integer.parseInt(parameters[1]);
						Movement movement = Movement.getEquivalent(parameters[2]);

						Coordinate coordinate = new Coordinate(x, y);
						Robot robot = new RobotImpl(coordinate, movement, table, robotNumber.toString());
						robotList.put(robotNumber, robot);

						System.out.println("Placed Robot " + robotNumber.toString());
					} else {
						System.out.println("Incorrect Parameters, destroyed robot #" + robotNumber.toString());
					}
				} else {
					System.out.println("Incorrect Command, destroyed robot #" + robotNumber.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(
						"Something is wrong with this robot, self destructing robot #" + robotNumber.toString());
			}
		}
	}

	@Override
	public void receiveCommands() {
		System.out.println("Available Commands: MOVE,LEFT,RIGHT,REPORT,END");
		while(true) {
			System.out.println("Enter Command (COMMAND ROBOTNUMBER):");
			String command = input.next();

			if("END".equals(command)) {
				System.out.println("Exiting..");
				break;
			}
			
			Integer parameter = input.nextInt();

			if (robotList.containsKey(parameter) && Commands.getEquivalent(command) != null) {
				parseCommand(command, robotList.get(parameter));
			} else {
				System.out.println("Invalid Command or parameter");
			}
			table.printTable();
		}
	}

	@Override
	public void parseCommand(String command, Robot robot) {
		switch (Commands.getEquivalent(command)) {
		case LEFT -> robot.setNextMove(robot.getNextMove().getLeft());
		case RIGHT -> robot.setNextMove(robot.getNextMove().getRight());
		case MOVE -> robot.move();
		case REPORT -> robot.report();
		default -> throw new IllegalArgumentException("Unexpected value: " + Commands.getEquivalent(command));
		}
	}

}
