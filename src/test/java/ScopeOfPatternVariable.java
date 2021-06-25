
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ScopeOfPatternVariable {

    @Test
    public void scopeOfPatternVariableTest() {
        scopeOfPattern(99);
        assertThrows(RuntimeException.class, () -> scopeOfPatternInSwitch(99));
    }

    private void scopeOfPattern(Object o) {
        if ((o instanceof Integer i) && i >= 0) {
            System.out.println("Non negativ Integer: " + i);
        } else {
            System.out.println("Somenthing else");
        }
    }

    private void scopeOfPatternInSwitch(Object o) {
        switch (o) {
            case String s -> System.out.println(s);
            case CharSequence c -> {
                    if (c.length() > 0) {
                        System.out.println(c);
                    }
                }
            case Integer i -> throw new RuntimeException("Invalid argument: " + i.intValue());
            default -> {
                    break;
                }
        }

    }


    @Test
    public void cantFallThroughPattern() {
        Object o = "someObject";
        switch (o) {
            case String s:
                if (s.length() > 0) {
                    System.out.print("Not empty string " + s);
                }
                break;
            case Integer i:
                 System.out.println("Integer " + i);
            default:
                break;
        }
//        Character c, Integer i ->

    }




}
