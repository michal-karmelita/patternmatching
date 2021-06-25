import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatternMatchingSwitch {

    @Test
    public void patternMatchingSwitchTest() {
        Object someObject = 2;
        Object result = null;
        switch (someObject) {
            case Integer i:
                result = i;
                break;
            case Long l:
                result = l;
                break;
            case Double d:
                result = d;
                break;
            default:
                result =  "something else";
        }
        assertEquals( 2, result);
    }

    @Test
    public void patternMatchingSwitchArrowTest() {
        Object someObject = 1;
        String result = switch (someObject) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            default -> "something else";
        };
        assertEquals("int 1", result);
    }

//    Enhanced type checking
//    Completeness of switch expressions and statements
//    Scope of pattern variable declarations
//    Dealing with null
}
