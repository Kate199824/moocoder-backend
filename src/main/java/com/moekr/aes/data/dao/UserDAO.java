package com.moekr.aes.data.dao;

import com.moekr.aes.data.entity.User;
import com.moekr.aes.util.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
	User findByUsername(String username);

	User findByEmail(String email);

	List<User> findAllByRole(Role role);

	Integer countByRole(Role role);
}