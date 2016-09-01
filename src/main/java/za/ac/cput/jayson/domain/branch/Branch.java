package za.ac.cput.jayson.domain.branch;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by JAYSON on 2016-04-03.
 */
/*public class Branch {

    private String branchName;
    private String areaName;
    private String areaCode;

    public Branch(){}

    public void setBranchName(String branchName)
    {
        this.branchName = branchName;
    }

    public String getBranchName()
    {
        return branchName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }
}*/
//@Table(name = "Branch")
@Entity
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private BranchAddress branchAddress;

    public Branch(){}

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public BranchAddress getBranchAddress()
    {
        return branchAddress;
    }

    public Branch(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.branchAddress = builder.branchAddress;
    }

    public static class Builder
    {
        private Long id;
        private String name;
        private BranchAddress branchAddress;

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

        public Builder branchAddress(BranchAddress value)
        {
            this.branchAddress = value;
            return this;
        }

        public Builder copy(Branch value)
        {
            this.id = value.id;
            this.name = value.name;
            this.branchAddress = value.branchAddress;

            return this;
        }

        public Branch build()
        {
            return new Branch(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return id != null ? id.equals(branch.id) : branch.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

