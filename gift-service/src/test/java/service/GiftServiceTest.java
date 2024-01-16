package service;

import entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GiftServiceTest {

    @Mock
    private GiftService giftService;

    @Test
    void testGift() {
        User user = new User("Sergey");

        when(giftService.sendGift(any(User.class)))
                .thenReturn("Successful");

        giftService.sendGift(user);
        giftService.sendGift(user);
        giftService.sendGift(user);

        verify(giftService, times(3)).sendGift(any(User.class));
        assertEquals("Successful", giftService.sendGift(user));
    }
}