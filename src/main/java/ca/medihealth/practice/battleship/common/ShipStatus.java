package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This enum class provides 2 ship status, 
 * Alive: a ship is hit less than 3 times 
 * Sunk: ship sunk for having been hit 3 times
 */
public enum ShipStatus {
	
    SUNK("Sunk"), 
    ALIVE("Alive");

    private String shipStatus;

    private ShipStatus(String value) {

        this.shipStatus = value;
    }

    public String getValue() {

        return this.shipStatus;
    }
}
