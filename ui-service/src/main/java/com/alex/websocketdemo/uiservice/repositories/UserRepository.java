package com.alex.websocketdemo.uiservice.repositories;

import com.alex.websocketdemo.uiservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
