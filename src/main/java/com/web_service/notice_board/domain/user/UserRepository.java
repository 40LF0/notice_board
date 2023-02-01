package com.web_service.notice_board.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<_User,Long> {
    Optional<_User> findByEmail(String email);
}
