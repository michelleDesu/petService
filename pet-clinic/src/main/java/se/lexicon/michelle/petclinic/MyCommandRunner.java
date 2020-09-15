package se.lexicon.michelle.petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.michelle.petclinic.entity.Owner;
import se.lexicon.michelle.petclinic.entity.Pet;
import se.lexicon.michelle.petclinic.entity.PetType;
import se.lexicon.michelle.petclinic.repository.OwnerRepository;
import se.lexicon.michelle.petclinic.repository.PetRepository;
import se.lexicon.michelle.petclinic.repository.PetTypeRepository;

import java.time.LocalDate;

@Component
@Transactional(rollbackFor = Exception.class)
public class MyCommandRunner implements CommandLineRunner {

    PetTypeRepository petTypeRepository;
    OwnerRepository ownerRepository;
    PetRepository petRepository;

    @Autowired
    public MyCommandRunner(PetTypeRepository petTypeRepository, OwnerRepository ownerRepository, PetRepository petRepository){
        this.petTypeRepository = petTypeRepository;
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner("Michelle", "Johansson", "testitest", "0154311534");
        owner = ownerRepository.save(owner);

        PetType petType = new PetType("dog");
        petType = petTypeRepository.save(petType);

        Pet pet = new Pet("fido", LocalDate.parse("2020-09-09"), petType, owner);
        pet = petRepository.save(pet);
    }
}
