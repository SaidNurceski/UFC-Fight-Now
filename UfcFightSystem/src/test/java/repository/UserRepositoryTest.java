package repository;

import org.example.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void insert() {
        UserRepository userRepository = new UserRepository();
      User user = new User("test","test","123","t@gmail.com",12);
      userRepository.insert(user);
    }

    @Test
    void getAll() {
        UserRepository userRepository = new UserRepository();
        userRepository.getAll().forEach(System.out::println);
    }

    @Test
    void getById() {
    }
}