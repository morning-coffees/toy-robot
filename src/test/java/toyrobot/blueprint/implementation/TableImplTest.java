package toyrobot.blueprint.implementation;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import toyrobot.Coordinate;
import toyrobot.Movement;
import toyrobot.blueprint.Robot;
import toyrobot.blueprint.Table;

class TableImplTest {
	
	private static Table table;
	private static Robot robot;
	
	@BeforeAll
	static void setUpBeforeClass() {
		table = new TableImpl(10, 9);
		robot = new RobotImpl(new Coordinate(0, 0), Movement.NORTH, table, "1");
	}
	
	@BeforeEach
	void setUpBeforeEach() {
		table.setEmptyTable();
	}
	
	@Test
	void testSetEmptyTable() {
		robot.move();
		assertEquals(1, table.getRobotCountInTable());
		table.setEmptyTable();
		assertEquals(0, table.getRobotCountInTable());
		robot.move();
		assertEquals(1, table.getRobotCountInTable());
	}
	
	@Test
	void testIsValidLocation() {
		table.setOccupant(robot.getLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		table.setOccupant(robot.getLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		assertFalse(table.isValidLocation(robot.getLocation().getX(), robot.getLocation().getY()));
		robot.move();
		assertTrue(table.isValidLocation(0, 0));
		table.setEmptyTable();
		assertTrue(table.isValidLocation(robot.getLocation().getX(), robot.getLocation().getY()));
		assertTrue(table.isValidLocation(0, 0));		
	}


	@Test
	void testRemoveOccupant() {
		table.setOccupant(robot.getLocation(), robot);
		assertEquals(1, table.getRobotCountInTable());
		table.removeOccupant(4, 4);
		table.removeOccupant(3, 3);
		table.removeOccupant(10, 10);
		assertEquals(1, table.getRobotCountInTable());
		table.removeOccupant(0, 0);
		assertEquals(0, table.getRobotCountInTable());
	}

	@Test
	void testGetLength() {
		assertEquals(10, table.getxLength());
		assertEquals(9, table.getyLength());
		table.setEmptyTable();
		assertEquals(10, table.getxLength());
		assertEquals(9, table.getyLength());
	}

}
