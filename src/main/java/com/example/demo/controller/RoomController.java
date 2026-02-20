package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
@CrossOrigin
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    // Add Room
    @PostMapping
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    // View All Rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // Search Rooms
    @GetMapping("/search")
    public List<Room> searchRooms(
            @RequestParam int capacity,
            @RequestParam boolean hasAC,
            @RequestParam boolean hasWashroom) {

        return roomService.searchRooms(capacity, hasAC, hasWashroom);
    }

    // Allocate Room
    @GetMapping("/allocate")
    public String allocateRoom(
            @RequestParam int students,
            @RequestParam boolean needsAC,
            @RequestParam boolean needsWashroom) {

        Optional<Room> room = roomService.allocateRoom(students, needsAC, needsWashroom);

        if (room.isPresent()) {
            return "Allocated Room: " + room.get().getRoomNo();
        } else {
            return "No room available";
        }
    }
}
