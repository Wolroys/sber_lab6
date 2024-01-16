package service;

import entity.User;

public interface ChatService {

    void sendMessage(User user, String message);

    boolean isReceived();
}
