package ca.medihealth.practice.battleship.model;

/**
 * 
 * @author Steven Yan
 *
 * This POJO class describes the a player's basic information
 * name: the player's name
 * assignedBoard: once a player registers the Battleship game, a board will be built and assigned to the player
 * the number of times that the player hit the opponent's ship. 
 */
public class Player {

	private String name;
	private Board assignedBoard;
	
	public Player(String playerName) {
		super();
		this.name = playerName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Board getAssignedBoard() {
		return assignedBoard;
	}

	public void setAssignedBoard(Board assignedBoard) {
		this.assignedBoard = assignedBoard;
	}
}
