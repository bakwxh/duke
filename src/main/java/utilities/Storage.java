package utilities;

import exceptions.DukeException;
import tasks.Task;

import java.io.*;
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

	public Storage(final String filePath) {
		this.filePath = filePath;
		assert filePath.isEmpty();
	}

	/**
	 * Saves memory to file.
	 * @param tasks utilities.TaskList.tasks.Task list.
	 * @throws DukeException Exceptions.
	 */
	public void saveMemory(TaskList tasks) throws DukeException {
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
		Parser parser = new Parser();
		try {
			FileInputStream test = new FileInputStream(filePath);
			Scanner sc = new Scanner(test);
			while (sc.hasNextLine()) {
				String rawInput = sc.nextLine();
				String command = parser.getCommand(rawInput);
				switch (command) {
					case "done":
						String doneTask = command.substring(5);
						Task newDoneTask = parser.generateTask(doneTask);
						taskList.add(newDoneTask);
						taskList.get(taskList.size() - 1).markAsDone();
						break;
					case "todo":
					case "deadline":
					case "event":
						Task newTask = parser.generateTask(rawInput);
						taskList.add(newTask);
						break;
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
		}
		return taskList;
	}
}