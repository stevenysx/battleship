package ca.medihealth.practice.battleship.common;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.medihealth.practice.battleship.common.ShipStatus;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class ShipStatusTest {

    @Test
    public void getValue_testAlive() {
    	
        String expectedValue = "Alive";
        String actualValue = ShipStatus.ALIVE.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_Sunk() {
    	
        String expectedValue = "Sunk";
        String actualValue = ShipStatus.SUNK.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
}
