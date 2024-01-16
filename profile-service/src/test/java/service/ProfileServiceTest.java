package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @Mock
    private ProfileService profileService;

    @Test
    void changeName() {
        String newName = "Ivan";

        when(profileService.changeName(newName))
                .thenAnswer((Answer<String>) invocationOnMock -> {
                    Object[] args = invocationOnMock.getArguments();
                    return (String) args[0];
                });

        assertEquals(newName, profileService.changeName(newName));
    }

}