package ca.medihealth.practice.battleship.helper;

import java.util.ArrayList;
import java.util.List;

import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.model.Player;

/**
 * 
 * @author Steven Yan
 *
 * This is a Sigleton class used for registering players in the game
 * In this game, it only allows two players playing together
 */
public class Registry {
	
	private static List<Player> players = new ArrayList<Player>();
	private static Player currentPlayer;
	
	private static Registry registry;
    static{
    	registry = new Registry(); 
    }
     
    private Registry(){
     
    }
     
    public static Registry getInstance(){

    	return registry;
    }
     
    public void addPlayer(Player player) throws OverLimitExcpetion{
    	if (players.size() == 2) {
    		throw new OverLimitExcpetion("Only 2 players can be regitered into the game. Players can start the game now");
    	}
    	players.add(player);
    }

    public List<Player> getPlayers() {
    	
    	return players;
    }
    
    public Player getCurrentPlayer() {
    	
    	if (currentPlayer == null) {
    		
    		int FIRST_PLAYER_POS = 0;
    		currentPlayer = players.get(FIRST_PLAYER_POS);
    	}
    	return currentPlayer;
    }
    
    public Player getOpponentPlayer() {
    	
    	if (currentPlayer == null) {

    		int FIRST_PLAYER_POS = 0;	
    		currentPlayer = players.get(FIRST_PLAYER_POS);
    	}
    	
    	for(Player player : players) {
    	
    		if (!player.getName().equalsIgnoreCase(currentPlayer.getName())) {
    	
    			return player;
    		}
    	}
    	return null;
    }
    
    public void setCurrentPlayer(Player player) {
    	
    	currentPlayer = player;
    }
    
    // for unit test to reset test data only
    void cleanPlayers() {
    	
    	players = new ArrayList<Player>();
    	currentPlayer = null;
    }
}
