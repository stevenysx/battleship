package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This customized inherits Exception used for specific cases
 * When adding more than specific numbers of players, this exception will be thrown in this game 
 * When adding a ship's unit coordinates over its total units, this exception will be thrown in this game
 */
public class OverLimitExcpetion extends Exception {

	private static final long serialVersionUID = 919155809302758344L;

	public OverLimitExcpetion(String message, Throwable cause)
    {
        super(message, cause);
    }

    public OverLimitExcpetion(String message)
    {
        super(message);
    }
}
