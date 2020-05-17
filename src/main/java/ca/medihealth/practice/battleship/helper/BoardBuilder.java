package ca.medihealth.practice.battleship.helper;

import ca.medihealth.practice.battleship.common.Constants;
import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.model.Board;

/**
 * 
 * @author Steven Yan
 *
 * This is a utility class for building a board. 
 */
public class BoardBuilder {

	private Board board = new Board();
	public void buildBoard() throws InvalidConfigurationValueExcpetion {
		
		int lastRowNumber =  Constants.LAST_ROW_NUMBER;
		char lastColumnLetter = Constants.LAST_COLUMN_LETTER;
	    
		int[] rowNumbers = BuilderHelper.buildBoardRowNumbers(lastRowNumber);
		String[] columnLetters = BuilderHelper.buildBoardColumnLetters(lastColumnLetter);
		
		this.board.setColumnLetters(columnLetters);
		this.board.setRowNumbers(rowNumbers);
		
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
}
