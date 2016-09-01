package za.ac.cput.jayson.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.jayson.domain.transport.Transport;
import za.ac.cput.jayson.services.TransportService;

import java.util.List;

/**
 * Created by JAYSON on 2016-08-28.
 */

@RestController
public class TransportController {

    @Autowired
    private TransportService transportService;

    //-------------------Create Transport--------------------------------------------------------

    @RequestMapping(value = "/transport/", method = RequestMethod.POST)
    public ResponseEntity<Void> createTransport(@RequestBody Transport transport, UriComponentsBuilder ucBuilder) {
        transportService.save(transport);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/transport/{id}").buildAndExpand(transport.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Transport--------------------------------------------------------
    @RequestMapping(value = "/transport/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transport> getTransport(@PathVariable("id") long id) {
        Transport transport = transportService.findById(id);
        if (transport == null) {
            return new ResponseEntity<Transport>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transport>(transport, HttpStatus.OK);
    }


    //-------------------Retrieve All Transport--------------------------------------------------------

    @RequestMapping(value = "/transport/", method = RequestMethod.GET)
    public ResponseEntity<List<Transport>> getTransports() {
        List<Transport> transports = transportService.findAll();
        if(transports.isEmpty()){
            return new ResponseEntity<List<Transport>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Transport>>(transports, HttpStatus.OK);
    }

    //------------------- Update Transport --------------------------------------------------------

    @RequestMapping(value = "/transport/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Transport> updateTransport(@PathVariable("id") long id, @RequestBody Transport transport) {

        Transport currentTransport = transportService.findById(id);

        if (currentTransport==null) {
            return new ResponseEntity<Transport>(HttpStatus.NOT_FOUND);
        }
        Transport updatedTransport = new Transport.Builder().copy(currentTransport)
                .type(transport.getType())
                .build();
        transportService.update(updatedTransport);
        return new ResponseEntity<Transport>(updatedTransport, HttpStatus.OK);
    }

    //------------------- Delete Transport --------------------------------------------------------

    @RequestMapping(value = "/transport/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Transport> deleteTransport(@PathVariable("id") long id) {
        Transport transport = transportService.findById(id);
        if (transport == null) {
            return new ResponseEntity<Transport>(HttpStatus.NOT_FOUND);
        }
        transportService.delete(transport);
        return new ResponseEntity<Transport>(HttpStatus.NO_CONTENT);
    }

}
