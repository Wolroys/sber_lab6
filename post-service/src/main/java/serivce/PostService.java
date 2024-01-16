package serivce;

import entity.Post;

public interface PostService {
    Post findByName(String name);

    Post writePost(String name, String content);
}
