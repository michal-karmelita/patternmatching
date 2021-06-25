import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnhancedTypeChecking {


//rozszerzenie zakresu "obsługiwanych" typów
    @Test
    public void extendedSelectorExpressionTest() {
//        Object o = Month.JANUARY;
        Object o = new int[]{1, 2, 3};
        switch (o) {
            case String s -> System.out.println("String");
            case Month m -> System.out.println("Month: " + m.label);
            case MyClass mc -> System.out.println("My class");
            case int[] intArray -> System.out.println("Int array: " + intArray.length);
            default -> System.out.println("Something else");
        }
    }

    class MyClass{}


    @Test
    public void dominanceOfPatternLabels() {
        Object o = 4;
        switch(o) {
//            case Number n -> System.out.println("A Number");
            case Integer i -> System.out.println("An Integer");
            default -> System.out.println("Something else");
        }
    }





}
