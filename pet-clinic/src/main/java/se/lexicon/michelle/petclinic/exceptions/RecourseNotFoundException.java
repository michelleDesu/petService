package se.lexicon.michelle.petclinic.exceptions;


public class RecourseNotFoundException extends RuntimeException {

    public RecourseNotFoundException() {
        super();
    }

    public RecourseNotFoundException(String message) {
        super(message);

    }
}
