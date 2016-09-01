package za.ac.cput.jayson.factories.transport;

//import org.junit.*;
import za.ac.cput.jayson.domain.transport.Transport;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class TestTransportFactory {
    @Test
    public void testTransport()throws Exception
    {
        /*String transportMedium = TransportFactory.getTransport("R");

        Assert.assertEquals(transportMedium, "Regular");*/

        Transport transport = new Transport.Builder()
                .type("regular")
                .build();

        Assert.assertEquals(transport.getType(), "regular");
    }
}
