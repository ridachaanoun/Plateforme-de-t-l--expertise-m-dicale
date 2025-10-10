package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "medical_acts")
public class MedicalActs {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double price;

    @ManyToMany(mappedBy = "medicalActs")
    private List<Consultation> consultations = new ArrayList<>();

    public MedicalActs() {}

    public MedicalActs(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
