import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import tasks.Todo;

/**
 * @author bakwxh
 * @version 0.1
 */
class TodoTest {
	/**
	 * To Do Test.
	 */
	@Test
	void test() {
		Todo todo = new Todo("test");
		String testing = todo.toSave();
		String result = "todo test";
		assertEquals(result, testing);
	}

}
