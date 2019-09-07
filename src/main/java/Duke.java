import java.util.Scanner;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Duke {
	/**
	 * Storage.Storage object.
	 */
	private Storage storage;
	/**
	 * TaskList.Task list object.
	 */
	private TaskList tasks;
	/**
	 * UI object.
	 */
	private Ui ui;
	/**
	 * Parser object.
	 */
	private Parser parser;
	
    /**
     * Constructor.
     * @param filePath Path to save file.
     */
    public Duke(final String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
        ui.setTaskList(tasks);
        parser = new Parser();
    }

	/**
     * Main run method.
     */
    public String run(String rawInput) {
    	try {
			storage.load();
		} catch (DukeException e) {
			ui.showException(e);
		}

		String command = parser.getCommand(rawInput);
		try {
			if (command.equals("bye")) {
				return ui.printBye();
			} else if (command.equals("list")) {
				return ui.printList();
			} else if (command.equals("find")) {
				return ui.printFind(parser.processFind(rawInput));
			} else if (command.equals("done")) {
				int index = parser.processDone(rawInput);
				tasks.doneTask(index);
				storage.saveMemory(tasks);
				return ui.printDone(index);
			} else if (command.equals("delete")) {
				Task deletedTask = tasks.deleteTask(parser.processDelete(rawInput));
				storage.saveMemory(tasks);
				return ui.printDeleted(deletedTask);
			} else if (command.equals("todo")) {
				tasks.addTodo(parser.todoDesc(rawInput));
				storage.saveMemory(tasks);
				return ui.printAdded();
			} else if (command.equals("deadline")) {
				tasks.addDeadline(parser.deadlineDesc(rawInput), parser.deadlineTime(rawInput));
				storage.saveMemory(tasks);
				return ui.printAdded();
			} else if (command.equals("event")) {
				tasks.addEvent(parser.eventDesc(rawInput), parser.eventTime(rawInput));
				storage.saveMemory(tasks);
				return ui.printAdded();
			} else {
				return ui.showLoadingError();
			}
		} catch (DukeException e) {
			return ui.showException(e);
		}
    }

//	public static void main(String[] args) {
//		String dir = System.getProperty("user.dir") + "/savedData.txt";
//		new Duke(dir).run();
//	}

	/**
	 * You should have your own function to generate a response to user input.
	 * Replace this stub with your completed method.
	 */
	String getResponse(String input) {
	    return run(input);
	}

	public String getIntro() {
		return ui.logoAndIntro();
	}
}