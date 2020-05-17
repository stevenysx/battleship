package ca.medihealth.practice.battleship.helper;
import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.helper.ShipBuilder;
import ca.medihealth.practice.battleship.model.Ship;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class ShipBuilderTest {

	ShipBuilder builder;
	
	@Before
	public void initTest() throws InvalidConfigurationValueExcpetion {
		
		builder = new ShipBuilder();
		builder.buildBoard();
	}
	
    @Test
    public void buildShipInBoardVertically_GoodSet() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
    	int rowStartNumber = 3;
		String currentColumnLetter = "C";
		
		builder.buildShipInBoardVertically(rowStartNumber, currentColumnLetter);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "C3,C4,C5";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = InvalidParameterException.class)
    public void buildShipInBoardVertically_InvalidColumn() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
    	int rowStartNumber = 3;
		String currentColumnLetter = "K";
		
		builder.buildShipInBoardVertically(rowStartNumber, currentColumnLetter);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "C3,C4,C5";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = InvalidParameterException.class)
    public void buildShipInBoardVertically_InvalidRow() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
    	int rowStartNumber = 11;
		String currentColumnLetter = "C";
		
		builder.buildShipInBoardVertically(rowStartNumber, currentColumnLetter);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "C3,C4,C5";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void buildShipInBoardHorizontally_GoodSet() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
		int currentRowNumber = 3;
		char columnStartLetter = 'B';
		builder.buildShipInBoardHorizontally(columnStartLetter, currentRowNumber);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "B3,C3,D3";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    

    @Test(expected = InvalidParameterException.class)
    public void buildShipInBoardHorizontally_InvalidRow() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
		int currentRowNumber = 12;
		char columnStartLetter = 'B';
		builder.buildShipInBoardHorizontally(columnStartLetter, currentRowNumber);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "B3,C3,D3";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = InvalidParameterException.class)
    public void buildShipInBoardHorizontally_InvalidColumn() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
		int currentRowNumber = 3;
		char columnStartLetter = 'K';
		builder.buildShipInBoardHorizontally(columnStartLetter, currentRowNumber);
    	
		Ship ship = builder.getBoard().getShips().get(0);
    	
        String expectedValue = "B3,C3,D3";
        String actualValue = ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
}
