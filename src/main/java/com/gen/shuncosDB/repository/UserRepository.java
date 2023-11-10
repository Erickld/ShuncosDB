package com.gen.shuncosDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gen.shuncosDB.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
