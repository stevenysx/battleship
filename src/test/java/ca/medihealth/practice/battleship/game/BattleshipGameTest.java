package ca.medihealth.practice.battleship.game;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.game.BattleshipGame;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class BattleshipGameTest {

	BattleshipGame battleshipGame;
	
	@Before
	public void initTest() {
	
		battleshipGame = new BattleshipGame();
	}

	@Test
    public void validateStartRowNumber_Valid() {

        String expectedValue = "passed";
        
        battleshipGame.setStartRowNumber("3");
        battleshipGame.validateStartRowNumber();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }

	@Test(expected = NullPointerException.class)
    public void validateStartRowNumber_Invalid() throws NullPointerException {

        String expectedValue = "passed";
        
        battleshipGame.setStartRowNumber("15");
        battleshipGame.validateStartRowNumber();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void validateStartColumnLetter_Valid() {

        String expectedValue = "passed";
        
        battleshipGame.setStartColumnLetter("B");
        battleshipGame.validateStartColumnLetter();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }

    @Test(expected = NullPointerException.class)
    public void validateStartColumnLetter_Invalid() throws Exception {

        String expectedValue = "passed";
        
        battleshipGame.setStartColumnLetter("P");
        battleshipGame.validateStartColumnLetter();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void validatePlacementLetter_Vertical() {
    	
        String expectedValue = "passed";
        
        battleshipGame.setPlacementLetter("V");
        battleshipGame.validatePlacementLetter();
        String actualValue = "passed";
		
		assertEquals(expectedValue, actualValue);
    }

    @Test
    public void validatePlacementLetter_Horizontal() {
    	
        String expectedValue = "passed";
        
        battleshipGame.setPlacementLetter("H");
        battleshipGame.validatePlacementLetter();
        String actualValue = "passed";
		
		assertEquals(expectedValue, actualValue);
    }

    @Test(expected = NullPointerException.class)
    public void validatePlacementLetter_Invalid() throws Exception {
    	
        String expectedValue = "passed";
        
        battleshipGame.setPlacementLetter("F");
        battleshipGame.validatePlacementLetter();
        String actualValue = "passed";
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void validatePlayerName_Match() {
    	
        String expectedValue = "passed";
        
        battleshipGame.setName("Steven");
        battleshipGame.validatePlayerName();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = NullPointerException.class)
    public void validatePlayerName_Empty() throws Exception {
    	
        String expectedValue = "passed";
        
        battleshipGame.setName(null);
        battleshipGame.validatePlayerName();
        String actualValue = "passed";
        
		assertEquals(expectedValue, actualValue);
    }
}
