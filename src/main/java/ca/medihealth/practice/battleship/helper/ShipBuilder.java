package ca.medihealth.practice.battleship.helper;

import java.security.InvalidParameterException;

import ca.medihealth.practice.battleship.common.Constants;
import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.model.Board;
import ca.medihealth.practice.battleship.model.Ship;

/**
 * 
 * @author Steven Yan
 *
 * This is a utility class for building a ship on the board either vertically or horizontally
 */
public class ShipBuilder extends BoardBuilder {

	public ShipBuilder() {
		
		super();
	}

	public Board buildShipInBoardVertically(int rowStartNumber, String currentColumnLetter) throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
		
		int shipLength = Constants.SHIP_TYPE.getShipLength();

		if (!BuilderHelper.isValidRow(rowStartNumber) || shipLength + rowStartNumber > Constants.LAST_ROW_NUMBER) {
			
			throw new InvalidParameterException("Invalid row number");
		}
		if (!BuilderHelper.isValidColumn(currentColumnLetter)) {
			
			throw new InvalidParameterException("Invalid column letter");	
		}
		
		Ship ship = new Ship(shipLength);
		
		BuilderHelper.getNextRowNumbers(rowStartNumber, shipLength).forEach(r -> {
			
			try {
				String shipCoordiante = BuilderHelper.buildShipCoordiante(currentColumnLetter, r);
				ship.addShipUnitCoordinate(shipCoordiante);
			} catch (InvalidConfigurationValueExcpetion | OverLimitExcpetion e) {
			
				e.printStackTrace();
			}
		});
		
		// add ship on the board
		super.getBoard().addShip(ship);
		
		return super.getBoard();
	}

	public Board buildShipInBoardHorizontally(char columnStartLetter, int currentRowNumber) {
		
		int shipLength = Constants.SHIP_TYPE.getShipLength();

		if (!BuilderHelper.isValidRow(currentRowNumber)) {
			
			throw new InvalidParameterException("Invalid row number");
		}
		
		if (!BuilderHelper.isValidColumn(String.valueOf(columnStartLetter))) {
			
			throw new InvalidParameterException("Invalid column letter");	
		}
		
		if (Character.toUpperCase(columnStartLetter + shipLength) > Constants.LAST_COLUMN_LETTER) {
			
			throw new InvalidParameterException("Invalid column letter");
		}
		
		Ship ship = new Ship(shipLength);
		
		BuilderHelper.getNextLettersAlphabetically(columnStartLetter, shipLength).forEach(l -> {
			String shipCoordiante = null;
			try {
				
				shipCoordiante = BuilderHelper.buildShipCoordiante(l, currentRowNumber);
			} catch (InvalidConfigurationValueExcpetion e1) {
				
				e1.printStackTrace();
			}
			
			try {
				
				ship.addShipUnitCoordinate(shipCoordiante);
			} catch (OverLimitExcpetion e) {

				e.printStackTrace();
			}
		});
		
		// add ship on the board
		super.getBoard().addShip(ship);
		
		return super.getBoard();
	}	
}
