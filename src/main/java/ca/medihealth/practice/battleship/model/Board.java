package ca.medihealth.practice.battleship.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Steven Yan
 *
 * The POJO class Board contains three properties: 
 * ships: a board can load multiple ships.(In this game, there's only one ship)  
 * rowNumbers: all row number stored sequentially 
 * columnLetters: all column letters stored alphabetically
 * 
 * Board is able to add ships on the board.
 */
public class Board {
	
	private List<Ship> ships = new ArrayList<Ship>();
	private int[] rowNumbers;
	private String[] columnLetters;
	
	public Board() {
		
	}
	
	public List<Ship> getShips() {
		return ships;
	}


	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}


	public int[] getRowNumbers() {
		return rowNumbers;
	}


	public void setRowNumbers(int[] rowNumbers) {
		this.rowNumbers = rowNumbers;
	}


	public String[] getColumnLetters() {
		return columnLetters;
	}


	public void setColumnLetters(String[] columnLetters) {
		this.columnLetters = columnLetters;
	}

	public void addShip(Ship ship) {
		
		this.ships.add(ship);
	}
}
