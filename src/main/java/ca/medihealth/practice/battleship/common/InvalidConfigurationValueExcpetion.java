package ca.medihealth.practice.battleship.common;

/**
 * 
 * @author Steven Yan
 *
 * This customized inherits Exception used for specific cases 
 * When inputting invalid numbers of configuration data for the game, this exception will be thrown
 */
public class InvalidConfigurationValueExcpetion extends Exception {

	private static final long serialVersionUID = 5449056652051252919L;

	public InvalidConfigurationValueExcpetion(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidConfigurationValueExcpetion(String message)
    {
        super(message);
    }
}
