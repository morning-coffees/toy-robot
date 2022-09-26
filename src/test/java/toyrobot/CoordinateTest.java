package toyrobot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void toString_0_0_test() {
		Coordinate coordinate = new Coordinate(0,0);
		assertEquals("0,0", coordinate.toString());
	}
	
	@Test
	void toString_5_5_test() {
		Coordinate coordinate = new Coordinate(5,5);
		assertEquals("5,5", coordinate.toString());
	}
}
