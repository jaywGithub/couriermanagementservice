package za.ac.cput.jayson.repositories;

//import org.junit.Assert;
//import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.jayson.App;
import za.ac.cput.jayson.domain.branch.Branch;
import za.ac.cput.jayson.domain.branch.BranchAddress;
import za.ac.cput.jayson.factories.branch.BranchFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JAYSON on 2016-08-25.
 */
//@EnableAutoConfiguration
//@ComponentScan("test.builder")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestBranchCrud extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    BranchRepository repo;

    BranchAddress branchAddress;

    @BeforeMethod
    public void setUp()throws Exception
    {}

    @Test
    public void testCreate() throws Exception {

        HashMap<String, String> values = new HashMap<>();
        values.put("name", "Durban");
        Branch branch = BranchFactory.getBranch(values, branchAddress);

        repo.save(branch);
        id = branch.getId();

        Assert.assertNotNull(branch.getId());
    }

        /*BranchAddress address = new BranchAddress.Builder()X
                .cityName("Durban")
                .areaName("Beach")
                .areaCode("9000")
                .build();

        Branch branch = new Branch.Builder()
                .name("KingShaka")
                .branchAddress(address)
                .build();

        Branch b = BranchFactory.getBranch(branch.getName(), address);
        repo.save(branch);
        id = b.getId();
        Assert.assertNotNull(id);
    }*/
    @Test(dependsOnMethods = "testCreate")
    public void testRead()throws Exception {
        Branch branch = repo.findOne(id);
        Assert.assertEquals("Durban", branch.getName());
    }
    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {
        Branch branch = repo.findOne(id);
        Branch newBranch = new Branch.Builder()
                .copy(branch)
                .name("Bloemfontein")
                .build();
        repo.save(newBranch);
        Assert.assertEquals("Bloemfontein", newBranch.getName());
    }
    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        Branch branch = repo.findOne(id);
        repo.delete(branch);
        Branch b = repo.findOne(id);
        Assert.assertNull(b);
    }

}
