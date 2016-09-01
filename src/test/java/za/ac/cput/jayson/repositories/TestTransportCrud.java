package za.ac.cput.jayson.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.jayson.App;
import za.ac.cput.jayson.domain.transport.Transport;
import za.ac.cput.jayson.factories.transport.TransportFactory;

/**
 * Created by JAYSON on 2016-08-29.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestTransportCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    TransportRepository repo;

    @BeforeMethod
    public void setUp()throws Exception
    {}

    @Test
    public void testCreate() throws Exception {

        Transport transport = new Transport.Builder()
                .type("Regular")
                .build();

        Transport t = TransportFactory.getTransport(transport.getType());
        repo.save(t);
        id = t.getId();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()throws Exception {
        Transport transport = repo.findOne(id);
        Assert.assertEquals("Regular", transport.getType());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Transport transport = repo.findOne(id);
        Transport newTransport = new Transport.Builder()
                .copy(transport)
                .type("Express1")
                .build();
        repo.save(newTransport);
        Assert.assertEquals("Express1", newTransport.getType());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Transport transport = repo.findOne(id);
        repo.delete(transport);
        Transport t = repo.findOne(id);
        Assert.assertNull(t);
    }

}
