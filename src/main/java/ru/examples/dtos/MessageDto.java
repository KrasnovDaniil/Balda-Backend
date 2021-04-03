package ru.examples.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.examples.models.Message;
import ru.examples.models.MessageType;

import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * MessageDto represents prepared message format - (sender, content, sending time)
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

    String sender;
    String content;
    String room_name;
    Timestamp sendingTime;
    MessageType type;

}
