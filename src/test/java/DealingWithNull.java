import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DealingWithNull {

    @Test()
    public void switchWithNullTest() {
        Month month = null;
        assertThrows(NullPointerException.class, () -> switchMonth(month));
    }

    private void switchMonth(Month month) {
//        if (null == month) {
//            return;
//        }
        switch (month) {
            case JANUARY:
            case FEBRUARY:
            case MARCH:
                System.out.println("cold");
                break;
            case APRIL:
            case MAY:
            case JUNE:
                System.out.println("nasty weather, but don't have to scrape ice off the car");
                break;
            case JULY:
            case AUGUST:
                System.out.println("hot");
                break;
            case SEPTEMBER:
                System.out.println("raining");
                break;
            case OCTOBER:
            case NOVEMBER:
            case DECEMBER:
                System.out.println("raining and cold again");
                break;
            default:
                System.out.println("nasty weather");
        }
    }

    @Test
    public void newSwitchWithNullTest() {
        Month month = null;
        assertThrows(NullPointerException.class, () -> newSwitchMonth(month));
    }

    private void newSwitchMonth(Month month) {
        switch (month) {
//            case null -> System.out.println("null!");
            case JANUARY, FEBRUARY, MARCH -> System.out.println("cold");
            case APRIL, MAY, JUNE -> System.out.println("nasty weather, but don't have to scrape ice off the car");
            case JULY, AUGUST -> System.out.println("hot");
            case SEPTEMBER -> System.out.println("raining");
            case OCTOBER, DECEMBER -> System.out.println("raining and cold again");
            case Object o -> System.out.println("there is no NPE!"); //total pattern
//            default -> System.out.println("nasty weather"); //To maintain backward compatibility with the current semantics of switch, the default label does not match a null selector
        }
    }

    @Test
    public void labelFormsArisingFromNullTest() {
        Object o = null;
        switch(o) {
            case null: case String s:
            System.out.println("String or null");
                break;
            default:
                break;
        }

        switch(o) {
            case null, String s -> System.out.println("String or null");
            default -> {break;}
        }

        switch(o) {
            case String s -> System.out.println("String");
            case null, default -> System.out.println("The rest (including null)");
        }
    }

}
