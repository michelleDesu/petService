package se.lexicon.michelle.petclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.michelle.petclinic.dto.OwnerFormDto;
import se.lexicon.michelle.petclinic.entity.Owner;
import se.lexicon.michelle.petclinic.repository.OwnerRepository;

import java.util.List;

@RestController
public class OwnerController {

    OwnerRepository ownerRepository;

    @GetMapping("/api/owners")
    public ResponseEntity<List<Owner>>find(){
        List<Owner> responseBody = ownerRepository.findAll();
        return ResponseEntity.ok(responseBody);
    }

   /* @PostMapping("/api/owners")
    public ResponseEntity<Owner> create(@RequestBody OwnerFormDto form){
       // Owner owner = new Owner(form.getFirstName())
    }

    */
}
