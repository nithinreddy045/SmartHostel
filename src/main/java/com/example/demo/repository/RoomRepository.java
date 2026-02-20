package com.example.demo.repository;

import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    // Search & Allocation Query
    List<Room> findByCapacityGreaterThanEqualAndHasACAndHasAttachedWashroomOrderByCapacityAsc(
            int capacity,
            boolean hasAC,
            boolean hasAttachedWashroom
    );
}
