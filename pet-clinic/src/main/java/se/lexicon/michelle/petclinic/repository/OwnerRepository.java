package se.lexicon.michelle.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.michelle.petclinic.entity.Owner;
import se.lexicon.michelle.petclinic.entity.PetType;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, String> {

    List<Owner> findAll();
}
