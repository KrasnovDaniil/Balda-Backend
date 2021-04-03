package ru.examples.services.interfaces;

import ru.examples.dtos.MessageDto;
import ru.examples.models.User;

public interface IMessageService {
    void create(User user, MessageDto messageDto);
}
