package za.ac.cput.jayson.factories.customer;

import za.ac.cput.jayson.domain.customer.Customer;
import za.ac.cput.jayson.domain.customer.CustomerAddress;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class CustomerFactory {

    /*private static Customer firstInstance = null;

    private CustomerFactory(){}

    public static Customer getInstance()
    {
        if(firstInstance == null)
        {
            firstInstance = new Customer();
        }

        return firstInstance;
    }*/

    public static Customer getCustomer(String name, String surname, String contactNumber, CustomerAddress customerAddress)
    {
        return new Customer.Builder()
                .name(name)
                .surname(surname)
                .contactNumber(contactNumber)
                .customerAddress(customerAddress)
                .build();
    }
}
