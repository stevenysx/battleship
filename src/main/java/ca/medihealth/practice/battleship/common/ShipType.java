package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This enum class is used for providing 5 ship types in Battleship game. 
 * Each type of ship has each own length(unit numbers). 
 * getTypeLength() provides the length corresponding to the type selected. 
 *     Destroyer: 2 units
 *     Submarine: 3 units
 *     Cruiser: 3 units
 *     Battleship: 4 units
 *     Carrier: 5 units
 */
public enum ShipType {
	
    DESTROYER("Destroyer"), 
    SUBMARINE("Submarine"),
    CURISER("Cruiser"),
    BATTLESHIP("Battleship"),
    CARRIER("Carrier");

    private String shipStatus;

    private ShipType(String value) {

        this.shipStatus = value;
    }

    public String getValue() {

        return this.shipStatus;
    }
    
    public int getShipLength() {
    	
    	if (this.shipStatus.equals(ShipType.DESTROYER.getValue())) {
    		return 2;
    	} 
    	
    	if (this.shipStatus.equals(ShipType.SUBMARINE.getValue())) {
    		
    		return 3;
    	} 
    	
    	if (this.shipStatus.equals(ShipType.CURISER.getValue())) {
		    		
		    return 3;
		} 
    	
    	if (this.shipStatus.equals(ShipType.BATTLESHIP.getValue())) {
			
			return 4;
		}
    	
    	if (this.shipStatus.equals(ShipType.CARRIER.getValue())) {
			
			return 5;
		}
    	
    	return 0; // this case can be improved by throwing a customized exception, InvalidShipTypeException
    }
}