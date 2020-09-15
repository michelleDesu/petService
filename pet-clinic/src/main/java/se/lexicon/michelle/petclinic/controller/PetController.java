package se.lexicon.michelle.petclinic.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import se.lexicon.michelle.petclinic.entity.Pet;

public interface PetController {
    ResponseEntity<Pet> findById(String petId);
    ResponseEntity<?> find(final String type, final String value);

    ResponseEntity<Pet> save (Pet pet);

    ResponseEntity<Pet> update (String id, Pet updated);


}
