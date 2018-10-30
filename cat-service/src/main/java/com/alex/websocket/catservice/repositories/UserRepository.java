package com.alex.websocket.catservice.repositories;

import com.alex.websocket.catservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
