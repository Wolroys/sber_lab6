package service;

import entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RecommendationEngineServiceTest {

    @Mock
    private RecommendationEngineService recommendationEngineService;

    @Test
    void getRecsByPost() {
        Post post = mock(Post.class);
        when(recommendationEngineService.getRecsByPost(any(Post.class)))
                .thenReturn(List.of(new Post("something", "content"),
                        new Post("books", "spoilers")));

        recommendationEngineService.getRecsByPost(post);
        recommendationEngineService.getRecsByPost(post);

        verify(recommendationEngineService, atLeastOnce()).getRecsByPost(post);
        assertEquals(2, recommendationEngineService.getRecsByPost(post).size());
    }
}