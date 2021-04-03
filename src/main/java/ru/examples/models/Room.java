package ru.examples.models;

import javax.persistence.*;

@Entity
@Table(name = "\"Rooms\"")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "roommates_amount")
    private long roommatesAmount;

    public Room(){}
    public Room(String roomName, long roommatesAmount) {
        this.roomName = roomName;
        this.roommatesAmount = roommatesAmount;
    }

    public Long getId() {
        return id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public long getRoommatesAmount() {
        return roommatesAmount;
    }

    public void setRoommatesAmount(long roommatesAmount) {
        this.roommatesAmount = roommatesAmount;
    }
}
