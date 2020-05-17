package ca.medihealth.practice.battleship.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.ShipType;
import ca.medihealth.practice.battleship.helper.BuilderHelper;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class BuilderHelperTest {
	
    @Before
    public void initTest()
        throws Exception {

    }

    @Test
    public void getNextRowNumbers_Match() {
    	
        int rowStartNumber = 3;
		int totalNumberOfRows = ShipType.CURISER.getShipLength();
		List<Integer> rowNumbers = BuilderHelper.getNextRowNumbers(rowStartNumber, totalNumberOfRows);
		
		String expectedValue = "3,4,5";
		String actualValue = rowNumbers.stream().map(String::valueOf).collect(Collectors.joining(","));
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getNextLettersAlphabetically_Match() {
    	
    	char columnStartLetter = 'C';
		int totalNumberOfLetters = ShipType.CURISER.getShipLength();
		List<String> columnLetters = BuilderHelper.getNextLettersAlphabetically(columnStartLetter, totalNumberOfLetters);
    	
        String expectedValue = "C,D,E";
        String actualValue = columnLetters.stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void isValidRow_True() {
    	
        boolean actualValue = BuilderHelper.isValidRow(5);
		
		assertTrue(actualValue);
    }
    
    @Test
    public void isValidRow_False() {
    	
    	boolean actualValue = BuilderHelper.isValidRow(15);
		
		assertTrue(!actualValue);
    }
    
    @Test
    public void isValidColumn_True() {
    	
        boolean actualValue = BuilderHelper.isValidColumn("C");

		assertTrue(actualValue);
    }

    @Test
    public void isValidColumn_False() {
    	
        boolean actualValue = BuilderHelper.isValidColumn("K");

		assertTrue(!actualValue);
    }
    
    @Test
    public void buildShipCoordiante_Match() throws InvalidConfigurationValueExcpetion {
    	
    	String columnLetter = "C";
		int row = 5;
		
        String expectedValue = "C5";
        String actualValue = BuilderHelper.buildShipCoordiante(columnLetter, row);
		
		assertEquals(expectedValue, actualValue);
    }

    @Test(expected = InvalidConfigurationValueExcpetion.class)
    public void buildShipCoordiante_Error() throws InvalidConfigurationValueExcpetion {
    	
    	String columnLetter = "P";
		int row = 5;
		
        String expectedValue = "P5";
        String actualValue = BuilderHelper.buildShipCoordiante(columnLetter, row);
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void buildBoardRowNumbers_Match() throws InvalidConfigurationValueExcpetion {

    	int lastRowNumber = 8;
		
        String expectedValue = "1,2,3,4,5,6,7,8";
        String actualValue = Arrays.stream(BuilderHelper.buildBoardRowNumbers(lastRowNumber))
                				   .mapToObj(String::valueOf)
                				   .collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = InvalidConfigurationValueExcpetion.class)
    public void buildBoardRowNumbers_Error() throws InvalidConfigurationValueExcpetion {

    	int lastRowNumber = 11;
		
        String expectedValue = "1,2,3,4,5,6,7,8,9,10,11";
        String actualValue = Arrays.stream(BuilderHelper.buildBoardRowNumbers(lastRowNumber))
                				   .mapToObj(String::valueOf)
                				   .collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void buildBoardColumnLetters_Match() throws InvalidConfigurationValueExcpetion {
    	
    	char lastColumnCharacter = 'H';
		
        String expectedValue = "A,B,C,D,E,F,G,H";
        String actualValue = Arrays.stream(BuilderHelper.buildBoardColumnLetters(lastColumnCharacter))
        						   .collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = InvalidConfigurationValueExcpetion.class)
    public void buildBoardColumnLetters_Error() throws InvalidConfigurationValueExcpetion {
    	
    	char lastColumnCharacter = 'K';
		
        String expectedValue = "A,B,C,D,E,F,G,H,I,J,K";
        String actualValue = Arrays.stream(BuilderHelper.buildBoardColumnLetters(lastColumnCharacter))
        						   .collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
}
