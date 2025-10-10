package entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "queues")
public class Queue {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime arrivalTime;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Queue() {
        this.arrivalTime = LocalDateTime.now();
    }

    public Queue(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
