package service;

import entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FriendServiceTest {

    @Mock
    private FriendService friendService;

    @Test
    void testGetUsers() {
        List<User> users = List.of(new User("Aleksey"),
                new User("Someone")
        );

        when(friendService.getUsers())
                .thenReturn(users);

        assertEquals(users, friendService.getUsers());

        verify(friendService)
                .getUsers();

    }

    @Test
    void testIsFriend() {

        verify(friendService, never())
                .isFriend(any(User.class));

        when(friendService.isFriend(any(User.class)))
                .thenReturn(true);

        User user = new User("Mr.Smith");

        assertTrue(friendService.isFriend(user));

        verify(friendService, atMostOnce()).isFriend(user);

    }

    @Test
    void testAddFriend(){
        User mockUser = mock(User.class);

        verifyNoInteractions(friendService);

        when(friendService.addFriend(any(User.class)))
                .thenReturn(mockUser);

        when (mockUser.getName())
                .thenReturn("Alex");

        assertEquals("Alex", friendService.addFriend(new User("Alex")).getName());
    }
}