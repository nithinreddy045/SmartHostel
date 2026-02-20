package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNo;
    private int capacity;
    private boolean hasAC;
    private boolean hasAttachedWashroom;

    public Room() {}

    public Long getId() {
        return id;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasAC() {
        return hasAC;
    }

    public void setHasAC(boolean hasAC) {
        this.hasAC = hasAC;
    }

    public boolean isHasAttachedWashroom() {
        return hasAttachedWashroom;
    }

    public void setHasAttachedWashroom(boolean hasAttachedWashroom) {
        this.hasAttachedWashroom = hasAttachedWashroom;
    }
}