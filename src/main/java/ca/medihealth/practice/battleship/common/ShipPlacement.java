package ca.medihealth.practice.battleship.common;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author Steven Yan
 *
 * This enum class provides 2 ship direction to be placed, 
 * Vertical: placed in a column in the board
 * Horizontal: placed in a row in the board
 */
public enum ShipPlacement {
	
    VERTICAL("Vertical"), 
    HORIZONTAL("Horizontal");

    private String shipPlacement;

    private ShipPlacement(String value) {

        this.shipPlacement = value;
    }

    public String getValue() {

        return this.shipPlacement;
    }
    
    public static ShipPlacement fromValue(final String placementLetter) throws InvalidConfigurationValueExcpetion {

        if(!StringUtils.isBlank(placementLetter) && (placementLetter.equalsIgnoreCase("v") || placementLetter.equalsIgnoreCase("h"))) {

            for(ShipPlacement placement : ShipPlacement.values()) {
    
                if(placement.shipPlacement.toLowerCase().charAt(0) == placementLetter.toLowerCase().charAt(0)) {
    
                    return placement;
                }
            }
        }

        throw new InvalidConfigurationValueExcpetion("Incorrect placement direction character '" 
        			+ placementLetter + "' is not supported. Only 'v' or 'h' can be selected");
    }  
}
