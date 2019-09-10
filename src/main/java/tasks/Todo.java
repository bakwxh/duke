package tasks;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Todo extends Task {
	/**
	 * Constructor.
	 * @param description Description.
	 */
	public Todo(String description) {
        super(description);
    }

    /**
     * Shows task type and task description.
     * @return Display format of to-do.
     */
    @Override
    public String showTask() {
        return "[T]" + super.showTask();
    }

    /**
     * Returns a string of the task in format
     * for saving the task to a .txt file.
     * @return Save format of to-do.
     */
    @Override
    public String toSave() {
    	if (super.getDone()) {
    		return "donetodo " + super.getDesc();
    	} else {
    		return "todo " + super.getDesc();
    	}
    }
}
