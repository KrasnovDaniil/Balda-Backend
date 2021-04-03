package ru.examples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.examples.models.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findRoomById(Long roomId);
    Optional<Room> findRoomByRoomName(String roomName);
}
