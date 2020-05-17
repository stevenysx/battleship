package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This Constants class stores some configuration data for being used by other classes 
 */
public class Constants {

	// The following Battleship configuration data should be configurable and stored in a properties file
	// for the timing reason, put them in a constant class for now
	public static final int LAST_ROW_NUMBER = 8;
	public static final char LAST_COLUMN_LETTER = 'H';
	public static final ShipType SHIP_TYPE = ShipType.CURISER;
	
}