import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CompletenessOfPatternLabels {

    @Test
    public void completenessOfPatternLabelsTest() {
        assertEquals(3, returnIntFromSwitch("ala"));
        assertEquals(3,returnIntFromSwitch(3));
        assertThrows(RuntimeException.class, () -> returnIntFromSwitch(Boolean.TRUE));
    }

    private int returnIntFromSwitch(Object o) {
        return switch (o){
            case String s -> s.length();
            case Integer i -> i;
            default -> throw new RuntimeException("Returnign int isn't possible");
        };
    }

    interface Everything{}
    sealed interface Aircraft extends Everything permits Plane, Helicopter {}
    final class Plane implements Aircraft{}
    final class Helicopter implements Aircraft{}

    @Test
    public void completenessOfPatternLabelsSealedTest() {
        assertEquals("Plane", returnSealedFromSwitch(new Plane()));
    }

    private String returnSealedFromSwitch(Aircraft aircraft) {
        return switch (aircraft){
            case Plane p -> "Plane";
//            case Helicopter h -> "Helicopter";
//            case Integer i -> "oops";
//            case Object o -> "Total pattern";
            case Everything e -> "Total pattern";
        };
    }
}
