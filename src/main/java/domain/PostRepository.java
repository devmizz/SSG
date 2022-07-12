package domain;

import controller.dto.Post;
import controller.dto.Saying;
import controller.dto.Sayings;

import java.util.ArrayList;
import java.util.Optional;

public class PostRepository {

    private static int id;
    private static ArrayList<Saying> sayings;

    public static int getId() {
        return id;
    }

    public void initailize(Sayings sayings) {
        id = sayings.getId();
        PostRepository.sayings = sayings.getSayings();
    }

    public Saying add(Post post) {
        sayings.add(new Saying(id, post.getSaying(), post.getAuthor()));
        id++;
        return sayings.get(sayings.size() - 1);
    }

    public ArrayList<Saying> findAll() {
        return sayings;
    }

    public boolean delete(int id) {
        boolean isDeleted = false;
        for (int i = 0; i < sayings.size(); i++) {
            if (id == sayings.get(i).getId()) {
                sayings.remove(i);
                isDeleted = true;
                break;
            }
        }

        return isDeleted;
    }

    public Optional<Saying> find(int id) {
        return sayings.stream()
                .filter(
                        s -> s.getId() == id
                ).findFirst();
    }

    public void update(Saying saying) {
        sayings.set(sayings.indexOf(saying), saying);
    }
}
