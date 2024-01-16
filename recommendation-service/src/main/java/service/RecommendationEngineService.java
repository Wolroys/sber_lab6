package service;

import entity.Post;

import java.util.List;

public interface RecommendationEngineService {

    List<Post> getRecsByPost(Post post);
}
