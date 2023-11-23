package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.entity.BlogInfo;

@Repository
public interface BlogRepository extends JpaRepository<BlogInfo, Long> {

	@Query(value = "SELECT * FROM blogInfo where bloguser = :userId", nativeQuery = true)
	List<BlogInfo> findAllByTitle(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM blogInfo where bloguser = :userId and blogtitle = :title", nativeQuery = true)
	List<BlogInfo> findAllByTitle2(@Param("userId") Long userId, @Param("title") String title);

	@Query(value = "SELECT * FROM blogInfo where blogtitle = :title", nativeQuery = true)
	List<BlogInfo> findAllByTitle3(@Param("title") String title);
}
