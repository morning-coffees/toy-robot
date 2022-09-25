package toyrobot;

import java.util.Map;

public interface Table {

	void setEmptyTable();

	/**
	 * 
	 * @param x
	 * @param y
	 * @param occupant
	 * @return TRUE if setOccupant is successful, FALSE if did not set Occupant/invalid data.
	 */
	boolean setOccupant(Integer x, Integer y, Robot occupant);
	
	boolean isValidLocation(Integer x, Integer y);

	void removeOccupant(Integer x, Integer y);

	void printTable();

	int getyLength();

	int getxLength();

	Map<String, Robot> getTableSlots();

}