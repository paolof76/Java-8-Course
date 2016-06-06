package ch.diso.defaults;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticInterfaceTest {

    @Test
    public void test() {
        assertEquals("toDublin", TicketOffice.defaultOffice().qDublin());
    }

    public interface TicketOffice {
        String qDublin();

        static TicketOffice defaultOffice() {
            return () -> "toDublin";
        }
    }

}