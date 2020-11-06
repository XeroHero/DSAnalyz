package tk.xerohero;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @Test
    void roundOneDp() throws ParseException {
        double bytes = 856329847;
        double testVal = Calculations.roundOneDp(bytes).doubleValue();
        assertEquals(testVal, 0.8);
    }

    @org.junit.jupiter.api.Test
    void toGB() {
        double gb = Calculations.toGB(49947207);
        assertTrue(gb>0);
    }
}