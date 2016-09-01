package za.ac.cput.jayson.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.jayson.domain.transport.Transport;

/**
 * Created by JAYSON on 2016-08-28.
 */
public class TransportResource extends ResourceSupport {

    private Long resId;
    private String type;

    public TransportResource(String t){
        type = t;
    }

    public Long getResId()
    {
        return resId;
    }

    public String getType()
    {
        return type;
    }

    public TransportResource(TransportResource.Builder builder)
    {
        this.resId = builder.resId;
        this.type = builder.type;
    }

    public static class Builder
    {
        private Long resId;
        private String type;

        public TransportResource.Builder resId(Long value)
        {
            this.resId = value;
            return this;
        }

        public TransportResource.Builder type(String value)
        {
            this.type = value;
            return this;
        }

        public TransportResource.Builder copy(TransportResource value)
        {
            this.resId = value.resId;
            this.type = value.type;

            return this;
        }

        public TransportResource build()
        {
            return new TransportResource(this);
        }
    }

}
