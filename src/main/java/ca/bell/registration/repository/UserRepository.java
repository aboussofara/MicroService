package ca.bell.registration.repository;

import ca.bell.registration.model.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> save(User user);

}
