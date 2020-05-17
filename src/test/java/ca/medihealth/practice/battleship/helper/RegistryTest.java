package ca.medihealth.practice.battleship.helper;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.helper.Registry;
import ca.medihealth.practice.battleship.model.Player;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class RegistryTest {

	private Player player1;
	private Player player2;
	private Player player3;
	
    @Before
    public void initTest() throws Exception {
    	
    	player1 = new Player("Steven");
    	player2 = new Player("John");
    	player3 = new Player("Rick");
    }
    
    @Test
    public void addPlayer_2Players() throws OverLimitExcpetion {
    	
    	Registry.getInstance().addPlayer(player1);
    	Registry.getInstance().addPlayer(player2);
    	
        int expectedValue = 2;
        int actualValue = Registry.getInstance().getPlayers().size();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = OverLimitExcpetion.class)
    public void addPlayer_3Players() throws Exception {
    	
    	Registry.getInstance().addPlayer(player1);
    	Registry.getInstance().addPlayer(player2);
    	Registry.getInstance().addPlayer(player3);
    }
    
    @Test
    public void getCurrentPlayer_FirstPlayer() throws Exception {

    	resetData();
    	Registry.getInstance().addPlayer(player1);
    	Registry.getInstance().addPlayer(player2);
    	
        String expectedValue = "Steven";
        String actualValue = Registry.getInstance().getCurrentPlayer().getName();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getCurrentPlayer_ChangeSecondtPlayerAsCurrent() throws Exception {
    	
    	resetData();
    	Registry.getInstance().addPlayer(player1);
    	Registry.getInstance().addPlayer(player2);
    	Registry.getInstance().setCurrentPlayer(player2);

    	String expectedValue = "John";
        String actualValue = Registry.getInstance().getCurrentPlayer().getName();
		
		assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOpponentPlayer_AsSecondtPlayer() throws Exception {
    	
    	resetData();
    	Registry.getInstance().addPlayer(player1);
    	Registry.getInstance().addPlayer(player2);

    	String expectedValue = "John";
        String actualValue = Registry.getInstance().getOpponentPlayer().getName();
		
		assertEquals(expectedValue, actualValue);
    }
    
    // Reset testing data for some testing data still stored in memory in other tests
    private void resetData() throws Exception {
    	
    	Registry.getInstance().cleanPlayers();
    	initTest();
    }
}
