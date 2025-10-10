package entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String response;

    @Column(columnDefinition = "TEXT")
    private String recommendations;

    private LocalDateTime respondedAt;

    @OneToOne
    @JoinColumn(name = "request_id")
    private Request request;

    public Response() {
        this.respondedAt = LocalDateTime.now();
    }

    public Response(String response, String recommendations) {
        this.response = response;
        this.recommendations = recommendations;
        this.respondedAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public LocalDateTime getRespondedAt() {
        return respondedAt;
    }

    public void setRespondedAt(LocalDateTime respondedAt) {
        this.respondedAt = respondedAt;
    }
}
