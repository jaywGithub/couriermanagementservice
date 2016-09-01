package za.ac.cput.jayson.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.jayson.domain.employee.Employee;

/**
 * Created by JAYSON on 2016-08-28.
 */
public class EmployeeResource extends ResourceSupport {

    private Long resId;
    private String name;
    private String surname;
    private String license;

    public EmployeeResource(String n, String sn, String l){
        name = n;
        surname = sn;
        license = l;
    }

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

    public String getLicense()
    {
        return license;
    }

    public EmployeeResource(EmployeeResource.Builder builder)
    {
        this.resId = builder.resId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.license = builder.license;
    }

    public static class Builder
    {
        private Long resId;
        private String name;
        private String surname;
        private String license;

        public EmployeeResource.Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public EmployeeResource.Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public EmployeeResource.Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public EmployeeResource.Builder license(String value)
        {
            this.license = value;
            return this;
        }

        public EmployeeResource.Builder copy(EmployeeResource value)
        {
            this.resId = value.resId;
            this.name = value.name;
            this.surname = value.surname;
            this.license = value.license;

            return this;
        }

        public EmployeeResource build()
        {
            return new EmployeeResource(this);
        }
    }

}
