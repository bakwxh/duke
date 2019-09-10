package utilities;

import tasks.Task;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Ui {
	final static String breakLine = "_____________________________________________________\n";
	/**
	 * Pointer to tasklist object.
	 */
	private TaskList tasks;

	/**
	 * Error from unidentified command.
	 */
	public String showLoadingError() {
		return breakLine
				+ " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
				+ breakLine;
	}

	/**
	 * Shows thrown exception.
	 * @param e Exception.
	 */
	public String showException(Exception e) {
		return breakLine
				+ " ☹ OOPS!!! " + e.toString() + "\n"
				+ breakLine;
	}

	/**
	 * Shows logo and intro.
	 */
	public String logoAndIntro() {
		String logo = "  _____            _        \n"
                + " |   __  \\ _     _|  |  _    __ \n"
                + " |  |   |  |  |   |  |  |/ /  / _ \\\n"
                + " |  |__|  |  |__|  |      V   __/\n"
                + " |_____/ \\___,_|__|\\__\\___|\n";
        return "Hello from\n"
				+ logo
				+ breakLine
				+ " Hello! I'm Duke\n What can I do for you?\n"
				+ breakLine;
	}

	/**
	 * @return String for saying goodbye.
	 */
	public String printBye() {
		return breakLine
				+ " Bye. Hope to see you again soon!\n"
				+ breakLine;
	}

	/**
	 * Shows list of tasks.
	 */
	public String printList() {
		return breakLine
				+ " Here are the tasks in your list:\n"
				+ tasks.list()
				+ breakLine;
	}

	/**
	 * Sets pointer to Duke tasklist.
	 * @param tasks Tasklist.
	 */
	public void setTaskList(TaskList tasks) {
		this.tasks = tasks;
	}

	/**
	 * Shows done task.
	 * @param index Index of done task.
	 */
	public String printDone(int index) {
		return breakLine + " Nice! I've marked this task as done:\n   "
				+ tasks.getMemory().get(index).showTask() + "\n"
				+ breakLine + "\n";
	}

	/**
	 * Shows deleted task.
	 * @param t Deleted task.
	 */
	public String printDeleted(Task t) {
		String tasksLeft;
		if (tasks.getMemory().size() == 1) {
			tasksLeft = " Now you have 1 task in your list";
		} else {
			tasksLeft = " Now you have " + tasks.getMemory().size() + " tasks in your list.";
		}
		return breakLine
				+ " Noted. I've removed this task:\n   "
				+ t.showTask() + "\n"
				+ breakLine;
	}

	/**
	 * Shows added task.
	 */
	public String printAdded() {
		String tasksLeft;
		if (tasks.getMemory().size() == 1) {
			tasksLeft = " Now you have 1 task in your list";
		} else {
			tasksLeft = " Now you have " + tasks.getMemory().size() + " tasks in your list.";
		}
		return breakLine
				+ " Got it. I've added this task:\n   "
				+ tasks.listLatest() + "\n"
				+ breakLine;
	}
	
	/**
	 * Displays list of tasks containing keyword.
	 * @param keyword Keyword.
	 */
	public String printFind(String keyword) {
		return breakLine
				+ " Here are the matching tasks in your list:\n"
				+ tasks.keywordList(keyword) + "\n"
				+ breakLine;
	}
}
