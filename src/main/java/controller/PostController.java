package controller;

import controller.dto.Post;
import controller.dto.Saying;
import service.PostService;

import java.util.Optional;

public class PostController {

    PostService postService = new PostService();

    public void initialize() {
        postService.initialize();
    }

    public int add(Post post) {
        return postService.add(post);
    }

    public String show() {
        return postService.show();
    }

    public boolean delete(int id) {
        return postService.delete(id);
    }

    public Optional<Saying> find(int id) {
        return postService.find(id);
    }

    public void update(Saying saying) {
        postService.update(saying);
    }

    public void save() {
        postService.save();
    }
}

