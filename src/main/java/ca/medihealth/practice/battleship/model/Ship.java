package ca.medihealth.practice.battleship.model;

import java.util.ArrayList;
import java.util.List;

import ca.medihealth.practice.battleship.common.FireResult;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.common.ShipStatus;

/**
 * 
 * @author Steven Yan
 *
 * The POJO class Ship contains two properties: 
 * length: the units of the ship
 * shipStatus: alive or sunk in the fighting when playing the game
 * shipUnitsCoordinates: stores the coordinates of each unit of the ship, 
 *                       the coordinate format is one column letter concatenated by a row number, eg. A7, B8 etc.
 *                       the row number and the column letter must be in the board's coordinates when added to the board
 * After each fire from the opponent, the ship can be checked the fire result: Hit or Missed. Each hit only destroys one unit when being hit.
 * The ship will sink after all units are hit.   
 */
public class Ship {

    private int length;
    private ShipStatus shipStatus = ShipStatus.ALIVE;
    private List<String> shipUnitsCoordinates = new ArrayList<String>();
	
	public Ship(int length) {
		super();
		this.length = length;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public ShipStatus getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(ShipStatus shipStatus) {
		this.shipStatus = shipStatus;
	}

	public List<String> getShipUnitsCoordinates() {
		return shipUnitsCoordinates;
	}

	/**
	 * Add a ship unit's coordinate to the ship's coordinate collection
	 * @param shipUnitCoordinate: the string contacted by one letter(column) and one number(row), example: "A1", "B4", "E7"...etc.
	 *                            the column letter and row number must be found in the game board, or the unit coordinate is invalid  
	 * @throws OverLimitExcpetion: when adding unit coordinate over the total number of ship units(length)
	 */
	public void addShipUnitCoordinate(String shipUnitCoordinate) throws OverLimitExcpetion {
		
		if (this.shipUnitsCoordinates.size() == this.length) {
			throw new OverLimitExcpetion("");
		}

		this.shipUnitsCoordinates.add(shipUnitCoordinate);
	}
	
	/**
	 * Once a opponent fires, check if it is hit. If yes, then remove one unit(length -1) and return FireResult.HIT, or FireResult.MISS. 
	 * If no unit left(length = 0), then update ship status to Sunk before return the result
	 * 
	 * @param fireCoordiante must be in format: one letter followed by one number, such as A7, B3 etc.
	 */
	public FireResult getFireResultAfterOpponentHit(String fireCoordiante) {
		
		final int currentShipUnits = this.getShipUnitsCoordinates().size();
		this.getShipUnitsCoordinates().removeIf(c -> c.equalsIgnoreCase(fireCoordiante));
		
		if (this.getShipUnitsCoordinates().size() == 0) {
			
			this.shipStatus = ShipStatus.SUNK;
		}
		return (currentShipUnits - this.getShipUnitsCoordinates().size() == 1) ? FireResult.HIT : FireResult.MISS;
	}
}
