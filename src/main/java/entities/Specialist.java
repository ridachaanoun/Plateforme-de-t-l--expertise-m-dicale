package entities;

import enums.Specialities;
import jakarta.persistence.*;

@Entity
@Table(name = "specialists")
public class Specialist extends User {

    @Enumerated(EnumType.STRING)
    private Specialities speciality;
    private double consultationFee;
    private int consultationDuration;

    public Specialist() {}

    public Specialist(String fullName, String username, String email, String password, Specialities speciality, double consultationFee, int consultationDuration) {
        super(fullName, username, email, password, enums.ERole.SPECIALIST);
        this.speciality = speciality;
        this.consultationFee = consultationFee;
        this.consultationDuration = consultationDuration;
    }

    public Specialities getSpeciality() { 
        return speciality; 
    }
    public void setSpeciality(Specialities speciality) { 
        this.speciality = speciality; 
    }

    public double getConsultationFee() { 
        return consultationFee; 
    }

    public void setConsultationFee(double consultationFee) { 
        this.consultationFee = consultationFee; 
    }

    public int getConsultationDuration() { 
        return consultationDuration; 
    }

    public void setConsultationDuration(int consultationDuration) { 
        this.consultationDuration = consultationDuration; 
    }
}
