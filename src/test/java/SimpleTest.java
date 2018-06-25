import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: mpmenne (edits by Dylan Black)
 * Date: 6/18/14 (6/17/18)
 * Time: 3:13 AM (8:09 PM)
 */
public class SimpleTest {

    @Test
    public void testOneEqualsOne() {
        assertEquals(1, 1);
    }

    @Test
    public void testStringOneEqualsStringTwo() {
        assertEquals("one", "one");
    }

}
