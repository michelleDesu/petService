package se.lexicon.michelle.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public PetType(int typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetType petType = (PetType) o;
        return typeId == petType.typeId &&
                Objects.equals(name, petType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, name);
    }

    @Override
    public String toString() {
        return "PetType{" + "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}
