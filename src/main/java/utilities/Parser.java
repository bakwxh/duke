package utilities;

import exceptions.DukeException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Parser {
	/**
	 * Retrieve command from full user input.
	 * @param rawInput User's full from user.
	 * @return The command found in rawInput.
	 */
	public String getCommand(String rawInput) {
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
	 * Used for generating tasks when reading from save file only.
	 * @param rawInput The input from the save file.
	 * @return A task generated using rawInput.
	 * @throws DukeException Exceptions thrown by methods used.
	 */
	public Task generateTask(String rawInput) throws DukeException {
		Task result = null;
		Parser parser = new Parser();
		String taskType = parser.getCommand(rawInput);
		switch (taskType) {
			case "todo":
				result = new Todo(parser.todoDesc(rawInput));
				break;
			case "deadline":
				String deadlineDesc = parser.deadlineDesc(rawInput);
				Date deadlineTime = parser.deadlineTime(rawInput);
				result = new Deadline(deadlineDesc, deadlineTime);
				break;
			case "event":
				String eventDesc = parser.eventDesc(rawInput);
				Date eventTime = parser.eventTime(rawInput);
				result = new Event(eventDesc, eventTime);
				break;
		}
		return result;
	}

	/**
	 * Process data from done command from full user input.
	 * @param rawInput User's full input.
	 * @return Index of task that is done.
	 * @throws DukeException Exceptions.
	 */
	public int processDone(String rawInput) throws DukeException {
		try {
			return Integer.parseInt(rawInput.split(" ")[1].trim()) - 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("Please indicate which task is done.");
		}
	}

	/**
	 * Process data from delete command from full user input.
	 * @param rawInput User's full input.
	 * @return Index of task that is deleted.
	 * @throws DukeException Exceptions;
	 */
	public int processDelete(String rawInput) throws DukeException {
		try {
			return Integer.parseInt(rawInput.split(" ")[1].trim()) - 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DukeException("Please indicate which task to delete.");
		}
	}

	/**
	 * Process description of deadline task from full user input.
	 * @param rawInput User's full input.
	 * @return Description of deadline.
	 * @throws DukeException Exceptions.
	 */
	public String deadlineDesc(String rawInput) throws DukeException {
		try {
			return rawInput.substring(9).split("/by")[0].trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of a deadline cannot be empty.");
		}
	}

	/**
	 * Process time of deadline task from full user input.
	 * @param rawInput User's full input.
	 * @return Time of deadline.
	 * @throws DukeException Exceptions.
	 */
	public Date deadlineTime(String rawInput) throws DukeException {
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
	 * Process description of event task from full user input.
	 * @param rawInput User's full input.
	 * @return Description of event.
	 * @throws DukeException Exceptions.
	 */
	public String eventDesc(String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).split("/at")[0].trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of an event cannot be empty.");
		}
	}

	/**
	 * Process time of event task from full user input.
	 * @param rawInput User's full input.
	 * @return Time of event.
	 * @throws DukeException Exceptions.
	 */
	public Date eventTime(String rawInput) throws DukeException {
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
	 * Process description of to-do task from full user input.
	 * @param rawInput Full user input.
	 * @return Description of to-do.
	 * @throws DukeException Exceptions.
	 */
	public String todoDesc(String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The description of a todo cannot be empty.");
		}
	}

	/**
	 * Returns keyword for find operation from user's full input.
	 * @param rawInput User's full input.
	 * @return Find command's keyword.
	 * @throws DukeException Exceptions.
	 */
	public String processFind(String rawInput) throws DukeException {
		try {
			return rawInput.substring(5).trim();
		} catch (StringIndexOutOfBoundsException e) {
			throw new DukeException("The keyword for find cannot be empty.");
		}
	}
}
