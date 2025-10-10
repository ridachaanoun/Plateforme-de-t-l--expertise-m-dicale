package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "nurses")
public class Nurse extends User {

    public Nurse() {}

    public Nurse(String fullName, String username, String email, String password) {
        super(fullName, username, email, password, enums.ERole.NURSE);
    }
}
