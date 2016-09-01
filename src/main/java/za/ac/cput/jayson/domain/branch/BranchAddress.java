package za.ac.cput.jayson.domain.branch;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by JAYSON on 2016-08-18.
 */

@Embeddable
public class BranchAddress implements Serializable {

    private String cityName;
    private String areaName;
    private String areaCode;

    public BranchAddress(){}

    public String getCityName()
    {
        return cityName;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public BranchAddress(Builder builder)
    {
        this.cityName = builder.cityName;
        this.areaName = builder.areaName;
        this.areaCode = builder.areaCode;
    }

    public static class Builder {
        private String cityName;
        private String areaName;
        private String areaCode;

        public Builder cityName(String value) {
            this.cityName = value;
            return this;
        }

        public Builder areaName(String value) {
            this.areaName = value;
            return this;
        }

        public Builder areaCode(String value) {
            this.areaCode = value;
            return this;
        }

        public Builder copy(BranchAddress value) {
            this.cityName = value.cityName;
            this.areaName = value.areaName;
            this.areaCode = value.areaCode;

            return this;
        }

        public BranchAddress build()
        {
            return new BranchAddress(this);
        }
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchAddress branchAddress = (BranchAddress) o;

        return id != null ? id.equals(branchAddress.id) : branchAddress.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }*/
}

