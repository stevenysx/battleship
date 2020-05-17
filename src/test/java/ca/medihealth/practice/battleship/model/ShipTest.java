package ca.medihealth.practice.battleship.model;
import static org.junit.Assert.assertEquals;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

import ca.medihealth.practice.battleship.common.FireResult;
import ca.medihealth.practice.battleship.common.OverLimitExcpetion;
import ca.medihealth.practice.battleship.common.ShipStatus;
import ca.medihealth.practice.battleship.common.ShipType;
import ca.medihealth.practice.battleship.model.Ship;

/**
 * 
 * @author Steven Yan
 *
 * Unit test class
 */
public class ShipTest {

	private Ship ship;
	
    @Before
    public void initTest() throws Exception {

    	ship = new Ship(ShipType.CURISER.getShipLength());

    	String shipUnitCoordinate1 = "B4";
    	String shipUnitCoordinate2 = "B5";
    	String shipUnitCoordinate3 = "B6";
    	
        this.ship.addShipUnitCoordinate(shipUnitCoordinate1);
        this.ship.addShipUnitCoordinate(shipUnitCoordinate2);
        this.ship.addShipUnitCoordinate(shipUnitCoordinate3);
    }

    @Test
    public void addShipUnitCoordinate_RightSize() throws OverLimitExcpetion {
    	
    	
        int expectedValue = 3;
        
        int actualValue = this.ship.getShipUnitsCoordinates().size();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test(expected = OverLimitExcpetion.class)
    public void addShipUnitCoordinate_OverSize() throws OverLimitExcpetion {
    	
    	String shipUnitCoordinate4 = "B7";
    	
        int expectedValue = 3;
        this.ship.addShipUnitCoordinate(shipUnitCoordinate4);

        int actualValue = this.ship.getShipUnitsCoordinates().size();
		
		assertEquals(expectedValue, actualValue);
    }

    @Test
    public void addShipUnitCoordinate_CorrectCoordiantes() throws OverLimitExcpetion {
    	
        String expectedValue = "B4,B5,B6";

        String actualValue = this.ship.getShipUnitsCoordinates().stream().collect(Collectors.joining(","));
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getFireResultAfterOpponentHit_Hit() {
    	
        int expectedValue = 2;
        
		// fire "B4" by opponent
        String fireCoordiante = "B4";
        this.ship.getFireResultAfterOpponentHit(fireCoordiante);
        
        int actualValue = this.ship.getShipUnitsCoordinates().size();
		
		assertEquals(expectedValue, actualValue);
    }
    
    @Test
    public void getFireResultAfterOpponentHit_Miss() {
    	
    	int expectedValue = 3;
    	FireResult expectedResult = FireResult.MISS;
    	
		// fire "C4" by opponent
        String fireCoordiante = "C4";
        FireResult actualResult = this.ship.getFireResultAfterOpponentHit(fireCoordiante);
        
        int actualValue = this.ship.getShipUnitsCoordinates().size();

		assertEquals(expectedValue, actualValue);
		assertEquals(expectedResult, actualResult);
    }
    
    @Test
    public void getFireResultAfterOpponentHit_Sunk() {
        
    	int expectedValue = 0;
    	ShipStatus expectedStatus = ShipStatus.SUNK;
        
		// fire "B4", "B5", "B6" by opponent
        String fireCoordiante1 = "B4";
        String fireCoordiante2 = "B5";
        String fireCoordiante3 = "B6";
        
        this.ship.getFireResultAfterOpponentHit(fireCoordiante1);
        this.ship.getFireResultAfterOpponentHit(fireCoordiante2);
        this.ship.getFireResultAfterOpponentHit(fireCoordiante3);
        
        int actualValue = this.ship.getShipUnitsCoordinates().size();
        ShipStatus actualStatus = this.ship.getShipStatus();
        
        assertEquals(expectedValue, actualValue);
        assertEquals(expectedStatus, actualStatus);
    }
}
