package serivce;

import entity.Post;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostService postService;

    @Test
    void testWritePost() {
        String content = "Content";
        String name = "name";

        when(postService.writePost(name, content))
                .thenReturn(new Post(name, content));

        assertEquals("Content", postService.writePost(name, content).getContent());
    }

    @Test
    void testFindByName(){
        String name = "test";

        when(postService.findByName(name))
                .thenReturn(mock(Post.class));

        assertDoesNotThrow(() -> postService.findByName(name));
    }
}