package exceptions;

/**
 * @author bakwxh
 * @version 0.1
 */
public class DukeException extends Exception {
	/**
	 * Constructs a DukeException that prints with inputted message.
	 * @param message Exception message.
	 */
	public DukeException(String message) {
		super(message);
	}

	/**
	 * Removes "exceptions.DukeException: " from start of message,
	 * and returns the message as a string.
	 * @return Exception message as string.
	 */
	@Override public String toString() {
		String temp = super.toString();
		return temp.substring(15);
	}
}
