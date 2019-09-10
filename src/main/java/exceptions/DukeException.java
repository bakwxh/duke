package exceptions;

/**
 * @author bakwxh
 * @version 0.1
 */
public class DukeException extends Exception {
	/**
	 * Constructor.
	 * @param message Exception message.
	 */
	public DukeException(final String message) {
		super(message);
	}

	/**
	 * Removes "exceptions.DukeException: " from start of message.
	 */
	@Override public String toString() {
		String temp = super.toString();
		return temp.substring(15);
	}
}
