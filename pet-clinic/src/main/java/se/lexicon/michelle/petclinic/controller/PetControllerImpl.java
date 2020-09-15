package se.lexicon.michelle.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.michelle.petclinic.entity.Pet;
import se.lexicon.michelle.petclinic.service.PetService;

@RestController
public class PetControllerImpl implements PetController {

    public static final String PET_ID = "petId";
    public static final String PET_NAME = "petName";
    public static final String ALL = "all";
    private PetService petService;

    @Autowired
    public PetControllerImpl(PetService petService){
        this.petService = petService;
    }


    @Override
    @GetMapping("/api/pets/{petId}")
    public ResponseEntity<Pet> findById(@PathVariable String petId) {

        return ResponseEntity.ok(petService.findById(petId));
    }

    @Override
    @GetMapping("/api/pets")
    public ResponseEntity<?> find(
            @RequestParam(name = "type", defaultValue = "all") String type,
            @RequestParam(name = "value", defaultValue = "all")String value) {

        switch (type.toLowerCase().trim()){

            //check the name of the id
            case PET_ID:
                return ResponseEntity.ok(petService.findById(value));
            case PET_NAME:
                return ResponseEntity.ok(petService.findByName(value) );
            case ALL: return ResponseEntity.ok(petService.findAll() );

            default:
                throw new IllegalArgumentException("Not a valid type:" + type);
        }
    }

    @Override
    @PostMapping("/api/pets")
    public ResponseEntity<Pet> save(@RequestBody Pet pet) {

        return ResponseEntity.status(HttpStatus.CREATED).body(petService.save(pet));
    }



    @Override
    public ResponseEntity<Pet> update(String id, Pet updated) {
        return null;
    }
}
