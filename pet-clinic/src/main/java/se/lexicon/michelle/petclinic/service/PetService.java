package se.lexicon.michelle.petclinic.service;

import se.lexicon.michelle.petclinic.entity.Pet;

import java.util.List;

public interface PetService {
    //CRUD
    List<Pet> findAll();
    Pet findById(String petId);
    List<Pet> findByName(String name);

    Pet save(Pet pet);

    Pet update(Pet pet);

    void delete(Pet pet);

    //findPetByOwner
    //findPetBetweenDates
}
