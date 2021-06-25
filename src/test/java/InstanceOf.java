import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstanceOf {

    @Test
    public void instanceOfJava15Test() {
        Object koala = "koala";
        String ala = null;
        if (koala instanceof String) {
            String koalaString = (String) koala;
            ala = koalaString.substring(koalaString.length() - 3);
//            ala = koala.substring(koala.length() - 3);

        }
        assertEquals("ala", ala );
    }

    //sice Java 16:JEP 394: Pattern Matching for instanceof; Java 14: JEP 305: Pattern Matching for instanceof (Preview)
    @Test
    public void instanceOfJava16Test() {
        Object koala = "koala";
        String ala = null;
        if (koala instanceof String koalaString) {
            ala = koalaString.substring(koalaString.length() - 3);
        }
        assertEquals("ala", ala );
    }

    //plusy: możemy dopasowywać do typu, minusy: konieczność tworzenia długich (błędogennych) łańcuchów if-else

}
