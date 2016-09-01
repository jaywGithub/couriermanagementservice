package za.ac.cput.jayson.factories.customer;

//import org.junit.*;
import za.ac.cput.jayson.domain.customer.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class TestCustomerFactory {
    @Test
    public void testCustomer()throws Exception
    {
        Customer customer = new Customer.Builder()
                .name("Jayson")
                .build();

        Assert.assertEquals(customer.getName(), "Jayson");
    }
}
