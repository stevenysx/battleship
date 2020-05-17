package ca.medihealth.practice.battleship.helper;
import java.util.List;

import ca.medihealth.practice.battleship.common.FireResult;
import ca.medihealth.practice.battleship.common.ShipStatus;
import ca.medihealth.practice.battleship.model.Player;

/**
 * 
 * @author Steven Yan
 *
 * This is a utility class. The Game Referee can checking which player is the winner and verify the fire result
 */
public class GameReferee {
	
	/**
	 * find who is the winner
	 * @return a Player or null as no winner found
	 */
	public static Player findLoser() {
		
		Player loser = null;
		List<Player> players = Registry.getInstance().getPlayers();
		for (Player player : players) {
			
			if (player.getAssignedBoard().getShips().stream().filter(s -> s.getShipStatus() == ShipStatus.SUNK).findAny().isPresent()){
				loser = player;
			}
		}
		
		return loser;
	}
	
	public static FireResult checkFireResult(String targetCoordinate, Player opponentPlayer) {
		
		return opponentPlayer.getAssignedBoard()
							 .getShips()
							 .get(0)  // only one player only has one ship in this game 
							 .getFireResultAfterOpponentHit(targetCoordinate);
	}
}
