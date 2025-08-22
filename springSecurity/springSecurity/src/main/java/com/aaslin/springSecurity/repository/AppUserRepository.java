package com.aaslin.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aaslin.springSecurity.model.AppUser;
import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
