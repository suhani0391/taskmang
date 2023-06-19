package com.infoobjects.Repo;
import com.infoobjects.Entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface UserRepo extends JpaRepository<User, Long> { // for managing the data
    Optional<User> findByEmail(String email);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);
    Optional<User> findByName(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

// jpa is an orm tool