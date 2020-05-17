package ca.medihealth.practice.battleship.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.medihealth.practice.battleship.common.FireResult;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class FireResultTest {

    @Test
    public void getValue_HIT() {
    	
        String expectedValue = "Hit";
        String actualValue = FireResult.HIT.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_MISS() {
    	
        String expectedValue = "Miss";
        String actualValue = FireResult.MISS.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
}
