package org.example.tropicaliasapi.repository;

import org.example.tropicaliasapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByUsername(String username);

    Optional<User> findById(Long id);

    Optional<User> findUserByFirebaseId(String firebaseId);

}
