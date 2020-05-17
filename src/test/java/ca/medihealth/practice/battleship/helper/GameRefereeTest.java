package ca.medihealth.practice.battleship.helper;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.FireResult;
import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.common.ShipPlacement;
import ca.medihealth.practice.battleship.helper.GameReferee;
import ca.medihealth.practice.battleship.helper.Registry;
import ca.medihealth.practice.battleship.helper.ShipBuilder;
import ca.medihealth.practice.battleship.model.Board;
import ca.medihealth.practice.battleship.model.Player;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class GameRefereeTest {
    
	Player opponentPlayer; 
	Player currentPlayer;
	
	@Before
    public void initTest() throws Exception {

		String currentPlayerName = "Steven";
		ShipPlacement currentPlayerShipPlacement = ShipPlacement.VERTICAL; 
		String currentPlayerShipStartColumnLetter = "E"; 
		int currentPlayerShipStartRowNumber = 5;
		currentPlayer = createPlayer(currentPlayerName, currentPlayerShipPlacement, currentPlayerShipStartColumnLetter, currentPlayerShipStartRowNumber);
		Registry.getInstance().addPlayer(currentPlayer);
		
		String opponentPlayerName = "John";
		ShipPlacement opponentPlayerShipPlacement = ShipPlacement.VERTICAL; 
		String opponentPlayerShipStartColumnLetter = "C"; 
		int opponentPlayerShipStartRowNumber = 5;
		opponentPlayer = createPlayer(opponentPlayerName, opponentPlayerShipPlacement, opponentPlayerShipStartColumnLetter, opponentPlayerShipStartRowNumber);
		Registry.getInstance().addPlayer(opponentPlayer);
	}

    @Test
    public void findLoser_Found() throws Exception {
    	
        String targetCoordinate1 = "C5";
        String targetCoordinate2 = "C6";
        String targetCoordinate3 = "C7";
        
        GameReferee.checkFireResult(targetCoordinate1, opponentPlayer);        
        GameReferee.checkFireResult(targetCoordinate2, opponentPlayer);        
        GameReferee.checkFireResult(targetCoordinate3, opponentPlayer);   
        Player loser = GameReferee.findLoser();

        resetData();
		assertNotNull(loser);
    }
    
    @Test
    public void findLoser_NotFound() throws Exception {
    	
    	resetData();
    	String targetCoordinate1 = "C5";
        String targetCoordinate2 = "C6";
        String targetCoordinate3 = "B8";
        
        GameReferee.checkFireResult(targetCoordinate1, opponentPlayer);        
        GameReferee.checkFireResult(targetCoordinate2, opponentPlayer);        
        GameReferee.checkFireResult(targetCoordinate3, opponentPlayer);   
        Player loser = GameReferee.findLoser();
		
		assertNull(loser);
    }
    
    @Test
    public void checkFireResult_Hit() throws Exception {
    	
    	FireResult expectedResult = FireResult.HIT;
    	
        String targetCoordinate1 = "C5";
        String targetCoordinate2 = "C6";
        String targetCoordinate3 = "C7";
        
        FireResult actualResult1 = GameReferee.checkFireResult(targetCoordinate1, opponentPlayer);        
		assertEquals(expectedResult, actualResult1);

        FireResult actualResult2 = GameReferee.checkFireResult(targetCoordinate2, opponentPlayer);        
		assertEquals(expectedResult, actualResult2);

        FireResult actualResult3 = GameReferee.checkFireResult(targetCoordinate3, opponentPlayer);        
		assertEquals(expectedResult, actualResult3);
    	resetData();
    }

    @Test
    public void checkFireResult_Miss() throws Exception {
    	
    	FireResult expectedResult = FireResult.MISS;
    	
        String targetCoordinate = "B5";
        
        FireResult actualResult1 = GameReferee.checkFireResult(targetCoordinate, opponentPlayer);        
		assertEquals(expectedResult, actualResult1);
		resetData();
    }
    
    // Reset testing data for some testing data still stored in memory in other tests
    private void resetData() throws Exception {
    	
    	Registry.getInstance().cleanPlayers();
    }
    
    private Player createPlayer(String name, ShipPlacement placement, String startColumnLetter, int startRowNumber) throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
    	
		Player player = new Player(name);
		
		ShipBuilder shipBuilder = new ShipBuilder();	
		if (placement == ShipPlacement.HORIZONTAL) {

			shipBuilder.buildShipInBoardHorizontally(startColumnLetter.charAt(0), startRowNumber);
		}
		else {

			try {
				
				shipBuilder.buildShipInBoardVertically(Integer.valueOf(startRowNumber), startColumnLetter);
			} catch (NumberFormatException | InvalidConfigurationValueExcpetion | OverLimitExcpetion e) {
				
				e.printStackTrace();
			}
		}
		
		shipBuilder.buildBoard();
		Board board = shipBuilder.getBoard();
		player.setAssignedBoard(board);
		
		return player;
    }
}
