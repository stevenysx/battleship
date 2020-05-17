package ca.medihealth.practice.battleship.common;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.InvalidConfigurationValueExcpetion;
import ca.medihealth.practice.battleship.common.ShipPlacement;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class ShipPlacementTest {

    @Test
    public void getValue_VERTICAL() {
    	
        String expectedValue = "Vertical";
        String actualValue = ShipPlacement.VERTICAL.getValue();
        		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_HORIZONTAL() {
    	
        String expectedValue = "Horizontal";
		String actualValue = ShipPlacement.HORIZONTAL.getValue();

		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void fromValue_HorizontalLetter() throws InvalidConfigurationValueExcpetion {
    	
    	ShipPlacement expectedValue = ShipPlacement.HORIZONTAL;
        ShipPlacement actualValue = ShipPlacement.fromValue("H");
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void fromValue_VerticalLetter() throws InvalidConfigurationValueExcpetion {
    	
    	ShipPlacement expectedValue = ShipPlacement.VERTICAL;
        ShipPlacement actualValue = ShipPlacement.fromValue("V");
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected=InvalidConfigurationValueExcpetion.class)
    public void fromValue_HandleExeption() throws InvalidConfigurationValueExcpetion {
    	
    	ShipPlacement expectedValue = ShipPlacement.VERTICAL;
        ShipPlacement actualValue = ShipPlacement.fromValue("W");
		
		assertEquals(expectedValue, actualValue);
    }
}
