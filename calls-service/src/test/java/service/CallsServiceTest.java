package service;

import static org.junit.jupiter.api.Assertions.*;
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
        doNothing().when(callsService)
                .call();

        callsService.call();

        verify(callsService, times(1))
                .call();
    }


}