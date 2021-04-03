package ru.examples.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


// This class also unnecessary for application work, it was created beforehand
// It represents message entity in DB
@Entity
@Table(name = "\"Room_messages\"")
@Builder
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_message_id")
    private Long id;

    // only for identifying room where messages are sent, further it should be replaced on room_id
    @Column(name = "room_id")
    private Long room_id;

    @Column(name = "user_id")
    private long user_id;

    @Column(name = "message_content")
    private String content;

    @CreationTimestamp
    @Column(name = "sending_time")
    private LocalDateTime timestamp;


//    @Column(name = "sender")
//    private String sender;

    // I guess that field should be add in DB
//    @Column(name = "type")
//    private MessageType type;

    public Message(){}
//    public Message(String content, String sender, String roomID) {
//        this.content = content;
//        this.sender = sender;
//        this.room_name = roomID;
//    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getSender() {
//        return sender;
//    }

//    public void setSender(String sender) {
//        this.sender = sender;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

//    public MessageType getType() {
//        return type;
//    }

//    public void setType(MessageType type) {
//        this.type = type;
//    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}

