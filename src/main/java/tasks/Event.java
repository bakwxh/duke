package tasks; /**
 * @author bakwxh
 * @version 0.1
 */
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Event extends Task {
	/**
	 * At time.
	 */
	private Date at;

    /**
     * Constructor.
     * @param description Description.
     * @param at At time.
     */
    public Event(final String description, final Date at) {
        super(description);
        this.at = at;
    }

    /**
     * Shows task.
     */
    @Override
    public String showTask() {
        return "[E]" + super.showTask() + " (at: " + at.toString() + ")";
    }

    /**
     * Returns at time.
     * @return At time.
     */
    public Date getAt() {
    	return this.at;
    }

    /**
     * Shows task as its saving format.
     * @return utilities.TaskList.tasks.Task as its saving format.
     */
    public String toSave() {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
    	String atString = sdf.format(at);
    	if (super.getDone()) {
    		return "doneevent " + super.getDesc() + " /at " + atString;
    	} else {
    		return "event " + super.getDesc() + " /at " + atString;
    	}
    }
}
