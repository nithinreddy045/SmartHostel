package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public List<Room> searchRooms(int capacity, boolean hasAC, boolean hasWashroom) {
        return roomRepository
                .findByCapacityGreaterThanEqualAndHasACAndHasAttachedWashroomOrderByCapacityAsc(
                        capacity, hasAC, hasWashroom);
    }

    public Optional<Room> allocateRoom(int students, boolean needsAC, boolean needsWashroom) {

        List<Room> rooms = roomRepository
                .findByCapacityGreaterThanEqualAndHasACAndHasAttachedWashroomOrderByCapacityAsc(
                        students, needsAC, needsWashroom);

        if (!rooms.isEmpty()) {
            return Optional.of(rooms.get(0)); // return first matching room
        }

        return Optional.empty();
    }
}