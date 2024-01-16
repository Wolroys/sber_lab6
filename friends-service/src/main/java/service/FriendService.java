package service;

import entity.User;

import java.util.List;

public interface FriendService {

    List<User> getUsers();

    boolean isFriend(User user);

    User addFriend(User user);
}
