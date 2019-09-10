import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import utilities.Parser;

/**
 * @author bakwxh
 * @version 0.1
 */
class ParserTest {
	/**
	 * utilities.Parser Test.
	 */
	@Test
	void test() {
		Parser parser = new Parser();
		String output = parser.getCommand("todo die");
		assertEquals("todo", output);
	}

}
