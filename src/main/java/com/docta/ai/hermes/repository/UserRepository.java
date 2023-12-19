package com.docta.ai.hermes.repository;

import com.docta.ai.hermes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByGoogleEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByName(String name);

}
