package org.example.dto;

public class MeetingRoomDTO {
    private Integer id;
    private String name;
    private int capacity;
    private boolean isAvailable;


    public MeetingRoomDTO(Integer id, String name, int capacity, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}