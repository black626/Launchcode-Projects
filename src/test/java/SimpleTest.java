import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:13 AM
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
