package com.sumit0733.spring.firstproject.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Integer>{}
