package za.ac.cput.jayson.factories.branch;

import za.ac.cput.jayson.domain.branch.Branch;
import za.ac.cput.jayson.domain.branch.BranchAddress;

import java.util.Map;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class BranchFactory {

    /*private static Branch firstInstance = null;

    private BranchFactory(){}

    public static Branch getInstance()
    {
        if(firstInstance == null)
        {
            firstInstance = new Branch();
        }

        return firstInstance;
    }*/

    public static Branch getBranch(Map<String, String>values, BranchAddress branchAddress)
    {
        return new Branch.Builder()
                .name(values.get("name"))
                .branchAddress(branchAddress)
                .build();
    }
}
