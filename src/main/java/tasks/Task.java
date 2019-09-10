package tasks;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Task {
	static String line = "____________________________________________________________";
    /**
     * Description.
     */
    private String description;
    /**
     * Done state.
     */
    private boolean isDone;

    /**
     * Constructor.
     * @param description Description.
     */
    public Task(final String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Retrieves status icon.
     * @return Status Icon.
     */
    public String getStatusIcon() {
    	return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Shows task.
     * @return utilities.TaskList.tasks.Task in string format.
     */
    public String showTask() {
    	return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Marks task as done.
     */
    public void markAsDone() {
    	isDone = true;
    }

    /**
     * Shows task as its saving format.
     * @return utilities.TaskList.tasks.Task in string format for saving purposes.
     */
    public String toSave() {
		return null;
	}

    /**
     * Description.
     * @return Description.
     */
    public String getDesc() {
    	return this.description;
    }

    /**
     * Is done.
     * @return Is done.
     */
    public boolean getDone() {
    	return this.isDone;
    }
}
