package za.ac.cput.jayson.factories.employee;

//import org.junit.*;
import za.ac.cput.jayson.domain.employee.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class TestEmployeeFactory {
    @Test
    public void testRegular() throws Exception
    {
        /*RegularDriver regularDriver = new RegularDriver();
        regularDriver.setLicense("B");

        Assert.assertEquals(regularDriver.getLicense(), "B");*/

        Employee employee = new Employee.Builder()
                .name("Joe")
                .build();

        Assert.assertEquals(employee.getName(), "Joe");
    }
}
