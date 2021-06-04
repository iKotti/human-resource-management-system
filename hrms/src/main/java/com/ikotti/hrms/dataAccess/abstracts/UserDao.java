package com.ikotti.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikotti.hrms.entity.abstacts.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User getByEmail(String email);
}
