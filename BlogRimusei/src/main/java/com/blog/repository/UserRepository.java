package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.entity.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

	@Query(value = "SELECT * FROM userinfo where account = :account limit 1", nativeQuery = true)
	UserInfo findUserByAccount(@Param("account") String account);
}
