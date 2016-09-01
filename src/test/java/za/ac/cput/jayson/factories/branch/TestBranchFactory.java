package za.ac.cput.jayson.factories.branch;

//import org.junit.*;
import junit.framework.TestCase;
import za.ac.cput.jayson.domain.branch.Branch;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.jayson.domain.branch.BranchAddress;

import java.util.HashMap;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class TestBranchFactory extends TestCase {

    BranchAddress branchAddress;

    public TestBranchFactory(){}

    @Test
    public void testCreate()
    {
        HashMap<String, String>values = new HashMap<>();
        values.put("name", "Kimberley");
        Branch branch = BranchFactory.getBranch(values, branchAddress);

        Assert.assertEquals(branch.getName(), "Kimberley");
    }
}
