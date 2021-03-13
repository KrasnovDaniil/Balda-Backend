package ru.examples.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.examples.dtos.MessageDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("room/{roomID}/")
public class RoomController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
    Here I insert all messages from spec room for displaying that in chatRoom further
    Displaying will be implemented by frntnd accordingly some rules
     */
    @GetMapping("getHistory")
    public List<MessageDto> getChatRoomMessages(@PathVariable(name = "roomID") long roomId){
        // JDBCTemplate code
        String getMessagesAtPreparedForm = "SELECT * from get_messages_in_prepared_form(?)";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(getMessagesAtPreparedForm, roomId);
//        String origin = "select \"Users\".user_name, \"Room_messages\".message_content, sending_time from \"Room_messages\" join \"Users\"\n" +
//                " on \"Room_messages\".rm_user_id = \"Users\".user_id where rm_room_id = 1 order by sending_time asc";
//        List<Map<String, Object>> list1 = jdbcTemplate.queryForList(origin);

        List<MessageDto> messages = jdbcTemplate.query(getMessagesAtPreparedForm, new Object[] {roomId}, new RowMapper<MessageDto> () {
            @Override
            public MessageDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                return MessageDto.builder()
                        .sender(rs.getString(1))
                        .content(rs.getString(2))
                        .sendingTime(rs.getTimestamp(3))
                        .build();
            }
        });
        return messages;
    }


//    @GetMapping()
//    public void userLeftRoom(){
//        // remove from DB "Rooms"
//    }
//
//
//    @GetMapping()
//    public void userJoinTheRoom(){
//        // add User to DB
//    }

}
