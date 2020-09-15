package se.lexicon.michelle.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.michelle.petclinic.entity.Pet;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, String> {
    List<Pet> findAll();

    List<Pet> findAllByNameContainsIgnoreCase(String petName);
}
