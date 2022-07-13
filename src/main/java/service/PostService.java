package service;

import controller.dto.Sayings;
import controller.dto.Post;
import controller.dto.Saying;
import domain.FileRepository;
import domain.PostRepository;

import java.util.ArrayList;
import java.util.Optional;

public class PostService {

    PostRepository postRepository = new PostRepository();
    FileRepository fileRepository = new FileRepository();

    public void initialize() {
        postRepository.initailize(fileRepository.getFile());
    }

    public int add(Post post) {
        return postRepository.add(post).getId();
    }

    public String show() {
        ArrayList<Saying> sayings = postRepository.findAll();
        String str = """
                번호 / 작가 / 명언
                ---------------
                """;

        if(sayings != null) {
            for (int i = sayings.size() - 1; i >= 0; i--) {
                Saying findSaying = sayings.get(i);
                str += findSaying.getId() + " / " + findSaying.getAuthor() + " / " + findSaying.getContent() + "\n";
            }
        } else {
            str = "현재 명언이 없습니다.";
        }

        return str;
    }

    public boolean delete(int id) {
        return postRepository.delete(id);
    }

    public Optional<Saying> find(int id) {
        return postRepository.find(id);
    }

    public void update(Saying saying) {
        postRepository.update(saying);
    }

    public void save() {
        fileRepository.save(new Sayings(postRepository.getId(), postRepository.findAll()));
    }
}

