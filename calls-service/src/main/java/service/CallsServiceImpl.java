package service;

import entity.User;

public class CallsServiceImpl implements CallsService {

    private FriendService friendService;

    @Override
    public void call(User user) {
        if (friendService.isFriend(user)){
            System.out.println("You are calling");
        }
    }
}
