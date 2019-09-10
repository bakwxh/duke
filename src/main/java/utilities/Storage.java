package utilities;

import exceptions.DukeException;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.Todo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author bakwxh
 * @version 0.1
 */
public class Storage {
	/**
	 * Path to save file.
	 */
	private String filePath;

	/**
	 * Constructor.
	 * @param filePath Path to save file.
	 */
	public Storage(final String filePath) {
		this.filePath = filePath;
		assert filePath.isEmpty();
	}

	/**
	 * Saves memory to file.
	 * @param tasks utilities.TaskList.tasks.Task list.
	 * @throws DukeException Exceptions.
	 */
	public void saveMemory(final TaskList tasks) throws DukeException {
		ArrayList<Task> memory = tasks.getMemory();
		String dir = System.getProperty("user.dir") + "/savedData.txt";
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(dir));
		} catch (IOException e1) {
			throw new DukeException("Error saving data.");
		}
		for (Task t : memory) {
			try {
				out.write(t.toSave() + "\n");
			} catch (IOException e) {
				throw new DukeException("Error saving data.");
			}
		}
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			throw new DukeException("Error saving data.");
		}
	}

	/**
	 * Loads from save file.
	 * @return Returns array list with saved tasks.
	 * @throws DukeException Exceptions.
	 */
	public ArrayList<Task> load() throws DukeException {
		ArrayList<Task> taskList = new ArrayList<>();
		try {
			FileInputStream test = new FileInputStream(filePath);
			Scanner sc = new Scanner(test);
			while (sc.hasNextLine()) {
				String rawInput = sc.nextLine();
				if (rawInput.toLowerCase().startsWith("done")) {
					String procInput = rawInput.substring(4);
					if (procInput.toLowerCase().startsWith("todo")) {
						taskList.add(new Todo(procInput.substring(5)));
					} else if (procInput.toLowerCase().startsWith("deadline")) {
						String[] deadlineInput = procInput.substring(9).split("/by");
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
						taskList.add(new Deadline(deadlineInput[0].trim(), sdf.parse(deadlineInput[1].trim())));
					} else if (procInput.toLowerCase().startsWith("event")) {
						String[] eventInput = procInput.substring(6).split("/at");
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
						taskList.add(new Event(eventInput[0].trim(), sdf.parse(eventInput[1].trim())));
					}
					taskList.get(taskList.size() - 1).markAsDone();
				} else if (rawInput.toLowerCase().startsWith("todo")) {
					taskList.add(new Todo(rawInput.substring(5)));
				} else if (rawInput.toLowerCase().startsWith("deadline")) {
					String[] deadlineInput = rawInput.substring(9).split("/by");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
					taskList.add(new Deadline(deadlineInput[0].trim(), sdf.parse(deadlineInput[1].trim())));
				} else if (rawInput.toLowerCase().startsWith("event")) {
					String[] eventInput = rawInput.substring(6).split("/at");
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HHmm");
					taskList.add(new Event(eventInput[0].trim(), sdf.parse(eventInput[1].trim())));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			File newData = new File(filePath);
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(newData);
				fos.flush();
				fos.close();
			} catch (IOException e1) {
				throw new DukeException("Save file creation failed");
			}
		} catch (ParseException e) {
			throw new DukeException("Save file timings corrupted");
		}
		return taskList;
	}
}