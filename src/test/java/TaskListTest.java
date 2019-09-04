import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author bakwxh
 * @version 0.1
 */
class TaskListTest {
	/**
	 * Task List Test.
	 */
	@Test
	void test() {
		TaskList tasklist = new TaskList();
		tasklist.addTodo("test");
		String testing = tasklist.listLatest();
		String result = "[T][" + "\u2718" + "] test";
		assertEquals(result, testing);
	}

}