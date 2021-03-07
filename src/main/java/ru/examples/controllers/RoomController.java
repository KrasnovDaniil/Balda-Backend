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

    @GetMapping("getHistory")
    public List<MessageDto> getChatRoomMessages(@PathVariable(name = "roomID") long roomId){
        // JDBCTemplate code
        String getMessagesAtPreparedForm = "SELECT * from get_messages_in_prepared_form(?)";
//        String origin = "select \"Users\".user_name, \"Room_messages\".message_content, sending_time from \"Room_messages\" join \"Users\"\n" +
//                " on \"Room_messages\".rm_user_id = \"Users\".user_id where rm_room_id = 1 order by sending_time asc";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(getMessagesAtPreparedForm, roomId);
//        List<Map<String, Object>> list1 = jdbcTemplate.queryForList(origin);

        List<MessageDto> messages = jdbcTemplate.query(getMessagesAtPreparedForm, new Object[] {roomId}, new RowMapper<MessageDto> () {
            @Override
            public MessageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Object s1 = rs.getObject(1);
//                String q1 = rs.getString(2);
//                Timestamp w1 = rs.getTimestamp(3);

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
