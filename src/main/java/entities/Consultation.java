package entities;

import enums.ConsultationStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue
    private UUID id;

    private String reason;
    @Column(columnDefinition = "TEXT")
    private String observations;

    private double price;

    @Enumerated(EnumType.STRING)
    private ConsultationStatus status;

    private double specialistFee;
    private LocalDateTime createdAt;

    // Relations
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToMany
    @JoinTable(
        name = "consultation_medicalacts",
        joinColumns = @JoinColumn(name = "consultation_id"),
        inverseJoinColumns = @JoinColumn(name = "medicalact_id")
    )
    private List<MedicalActs> medicalActs = new ArrayList<>();

    public Consultation() {
        this.createdAt = LocalDateTime.now();
    }

    public Consultation(String reason, String observations, double price, ConsultationStatus status, double specialistFee) {
        this.reason = reason;
        this.observations = observations;
        this.price = price;
        this.status = status;
        this.specialistFee = specialistFee;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ConsultationStatus getStatus() {
        return status;
    }

    public void setStatus(ConsultationStatus status) {
        this.status = status;
    }

    public double getSpecialistFee() {
        return specialistFee;
    }

    public void setSpecialistFee(double specialistFee) {
        this.specialistFee = specialistFee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
