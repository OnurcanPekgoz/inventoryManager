package com.onurcan.task.Repository;

import com.onurcan.task.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}

