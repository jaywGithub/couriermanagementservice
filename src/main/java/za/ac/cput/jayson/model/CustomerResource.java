package za.ac.cput.jayson.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.jayson.domain.customer.Customer;
import za.ac.cput.jayson.domain.customer.CustomerAddress;

import javax.persistence.Embedded;

/**
 * Created by JAYSON on 2016-08-28.
 */
public class CustomerResource extends ResourceSupport {

    private Long resId;
    private String name;
    private String surname;
    private String contactNumber;
    private CustomerAddress customerAddress;

    public CustomerResource(){}

    public Long getResId()
    {
        return resId;
    }

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public CustomerAddress getCustomerAddress()
    {
        return customerAddress;
    }

    public CustomerResource(CustomerResource.Builder builder)
    {
        this.resId = builder.resId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.contactNumber = builder.contactNumber;
        this.customerAddress = builder.customerAddress;
    }

    public static class Builder
    {
        private Long resId;
        private String name;
        private String surname;
        private String contactNumber;
        private CustomerAddress customerAddress;

        public CustomerResource.Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public CustomerResource.Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public CustomerResource.Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public CustomerResource.Builder contactNumber(String value)
        {
            this.contactNumber = value;
            return this;
        }

        public CustomerResource.Builder customerAddress(CustomerAddress value)
        {
            this.customerAddress = value;
            return this;
        }

        public CustomerResource.Builder copy(CustomerResource value)
        {
            this.resId = value.resId;
            this.name = value.name;
            this.surname = value.surname;
            this.contactNumber = value.contactNumber;
            this.customerAddress = value.customerAddress;

            return this;
        }

        public CustomerResource build()
        {
            return new CustomerResource(this);
        }
    }

}
