package com.mobiquity.snack.repository;

import java.sql.Blob;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.UserEntity;

@MappedSuperclass
public interface UserRepository extends SurveyJpaRepository<UserEntity, Long> {

	@Query("select us from UserEntity us order by us.firstName, us.lastName")
	List<UserEntity> getAllUser();

	@Query("select us from UserEntity us where us.userName"
			+ "= :userName and us.password = :password")
	UserEntity getValidatedUser(@Param("userName") String userEmail,
			@Param("password") String password);
	
	@Query("select us from UserEntity us where us.userId = :userId")
	UserEntity getUserByUserId(@Param("userId") Long userId);
	
	@Query("select us from UserEntity us where us.userName = :userName")
	UserEntity getUserByUserName(@Param("userName") String userName);
	
	@Query("select us.displayPic from UserEntity us where us.userId = :userId ")
    Blob getDisplayPic(@Param("userId") Long userId);
	
	
	
	
}
