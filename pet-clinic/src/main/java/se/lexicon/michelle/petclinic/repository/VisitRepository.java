package se.lexicon.michelle.petclinic.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.michelle.petclinic.entity.Visit;

public interface VisitRepository extends CrudRepository<Visit, String> {

}
