package rest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import javax.sound.midi.SysexMessage;

import org.junit.Test;

import dev.hv.rest.model.RCustomer;
import dev.hv.rest.model.RReading;

public class RReadingTest {

    @Test
    public void NoArgsTest() {
        RReading reading = new RReading();

        assertEquals(reading.getMeterID(), 0);
        assertEquals(reading.getMeterCount(), 0);
        assertNull(reading.getComment());
        assertNull(reading.getDateOfReading());
        assertNull(reading.getKindOfMeter());
        assertNull(reading.getCustomer());
    }
    
    @Test
    public void NoCustomerReadingTest() {
        RCustomer customer = new RCustomer();
        customer.setCustomerID(0);
        customer.setFirstName(null);
        customer.setLastName(null);

        Date date = new Date(System.currentTimeMillis());
        RReading reading = new RReading(1, "No Customer", date.toString(), "Water", 200.00, customer);

        assertEquals(reading.getMeterID(), 1);
        assertEquals(reading.getComment(), "No Customer");
    }

    @Test
    public void AllArgsTest() {
        Date date = new Date(System.currentTimeMillis());
        RCustomer customer = new RCustomer(1, "John", "Mustermann");
        RReading reading = new RReading(101, "Comment", date.toString(), "Electric", 123.45, customer);

        assertEquals(reading.getCustomer().getCustomerID(), 1);
        assertEquals(reading.getCustomer().getFirstName(), "John");
        assertEquals(reading.getCustomer().getLastName(), "Mustermann");

        assertEquals(reading.getMeterID(), 101);
        assertEquals(reading.getComment(), "Comment");
        assertEquals(reading.getDateOfReading(), date.toString());
        assertEquals(reading.getKindOfMeter(), "Electric");
        //assertEquals(reading.getMeterCount(), 123.45);
    }

    @Test
    public void ConstructorAndGetterTests() {
        Date date = new Date(System.currentTimeMillis());
        RCustomer customer = new RCustomer();
        
        customer.setCustomerID(1);
        customer.setFirstName("John");
        customer.setLastName("Doe");

        RReading reading = new RReading(1, "Comment", date.toString(), "Electric", 123.45, customer);
    
        assertEquals(reading.getMeterID(), 1);
        assertEquals(reading.getComment(), "Comment");
        assertEquals(reading.getDateOfReading(), date.toString());
        assertEquals(reading.getKindOfMeter(), "Electric");
        assertEquals(reading.getMeterCount(), 123.45);

        assertNotNull(reading.getCustomer());
        assertEquals(reading.getCustomer().getCustomerID(), 1);
        assertEquals(reading.getCustomer().getFirstName(), "John");
        assertEquals(reading.getCustomer().getLastName(), "Doe");
    }

}
