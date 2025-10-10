package entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

import enums.WTSStatus;

@Entity
@Table(name = "weekly_time_slots")
public class WeeklyTimeSlots {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private WTSStatus status;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    public WeeklyTimeSlots() {}

    // --- Getters et Setters ---
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public WTSStatus getStatus() { return status; }
    public void setStatus(WTSStatus status) { this.status = status; }

    public Specialist getSpecialist() { return specialist; }
    public void setSpecialist(Specialist specialist) { this.specialist = specialist; }
}
