package org.example.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
public class BookingEntity {

    private Long id;
    private WorkplaceEntity workplace;
    private ResidentEntity resident;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String status;
    private String purpose;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Workplace_ID", nullable = false)
    public WorkplaceEntity getWorkplace() {
        return workplace;
    }

    public void setWorkplace(WorkplaceEntity workplace) {
        this.workplace = workplace;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "Resident_ID", nullable = false)
    public ResidentEntity getResident() {
        return resident;
    }

    public void setResident(ResidentEntity resident) {
        this.resident = resident;
    }

    @Column(name = "Start_DateTime", nullable = false)
    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Column(name = "End_DateTime", nullable = false)
    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Column(name = "Status", nullable = false)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "Purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}