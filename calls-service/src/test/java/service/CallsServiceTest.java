package service;

import static org.junit.jupiter.api.Assertions.*;

import entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CallsServiceTest {

    @Mock
    private CallsService callsService;

    @Test
    void testCall() {
        User user = mock(User.class);
        doNothing().when(callsService)
                .call(user);

        callsService.call(user);
        callsService.call(user);

        verify(callsService, times(2))
                .call(user);
    }


}