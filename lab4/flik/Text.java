package flik;
import org.junit.Test;
import static org.junit.Assert.*;
public class Text {
    @Test
    public void onetohundred(){
        for (int i = 128; i < 135; i += 1) {
            assertTrue(Flik.isSameNumber(i, i));
        }
    }
}
