package za.ac.cput.jayson.factories.transport;

import za.ac.cput.jayson.domain.transport.Transport;

/**
 * Created by JAYSON on 2016-04-03.
 */
public class TransportFactory {

    /*public static String getTransport(String medium)
    {
        Transport chain = setUpChain();
        return chain.handleRequest(medium);
    }

    public static Regular setUpChain()
    {
        Regular regular = new Regular();
        Express1 express1 = new Express1();
        Express2 express2 = new Express2();

        regular.setNextMedium(express1);
        express1.setNextMedium(express2);

        return regular;
    }*/

    public static Transport getTransport(String type)
    {
        return new Transport.Builder()
                .type(type)
                .build();
    }
}
