package service;

import entity.User;
import exception.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChatServiceTest {

    @Mock
    private ChatService chatService;

    @Mock
    private ChatService chatServiceSecond;

    @Test
    void sendMessage() {
        User user = new User("Lera");
        chatService.sendMessage(user, "Hello");
        chatServiceSecond.sendMessage(user, "World");

        InOrder inOrder = inOrder(chatService, chatServiceSecond);

        verify(chatService).sendMessage(user, "Hello");
        verify(chatServiceSecond).sendMessage(user, "World");
    }

    @Test
    void isReceived() {
        when(chatService.isReceived())
                .thenThrow(UserNotFoundException.class);

        assertThrowsExactly(UserNotFoundException.class, () -> chatService.isReceived());
    }
}