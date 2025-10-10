package entities;


import jakarta.persistence.*;

@Entity
@Table(name = "generalists")
public class Generalist extends User {

    public Generalist() {}

    public Generalist(String fullName, String username, String email, String password) {
        super(fullName, username, email, password, enums.ERole.GENERALIST);
    }
}
