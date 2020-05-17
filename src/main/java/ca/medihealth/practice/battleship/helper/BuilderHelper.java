package ca.medihealth.practice.battleship.helper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import ca.medihealth.practice.battleship.common.Constants;
import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;

/**
 * 
 * @author Steven Yan
 *
 * This is a utility class. 
 */
public class BuilderHelper {

	public static String[] buildBoardColumnLetters(char lastColumnCharacter) throws InvalidConfigurationValueExcpetion {

		final char FIRST_CHARACTER = 'A';
		final char LAST_VALID_CHARACTER = 'J';
		
		if (((lastColumnCharacter >= Character.toLowerCase(FIRST_CHARACTER) && lastColumnCharacter <= Character.toLowerCase(LAST_VALID_CHARACTER)) 
		  || (lastColumnCharacter >= FIRST_CHARACTER && lastColumnCharacter <= LAST_VALID_CHARACTER))) {
			
			return IntStream.rangeClosed('A', Character.toUpperCase(lastColumnCharacter))
							.mapToObj(c -> "" + (char) c)
							.toArray(String[]::new);		
		}
		String errMessage = String.format("Invalid row letter, it must be a letter between %s and %s in alphabetical order", 
								          FIRST_CHARACTER, 
				                          LAST_VALID_CHARACTER);
		throw new InvalidConfigurationValueExcpetion(errMessage);
	}
	
	public static int[] buildBoardRowNumbers(int lastRowNumber) throws InvalidConfigurationValueExcpetion {
	
		final int FIRST_ROW = 1;
		final int LAST_VALID_ROW = 10;
		
		if (lastRowNumber > LAST_VALID_ROW || lastRowNumber < FIRST_ROW) {
			
			String errMessage = String.format("Invalid colum number, it must be a number from %s to %s", 
									   		  FIRST_ROW, 
									   		  LAST_VALID_ROW);
			throw new InvalidConfigurationValueExcpetion(errMessage);
		}

		return IntStream.range(1, lastRowNumber+=1).toArray();

	}
	
	public static String buildShipCoordiante(String columnLetter, int row) throws InvalidConfigurationValueExcpetion {
		
		if (!isValidColumn(columnLetter) || !isValidRow(row)) {
			
			throw new InvalidConfigurationValueExcpetion("Invalid column letter or row number");
		}
			
		return columnLetter.concat(Integer.toString(row));
	}
	
	public static boolean isValidColumn(String columnLetter) {
		
		
		return columnLetter.matches("[A-Ja-j]{0,1}");
	}
	
	public static boolean isValidRow(int row) {
		
		if (row > 0 && row <= Constants.LAST_ROW_NUMBER) {
			
			return true;
		}
		return false;
	}
	
	public static List<String> getNextLettersAlphabetically(char columnStartLetter, int totalNumberOfLetters) {
		
		List<String> letters = new ArrayList<String>();
		
		for (int i = 0; i < totalNumberOfLetters; i++) {
			
			letters.add(String.valueOf((char) (Character.toUpperCase(columnStartLetter) + i)));
		}
		
		return letters;
	}
	
	public static List<Integer> getNextRowNumbers(int rowStartNumber, int totalNumberOfRows) {
		
		List<Integer> letters = new ArrayList<Integer>();
		
		for (int i = 0; i < totalNumberOfRows; i++) {
			
			letters.add(rowStartNumber + i);
		}
		
		return letters;
	}
//	
//	public static void main(String[] args) throws InvalidConfigurationValueExcpetion {
//		
////		Arrays.stream(helper.buildBoardColumnLetters('j')).forEach(System.out::println);
////		Arrays.stream(helper.buildBoardRowNumbers(5)).forEach(System.out::println);
////Arrays.stream(row).forEach(System.out::println);
////		Arrays.stream(column).forEach(System.out::println);
//		//System.out.println(Constants.SHIP_TYPE_LENGTH);
////		BuilderHelper.getNextLettersAlphabetically('A', 3).forEach(System.out::println);
//		BuilderHelper.getNextRowNumbers(5, 3).forEach(System.out::println);
//	}	
}
