package tasks;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Task {
	private String description;
    private boolean isDone;

    /**
     * Constructs task with input description.
     * @param description Description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
    	return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Returns a string of the tasks status icon and its description.
     * @return Display format of task.
     */
    public String showTask() {
    	return "[" + getStatusIcon() + "] " + description;
    }

    public void markAsDone() {
    	isDone = true;
    }

    public String getDesc() {
    	return this.description;
    }

    public boolean getDone() {
    	return this.isDone;
    }

    /**
     * Returns the task as a string in a format to save in .txt.
     * Implemented for children tasks to override.
     * @return Placeholder return, returns task description.
     */
    public String toSave() {
        return this.description;
    }
}
