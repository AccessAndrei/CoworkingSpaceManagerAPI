package org.example.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ResidentDTO resident;
    private WorkplaceDTO workplace;
    private MeetingRoomDTO meetingRoom;

    public BookingDTO() {
    }

    public BookingDTO(LocalDateTime startTime, LocalDateTime endTime, ResidentDTO resident, WorkplaceDTO workplace, MeetingRoomDTO meetingRoom) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.resident = resident;
        this.workplace = workplace;
        this.meetingRoom = meetingRoom;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public ResidentDTO getResident() {
        return resident;
    }

    public void setResident(ResidentDTO resident) {
        this.resident = resident;
    }

    public WorkplaceDTO getWorkplace() {
        return workplace;
    }

    public void setWorkplace(WorkplaceDTO workplace) {
        this.workplace = workplace;
    }

    public MeetingRoomDTO getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoomDTO meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
}