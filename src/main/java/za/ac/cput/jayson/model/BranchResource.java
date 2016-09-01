package za.ac.cput.jayson.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.jayson.domain.branch.Branch;
import za.ac.cput.jayson.domain.branch.BranchAddress;

/**
 * Created by JAYSON on 2016-08-27.
 */
public class BranchResource extends ResourceSupport {

    private Long resId;
    private String name;
    private BranchAddress branchAddress;

    public BranchResource(){}

    public Long getResId()
    {
        return resId;
    }

    public String getName()
    {
        return name;
    }

    public BranchAddress getBranchAddress()
    {
        return branchAddress;
    }

    public BranchResource(BranchResource.Builder builder)
    {
        this.resId = builder.resId;
        this.name = builder.name;
        this.branchAddress = builder.branchAddress;
    }

    public static class Builder
    {
        private Long resId;
        private String name;
        private BranchAddress branchAddress;

        public BranchResource.Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public BranchResource.Builder name(String value)
        {
            this.name = value;
            return this;
        }

        public BranchResource.Builder branchAddress(BranchAddress value)
        {
            this.branchAddress = value;
            return this;
        }

        public BranchResource.Builder copy(BranchResource value)
        {
            this.resId = value.resId;
            this.name = value.name;
            this.branchAddress = value.branchAddress;

            return this;
        }

        public BranchResource build()
        {
            return new BranchResource(this);
        }
    }

}
