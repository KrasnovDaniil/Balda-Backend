package ru.examples.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    Long message_id;
    String content;
    Timestamp sendingTime;
    String sender;
    
}
