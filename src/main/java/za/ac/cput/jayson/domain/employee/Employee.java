package za.ac.cput.jayson.domain.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-03.
 */
/*public abstract class Employee {

    private String name;
    private String surname;
    private String license;

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    public String getLicense()
    {
        return license;
    }
}*/

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String license;

    public Employee(){}

    public Employee(String n, String sn, String l){
        name = n;
        surname = sn;
        license = l;
    }

    public Long getId()
    {
        return id;
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

    public Employee(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.license = builder.license;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private String surname;
        private String license;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public Builder surname(String value)
        {
            this.surname = value;
            return this;
        }

        public Builder license(String value)
        {
            this.license = value;
            return this;
        }

        public Builder copy(Employee value)
        {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.license = value.license;

            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return id != null ? id.equals(employee.id) : employee.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

