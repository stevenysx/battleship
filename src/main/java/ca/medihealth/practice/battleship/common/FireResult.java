package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This enum class provides 2 fire results, 
 * Hit: hit the ship of the opponent
 * Miss: missed the target, the ship of the opponent
 */
public enum FireResult {
	
    HIT("Hit"), 
    MISS("Miss");
  
    private String fireResult;

    private FireResult(String value) {

        this.fireResult = value;
    }

    public String getValue() {

        return this.fireResult;
    }  
}
