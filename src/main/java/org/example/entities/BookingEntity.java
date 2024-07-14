package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")
public class BookingEntity extends BaseEntity {
    private String bookingDate;
    private ResidentEntity resident;
    private WorkplaceEntity workplace;
    private MeetingRoomEntity meetingRoom;

    public BookingEntity(String bookingDate, ResidentEntity resident, WorkplaceEntity workplace, MeetingRoomEntity meetingRoom) {
        this.bookingDate = bookingDate;
        this.resident = resident;
        this.workplace = workplace;
        this.meetingRoom = meetingRoom;
    }

    public BookingEntity() {

    }

    @Column(name = "booking_date")
    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
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