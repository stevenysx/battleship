package ca.medihealth.practice.battleship.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.helper.ShipBuilder;
import ca.medihealth.practice.battleship.model.Board;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class BoardBuilderTest {

    @Test
    public void buildBoard_VerifyRowColumnConfigData() throws InvalidConfigurationValueExcpetion {
    	
    	ShipBuilder builder = new ShipBuilder();
    	builder.buildBoard();
    	Board board = builder.getBoard();
    	
        String expectedRowString = "ABCDEFGH";
        String actualRowString = StringUtils.join(board.getColumnLetters());
        assertEquals(expectedRowString, actualRowString);

        String expectedColumnString = "12345678";
        String actualColumnString = Arrays.stream(board.getRowNumbers())
        								  .mapToObj(String::valueOf)
        								  .collect(Collectors.joining());
        assertEquals(expectedColumnString, actualColumnString);        
    }
}
