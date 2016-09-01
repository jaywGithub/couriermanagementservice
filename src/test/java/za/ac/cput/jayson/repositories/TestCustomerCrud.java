package za.ac.cput.jayson.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.jayson.App;
import za.ac.cput.jayson.domain.customer.Customer;
import za.ac.cput.jayson.domain.customer.CustomerAddress;
import za.ac.cput.jayson.factories.customer.CustomerFactory;

/**
 * Created by JAYSON on 2016-08-29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCustomerCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    CustomerRepository repo;

    CustomerAddress customerAddress;

    @BeforeMethod
    public void setUp()throws Exception
    {}

    @Test
    public void testCreate() throws Exception {

    CustomerAddress address = new CustomerAddress.Builder()
                .cityName("Durban")
                .areaName("Beach")
                .areaCode("9000")
                .build();

        Customer customer = new Customer.Builder()
                .name("Jayson")
                .surname("Peters")
                .contactNumber("0621234567")
                .customerAddress(address)
                .build();

        Customer c = CustomerFactory.getCustomer(customer.getName(), customer.getSurname(), customer.getContactNumber(), address);
        repo.save(c);
        id = c.getId();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()throws Exception {
        Customer customer = repo.findOne(id);
        Assert.assertEquals("Jayson", customer.getName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Customer customer = repo.findOne(id);
        Customer newCustomer = new Customer.Builder()
                .copy(customer)
                .name("George")
                .build();
        repo.save(newCustomer);
        Assert.assertEquals("George", newCustomer.getName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Customer customer = repo.findOne(id);
        repo.delete(customer);
        Customer c = repo.findOne(id);
        Assert.assertNull(c);
    }

}
