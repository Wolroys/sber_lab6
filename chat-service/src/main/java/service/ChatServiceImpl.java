package service;

import entity.User;
import exception.UserNotFoundException;

import java.util.Random;

public class ChatServiceImpl implements ChatService {

    private FriendService friendsService;

    @Override
    public void sendMessage(User user, String message) {
        if (friendsService.isFriend(user))
            System.out.println("Message was sent");
        else
            throw new UserNotFoundException("You don't have this user in friend list");
    }

    @Override
    public boolean isReceived() {
        return new Random().nextBoolean();
    }
}
