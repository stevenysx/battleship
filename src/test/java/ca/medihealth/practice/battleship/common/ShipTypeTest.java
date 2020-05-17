package ca.medihealth.practice.battleship.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ca.medihealth.practice.battleship.common.ShipType;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class ShipTypeTest {
	
    @Test
    public void getValue_Cruiser() {
    	
        String expectedValue = "Cruiser";
        String actualValue = ShipType.CURISER.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getLength_Cruiser() {
    	
        int expectedValue = 3;
        int actualValue = ShipType.CURISER.getShipLength();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_Destroyer() {
    	
        String expectedValue = "Destroyer";
        String actualValue = ShipType.DESTROYER.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getLength_Destroyer() {
    	
        int expectedValue = 2;
        int actualValue = ShipType.DESTROYER.getShipLength();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_Submarine() {
    	
        String expectedValue = "Submarine";
        String actualValue = ShipType.SUBMARINE.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getLength_Submarine() {
    	
        int expectedValue = 3;
        int actualValue = ShipType.SUBMARINE.getShipLength();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_Battleship() {
    	
        String expectedValue = "Battleship";
        String actualValue = ShipType.BATTLESHIP.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getLength_Battleship() {
    	
        int expectedValue = 4;
        int actualValue = ShipType.BATTLESHIP.getShipLength();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getValue_Carrier() {
    	
        String expectedValue = "Carrier";
        String actualValue = ShipType.CARRIER.getValue();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getLength_Carrier() {
    	
        int expectedValue = 5;
        int actualValue = ShipType.CARRIER.getShipLength();
		
		assertEquals(expectedValue, actualValue);
    }
}
