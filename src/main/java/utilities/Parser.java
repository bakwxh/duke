package utilities;

import exceptions.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Parser {
	/**
	 * Retrieve command from user input.
	 * @param rawInput Raw input from user.
	 * @return The command found in rawInput.
	 */
	public String getCommand(final String rawInput) {
		if (rawInput.toLowerCase().equals("bye")) {
			return "bye";
		} else if (rawInput.toLowerCase().equals("list")) {
			return "list";
		} else if (rawInput.toLowerCase().startsWith("todo")) {
			return "todo";
		} else if (rawInput.toLowerCase().startsWith("done")) {
			return "done";
		} else if (rawInput.toLowerCase().startsWith("find")) {
			return "find";
		} else if (rawInput.toLowerCase().startsWith("event")) {
			return "event";
		} else if (rawInput.toLowerCase().startsWith("delete")) {
			return "delete";
		} else if (rawInput.toLowerCase().startsWith("deadline")) {
			return "deadline";
		} else {
			return "none";
		}
	}

	/**
	 * Process data from done command.
	 * @param rawInput Raw user input.
	 * @return Index of task that is done.
	 * @throws DukeException Exceptions.
	 */
	public int processDone(final String rawInput) throws DukeException {
		try {
			return Integer.parseInt(rawInput.split(" ")[1].trim()) - 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("Please indicate which task is done.");
		}
	}

	/**
	 * Process data from delete command.
	 * @param rawInput Raw user input.
	 * @return Index of task that is deleted.
	 * @throws DukeException Exceptions;
	 */
	public int processDelete(final String rawInput) throws DukeException {
		try {
			return Integer.parseInt(rawInput.split(" ")[1].trim()) - 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("Please indicate which task to delete.");
		}
	}

	/**
	 * Process description of deadline task.
	 * @param rawInput Raw user input.
	 * @return Description of deadline.
	 * @throws DukeException Exceptions.
	 */
	public String deadlineDesc(final String rawInput) throws DukeException {
		try {
			return rawInput.substring(9).split("/by")[0].trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of a deadline cannot be empty.");
		}
	}

	/**
	 * Process time of deadline task.
	 * @param rawInput Raw user input.
	 * @return Time of deadline.
	 * @throws DukeException Exceptions.
	 */
	public Date deadlineTime(final String rawInput) throws DukeException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
			return sdf.parse(rawInput.substring(9).split("/by")[1].trim());
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("The timing of a deadline cannot be empty.");
		} catch (ParseException e) {
			throw new DukeException("The timing of the event is invalid.");
		}
	}

	/**
	 * Process description of event task.
	 * @param rawInput Raw user input.
	 * @return Description of event.
	 * @throws DukeException Exceptions.
	 */
	public String eventDesc(final String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).split("/at")[0].trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of an event cannot be empty.");
		}
	}

	/**
	 * Process time of event task.
	 * @param rawInput Raw user input.
	 * @return Time of event.
	 * @throws DukeException Exceptions.
	 */
	public Date eventTime(final String rawInput) throws DukeException {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
			return sdf.parse(rawInput.substring(9).split("/at")[1].trim());
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("The timing of an event cannot be empty.");
		} catch (ParseException e) {
			throw new DukeException("The timing of the event is invalid.");
		}
	}

	/**
	 * Process description of to-do task.
	 * @param rawInput Raw user input.
	 * @return Description of to-do.
	 * @throws DukeException Exceptions.
	 */
	public String todoDesc(final String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of a todo cannot be empty.");
		}
	}

	/**
	 * Returns keyword for find operation.
	 * @param rawInput Raw user input.
	 * @return Find keyword.
	 * @throws DukeException Exceptions.
	 */
	public String processFind(final String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The keyword for find cannot be empty.");
		}
	}
}
