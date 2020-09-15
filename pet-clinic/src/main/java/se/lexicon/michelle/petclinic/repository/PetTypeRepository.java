package se.lexicon.michelle.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.michelle.petclinic.entity.PetType;

@Repository
public interface PetTypeRepository  extends CrudRepository<PetType, Integer> {

}
