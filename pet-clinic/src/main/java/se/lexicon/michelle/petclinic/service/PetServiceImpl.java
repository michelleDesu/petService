package se.lexicon.michelle.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.michelle.petclinic.entity.Pet;
import se.lexicon.michelle.petclinic.exceptions.RecourseNotFoundException;
import se.lexicon.michelle.petclinic.repository.OwnerRepository;
import se.lexicon.michelle.petclinic.repository.PetRepository;
import se.lexicon.michelle.petclinic.repository.PetTypeRepository;

import java.util.List;

@Service
public class PetServiceImpl implements PetService{


    PetRepository petRepository;
    PetTypeRepository petTypeRepository;
    OwnerRepository ownerRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetTypeRepository petTypeRepository, OwnerRepository ownerRepository){
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
    this.ownerRepository = ownerRepository;
}

    @Override
    public List<Pet> findAll() {
        List<Pet> foundItems = petRepository.findAll();
        if(foundItems.isEmpty()) throw new RuntimeException("Couldn't find any pets");

        return foundItems;
    }

    @Override
    public Pet findById(String petId) {
        return petRepository.findById(petId).orElseThrow ( ()-> new RecourseNotFoundException(" Could not find any with this ID: " + petId) );
    }

    @Override
    public List<Pet> findByName(String petName) {

        List<Pet> foundItems = petRepository.findAllByNameContainsIgnoreCase(petName);

        if (foundItems.isEmpty()) throw new RecourseNotFoundException("Could not find any pets with the name of" + petName);
        return foundItems;
    }

    @Override
    @Transactional
    public Pet save(Pet pet) {
        if(pet.getPetId() != "" && pet.getPetId()!= null) throw new RecourseNotFoundException("Could NOT create a pet where ID is specified");

        Pet toSave = new Pet(
                pet.getName(),
                pet.getBirthDate(),
                pet.getPetType(),
                pet.getOwner()
        );
        return petRepository.save(toSave);
    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public void delete(Pet pet) {
        petRepository.delete(pet);
    }
}
