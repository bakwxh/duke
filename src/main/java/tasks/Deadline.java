package tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Deadline extends Task {
	/**
	 * By time of deadline.
	 */
	private Date by;

    /**
     * Constructor.
     * @param description Description.
     * @param by By time.
     */
    public Deadline(final String description, final Date by) {
        super(description);
        this.by = by;
    }

    /**
     * Shows task.
     */
    @Override
    public String showTask() {
        return "[D]" + super.showTask() + " (by: " + by.toString() + ")";
    }

    /**
     * Shows task as its saving format.
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

    /**
     * Returns by time.
     * @return By time.
     */
    public Date getBy() {
    	return this.by;
    }
}
