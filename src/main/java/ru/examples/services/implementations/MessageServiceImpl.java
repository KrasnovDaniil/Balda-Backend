package ru.examples.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.examples.dtos.MessageDto;
import ru.examples.models.Message;
import ru.examples.models.Room;
import ru.examples.models.User;
import ru.examples.repositories.MessageRepository;
import ru.examples.repositories.RoomRepository;
import ru.examples.repositories.UserRepository;
import ru.examples.services.interfaces.IMessageService;

import java.util.Optional;

@Service
public class MessageServiceImpl implements IMessageService {

    private final MessageRepository messageRepo;
    private final UserRepository userRepo;
    private final RoomRepository roomRepo;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepo, UserRepository userRepo, RoomRepository roomRepo){
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
        this.roomRepo = roomRepo;
    }

    /*
    Method for casting received DTO to message entity for saving in DB
    MessageDto -> Message -> DB
     */
    public Message castDto2Entity(MessageDto messageDto) throws Exception {
        Optional<User> user_data = userRepo.findByUserName(messageDto.getSender());
        Optional<Room> room_data = roomRepo.findRoomByRoomName(messageDto.getRoom_name());
        User user;
        Room room;
        if (user_data.isPresent() && room_data.isPresent()) {
            user = user_data.get();
            room = room_data.get();
        }
        else // I should create own exception further
            throw new Exception("user not found");

        return Message.builder()
                .user_id(user.getId())
                .room_id(room.getId())
                .content(messageDto.getContent())
                .build();
    }

    @Override
    public void create(User user, MessageDto messageDto) {

    }

}
