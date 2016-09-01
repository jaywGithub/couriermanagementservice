package za.ac.cput.jayson.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.jayson.App;
import za.ac.cput.jayson.domain.employee.Employee;
import za.ac.cput.jayson.factories.employee.EmployeeFactory;

/**
 * Created by JAYSON on 2016-08-29.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestEmployeeCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    EmployeeRepository repo;

    @BeforeMethod
    public void setUp()throws Exception
    {}

    @Test
    public void testCreate() throws Exception {

        Employee employee = new Employee.Builder()
                .name("Jayson")
                .surname("Peters")
                .license("C1")
                .build();

        Employee e = EmployeeFactory.getEmployee(employee.getName(), employee.getSurname(), employee.getLicense());
        repo.save(e);
        id = e.getId();
        Assert.assertNotNull(id);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()throws Exception {
        Employee employee = repo.findOne(id);
        Assert.assertEquals("Jayson", employee.getName());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Employee employee = repo.findOne(id);
        Employee newEmployee = new Employee.Builder()
                .copy(employee)
                .name("George")
                .build();
        repo.save(newEmployee);
        Assert.assertEquals("George", newEmployee.getName());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Employee employee = repo.findOne(id);
        repo.delete(employee);
        Employee e = repo.findOne(id);
        Assert.assertNull(e);
    }

}
