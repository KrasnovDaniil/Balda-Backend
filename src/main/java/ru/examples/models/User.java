package ru.examples.models;

import javax.persistence.*;

@Entity(name = "users")
@Table(name = "\"Users\"", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "room_id")
    private Long roomId;

//    @Column(name = "email")
//    private String email;

    public User() { }

    public User(String user_name, Long room_id) {
        this.userName = user_name;
        this.roomId = room_id;
    }

    public Long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
