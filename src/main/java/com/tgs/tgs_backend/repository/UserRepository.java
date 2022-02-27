package com.tgs.tgs_backend.repository;

import com.tgs.tgs_backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserNm(String userNm);
    List<User> findByUserIdOrUserNmContaining(String userId, String UserNm);
}
