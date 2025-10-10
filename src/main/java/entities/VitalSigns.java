package entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "vital_signs")
public class VitalSigns {

    @Id
    @GeneratedValue
    private UUID id;

    private String bloodPressure;
    private int heartRate;
    private double bodyTemperature;
    private int respiratoryRate;
    private double weight;
    private double height;
    private LocalDateTime createdAt;

    public VitalSigns() {}

    public VitalSigns(String bloodPressure, int heartRate, double bodyTemperature, int respiratoryRate, double weight, double height) {
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.bodyTemperature = bodyTemperature;
        this.respiratoryRate = respiratoryRate;
        this.weight = weight;
        this.height = height;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    public double getBodyTemperature() { return bodyTemperature; }
    public void setBodyTemperature(double bodyTemperature) { this.bodyTemperature = bodyTemperature; }

    public int getRespiratoryRate() { return respiratoryRate; }
    public void setRespiratoryRate(int respiratoryRate) { this.respiratoryRate = respiratoryRate; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
