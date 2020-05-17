package ca.medihealth.practice.battleship.game;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import ca.medihealth.practice.battleship.common.FireResult;
import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.common.ShipPlacement;
import ca.medihealth.practice.battleship.helper.BuilderHelper;
import ca.medihealth.practice.battleship.helper.GameReferee;
import ca.medihealth.practice.battleship.helper.Registry;
import ca.medihealth.practice.battleship.helper.ShipBuilder;
import ca.medihealth.practice.battleship.model.Board;
import ca.medihealth.practice.battleship.model.Player;

/**
 * 
 * @author Steven Yan
 *
 * This class is the main class of the game. It contains the logic of game rules and steps.
 * Run this class to start the application in the console. Following by the instruction 
 * step by step to play the game until a loser found of which ship's all units hit(destroyed).
 * 
 */
public class BattleshipGame {

	Scanner scanner = null;
	String name;
	String placementLetter;
	String startColumnLetter;
	String startRowNumber;
	String indentSpace = "    ";
	
	/**
	 * Recurse method controls the player registration and game setup for players in order.
	 * The game only allows two players playing together. So, once the second player is registered successfully, 
	 * then the game setup step is completed and recursive call is terminated for moving to play stage.
	 */
	public void setupGame() throws InvalidConfigurationValueExcpetion, OverLimitExcpetion {
	
		// initialize variables
		name = null;
		placementLetter = null;
		startColumnLetter = null;
		startRowNumber = null;
		
		// add a player
		if (Registry.getInstance().getPlayers().size() == 0) {
		
			System.out.println("**********************Welcome to play Battleship Game created by Steven Yan*********************\n\n");
			System.out.println("Registrer the first player to the game, please type in your name:");
		}
		else {
			
			System.out.println("Registrer the second player to the game, please type in your name:");
		}
		if(this.scanner == null) {
			
			this.scanner = new Scanner(System.in); 
		}
		this.name = this.scanner.nextLine();
		this.validatePlayerName();
		Player player = new Player(this.name);
		
		// player choose the placement of a ship for building it, then add it to the board
		System.out.println(indentSpace + "Please type in the ship placement direction(type 'V' for vertical; type 'H' for horizontal):");
		this.placementLetter = this.scanner.nextLine();
		this.validatePlacementLetter();
		
		ShipPlacement placement = ShipPlacement.fromValue(placementLetter );

		// choose the coordinate column letter for placing the ship on the board
		System.out.println(indentSpace + "Please type in the first board column letter to place your ship on the board (select one between 'A' and 'F' to type):");
		this.startColumnLetter = this.scanner.nextLine();
		this.validateStartColumnLetter();

		// choose the coordinate row number for placing the ship on the board
		System.out.println(indentSpace + "Please type in the first board row number to place your ship on the board (select one between 1 and 5 to type):");
		this.startRowNumber = this.scanner.nextLine();

		validateStartRowNumber();
		
		ShipBuilder shipBuilder = new ShipBuilder();	
		if (placement == ShipPlacement.HORIZONTAL) {

			shipBuilder.buildShipInBoardHorizontally(startColumnLetter.charAt(0), Integer.valueOf(startRowNumber));
		}
		else {

			try {
				
				shipBuilder.buildShipInBoardVertically(Integer.valueOf(startRowNumber), startColumnLetter);
			} catch (NumberFormatException | InvalidConfigurationValueExcpetion | OverLimitExcpetion e) {
				
				e.printStackTrace();
			}
		}
		System.out.println(indentSpace + "- Player '" + player.getName() + "' has built a ship successfully and placed as " + ShipPlacement.HORIZONTAL + ".");
		
		// get the board the ship resides on and assign it to the player
		shipBuilder.buildBoard();
		Board board = shipBuilder.getBoard();
		player.setAssignedBoard(board);
		System.out.println(indentSpace + "- Player '" + player.getName() + "' has been assigned a board with a ship to play the game successfully.");
		
		// register the player in Registry
		Registry.getInstance().addPlayer(player);
		System.out.println(indentSpace + "- Player '" + player.getName() + "' has been registered to the game successfully.\n");
		
		if (Registry.getInstance().getPlayers().size() == 2) {
		
			System.out.println("Game setup has been completed successfully. It's ready to play.\n");
			return;
		}
		else {
			
			setupGame();
		}
	}

	/**
	 * Recurse method controls the fire iterations between two players sequentially.
	 * Once a loser is found, then the game is over and recursive call is terminated.
	 * 
	 */
	public void playGame() {
		
		// get a player from Registry to fire
		Player player = Registry.getInstance().getCurrentPlayer();
		System.out.println("\nWelcome " + player.getName() + " to play now.");
		
		// a player input target coordinate on the opponent's board to fire a ship
		System.out.println(indentSpace + "Please type in the target coordiante on your opponent's board(one letter followed by a number on the board):");
		if(scanner == null) {
			
			scanner = new Scanner(System.in); 
		}
		String targetCoordinate = this.scanner.nextLine();
		
		// get opponent player from Registry
		Player opponentPlayer = Registry.getInstance().getOpponentPlayer();
		
		// start to fire a ship on the opponent's board, the game referee check the fire result
		FireResult fireResult = GameReferee.checkFireResult(targetCoordinate, opponentPlayer);
		System.out.println(player.getName() + ", you " + fireResult.getValue() + "!");
		
		// the game referee check if any ship Sunk
		Player loser = GameReferee.findLoser();
		if (loser != null) {
			
			System.out.println(player.getName() + ", you sunk my battleship");
			System.out.println("Congratulation! " + player.getName() + " won the game!\n\n");
			System.out.println("**********************Thank you for your playing Battleship Game. - Steven Yan*********************");
			System.exit(0);
			return;
		}
		else {
			// Change current player to opponent for the next play
			Registry.getInstance().setCurrentPlayer(opponentPlayer);
			playGame();
		}
	}

	void validatePlayerName() {
		
		if (StringUtils.isEmpty(this.name)) {

			System.out.println("Please type in your name:");
			this.name = this.scanner.nextLine();
			if(StringUtils.isEmpty(this.name)) {
				
				validatePlayerName();
			}
		}
	}
	void validatePlacementLetter() {
		
		if (StringUtils.isEmpty(this.placementLetter) || (!this.placementLetter.equalsIgnoreCase("v") && !this.placementLetter.equalsIgnoreCase("h"))) {
			
			System.out.println(indentSpace + "! WRONG LETTER ! Please type in the ship placement direction(type 'V' for vertical; type 'H' for horizontal):");
			this.placementLetter = this.scanner.nextLine();
			
			if (StringUtils.isEmpty(this.placementLetter) || (!this.placementLetter.equalsIgnoreCase("v") && !this.placementLetter.equalsIgnoreCase("h"))) {
			
				validatePlacementLetter();		
			}
		}
	}
	
	void validateStartColumnLetter() {
		
		if (StringUtils.isEmpty(this.startColumnLetter) || !BuilderHelper.isValidColumn(this.startColumnLetter)) {
			
			System.out.println(indentSpace + "! WRONG LETTER ! Please type in the first board column letter to place your ship on the board (select one between 'A' and 'F' to type):");
			this.startColumnLetter = this.scanner.nextLine();
			if (StringUtils.isEmpty(this.startColumnLetter) || !BuilderHelper.isValidColumn(this.startColumnLetter)) {
			
				validateStartColumnLetter();
			}
		}
	}
	
	void validateStartRowNumber() {
		
		if (!NumberUtils.isDigits(this.startRowNumber) || Integer.valueOf(this.startRowNumber) < 1 || Integer.valueOf(this.startRowNumber) > 5) {
			
			System.out.println(indentSpace + "! WRONG NUMBER ! Please type in the first board row number to place your ship on the board (select one between 1 and 5 to type):");
			this.startRowNumber = this.scanner.nextLine();
			if (!NumberUtils.isDigits(this.startRowNumber)) {
			
				validateStartRowNumber();
			}
		}	
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlacementLetter() {
		return placementLetter;
	}

	public void setPlacementLetter(String placementLetter) {
		this.placementLetter = placementLetter;
	}

	public String getStartColumnLetter() {
		return startColumnLetter;
	}

	public void setStartColumnLetter(String startColumnLetter) {
		this.startColumnLetter = startColumnLetter;
	}

	public String getStartRowNumber() {
		return startRowNumber;
	}

	public void setStartRowNumber(String startRowNumber) {
		this.startRowNumber = startRowNumber;
	}

	public static void main(String[] arg) throws InvalidConfigurationValueExcpetion, OverLimitExcpetion  {

		BattleshipGame battleshipGame = new BattleshipGame();
		
		// Set up ship, board for two players
		battleshipGame.setupGame();
		
		// Start play the game
		battleshipGame.playGame();
	}
}
