package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PhotoServiceTest {

    @Mock
    private PhotoService photoService;

    @Test
    void testLoadPhoto() {

        Image mockImage = mock(Image.class);

        verify(photoService, never()).loadPhoto(any(Image.class));


        photoService.loadPhoto(mockImage);

        verify(photoService, times(1)).loadPhoto(mockImage);
    }
}