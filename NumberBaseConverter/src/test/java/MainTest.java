import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testGetHexFromNum() {
        assertEquals("0", Main.getHexFromNumber(0));
        assertEquals("1", Main.getHexFromNumber(1));
        assertEquals("A", Main.getHexFromNumber(10));
        assertEquals("B", Main.getHexFromNumber(11));
        assertEquals("C", Main.getHexFromNumber(12));
        assertEquals("D", Main.getHexFromNumber(13));
        assertEquals("E", Main.getHexFromNumber(14));
        assertEquals("F", Main.getHexFromNumber(15));
    }
}
