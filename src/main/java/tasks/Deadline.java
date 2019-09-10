package tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Deadline extends Task {
	/**
	 * The time the deadline must be completed by.
	 */
	private Date by;

    /**
     * Constructs a deadline task with the given description,
     * and the time it must be completed by.
     * @param description Description.
     * @param by Time to be completed by.
     */
    public Deadline(String description, Date by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string of the type of task,
     * description, as well as the deadline of the task.
     * @return Display format of deadline.
     */
    @Override
    public String showTask() {
        return "[D]" + super.showTask() + " (by: " + by.toString() + ")";
    }

    /**
     * Returns a string of the task in format
     * for saving the task to a .txt file.
     * @return Save format of deadline.
     */
    @Override
    public String toSave() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    	String byString = sdf.format(by);
    	if (super.getDone()) {
    		return "donedeadline " + super.getDesc() + " /by " + byString;
    	} else {
    		return "deadline " + super.getDesc() + " /by " + byString;
    	}
    }

    public Date getBy() {
    	return this.by;
    }
}
