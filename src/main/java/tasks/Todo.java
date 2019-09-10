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
	public Todo(final String description) {
        super(description);
    }

    /**
     * Shows task.
     */
    @Override
    public String showTask() {
        return "[T]" + super.showTask();
    }

    /**
     * Shows task as its saving format.
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
