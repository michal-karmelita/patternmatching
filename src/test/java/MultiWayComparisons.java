import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultiWayComparisons {

    @Test
    public void switchJava13Test() {
        Month month = Month.JANUARY;
        String commentary;
        switch (month) {
            case JANUARY:
            case FEBRUARY:
            case MARCH:
                commentary = "cold";
                break;
            case APRIL:
            case MAY:
            case JUNE:
                commentary = "nasty weather, but don't have to scrape ice off the car";
                break;
            case JULY:
            case AUGUST:
                commentary = "hot";
                break;
            case SEPTEMBER:
                commentary = "raining";
                break;
            case OCTOBER:
            case DECEMBER:
                commentary = "raining and cold again";
                break;
            default:
                commentary = "nasty weather";
        }
        assertEquals("cold", commentary );

    }

    //since Java 14 (JEP 361: Switch Expressions)
    //"These changes will simplify everyday coding, and prepare the way for the use of pattern matching in switch"
    @Test
    public void testswitchJava14Test() {
        Month month = Month.JANUARY;
        String commentary;
        switch (month) {
            case JANUARY, FEBRUARY, MARCH -> commentary = "cold";
            case APRIL, MAY, JUNE -> commentary = "nasty weather, but don't have to scrape ice off the car";
            case JULY, AUGUST -> commentary = "hot";
            case SEPTEMBER -> commentary = "raining";
            case OCTOBER, DECEMBER -> commentary = "raining and cold again";
            default -> commentary = "nasty weather";
        }
        assertEquals("cold", commentary);
    }
}
