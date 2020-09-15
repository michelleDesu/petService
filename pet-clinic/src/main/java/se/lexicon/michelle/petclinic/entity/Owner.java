package se.lexicon.michelle.petclinic.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Owner {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String ownerId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;

    public Owner() {
    }

    public Owner(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Owner(String ownerId, String firstName, String lastName, String address, String phoneNumber) {
        this.ownerId = ownerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(ownerId, owner.ownerId) &&
                Objects.equals(firstName, owner.firstName) &&
                Objects.equals(lastName, owner.lastName) &&
                Objects.equals(address, owner.address) &&
                Objects.equals(phoneNumber, owner.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, firstName, lastName, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Owner{" + "ownerId='" + ownerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
