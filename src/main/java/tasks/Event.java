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
	 * The time the event is at.
	 */
	private Date at;

    /**
     * Constructs an event task with the given description,
     * and the time the event is at.
     * @param description Description.
     * @param at Time of event
     */
    public Event(String description, Date at) {
        super(description);
        this.at = at;
    }

    /**
     * Returns a string of the type of task,
     * description, and time of the event.
     * @return Display format of event.
     */
    @Override
    public String showTask() {
        return "[E]" + super.showTask() + " (at: " + at.toString() + ")";
    }

    public Date getAt() {
    	return this.at;
    }

    /**
     * Returns a string of the task in format
     * for saving the task to a .txt file.
     * @return Save format of event.
     */
    @Override
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
