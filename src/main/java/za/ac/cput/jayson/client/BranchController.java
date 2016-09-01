package za.ac.cput.jayson.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.jayson.domain.branch.Branch;
import za.ac.cput.jayson.services.BranchService;

import java.util.List;

/**
 * Created by JAYSON on 2016-08-28.
 */

@RestController
public class BranchController {

    @Autowired
    private BranchService branchService;

    //-------------------Create a Branch--------------------------------------------------------

    @RequestMapping(value = "/branch/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBranch(@RequestBody Branch branch, UriComponentsBuilder ucBuilder) {
        branchService.save(branch);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/branch/{id}").buildAndExpand(branch.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Branch--------------------------------------------------------
    @RequestMapping(value = "/branch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Branch> getBranch(@PathVariable("id") long id) {
        Branch branch = branchService.findById(id);
        if (branch == null) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branch>(branch, HttpStatus.OK);
    }


    //-------------------Retrieve All Branches--------------------------------------------------------

    @RequestMapping(value = "/branches/", method = RequestMethod.GET)
    public ResponseEntity<List<Branch>> getBranches() {
        List<Branch> branches = branchService.findAll();
        if(branches.isEmpty()){
            return new ResponseEntity<List<Branch>>(HttpStatus.NO_CONTENT);// OR HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Branch>>(branches, HttpStatus.OK);
    }

    //------------------- Update a Branch --------------------------------------------------------

    @RequestMapping(value = "/branch/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Branch> updateBranch(@PathVariable("id") long id, @RequestBody Branch branch) {

        Branch currentBranch = branchService.findById(id);

        if (currentBranch==null) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
        Branch updatedBranch = new Branch.Builder().copy(currentBranch)
                .name(branch.getName())
                .branchAddress(branch.getBranchAddress())
                .build();
        branchService.update(updatedBranch);
        return new ResponseEntity<Branch>(updatedBranch, HttpStatus.OK);
    }

    //------------------- Delete a Branch --------------------------------------------------------

    @RequestMapping(value = "/branch/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Branch> deleteBranch(@PathVariable("id") long id) {
        Branch branch = branchService.findById(id);
        if (branch == null) {
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
        branchService.delete(branch);
        return new ResponseEntity<Branch>(HttpStatus.NO_CONTENT);
    }

}
