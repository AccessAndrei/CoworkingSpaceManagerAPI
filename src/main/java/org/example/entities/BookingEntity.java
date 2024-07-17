package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
public class BookingEntity extends BaseEntity {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ResidentEntity resident;
    private WorkplaceEntity workplace;
    private MeetingRoomEntity meetingRoom;

    public BookingEntity(LocalDateTime startTime, LocalDateTime endTime, ResidentEntity resident, WorkplaceEntity workplace, MeetingRoomEntity meetingRoom) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.resident = resident;
        this.workplace = workplace;
        this.meetingRoom = meetingRoom;
    }
    public BookingEntity() {

    }
    @Column(name = "start_time")
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    public ResidentEntity getResident() {
        return resident;
    }

    public void setResident(ResidentEntity resident) {
        this.resident = resident;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "workplace_id")
    public WorkplaceEntity getWorkplace() {
        return workplace;
    }

    public void setWorkplace(WorkplaceEntity workplace) {
        this.workplace = workplace;
    }

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_room_id")
    public MeetingRoomEntity getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoomEntity meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}