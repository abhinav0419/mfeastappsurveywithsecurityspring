package com.mobiquity.snack.service;

import java.sql.Blob;
import java.util.List;

import com.mobiquity.snack.model.UserEntity;

public interface UserService {
	void createUser(UserEntity userEntity);

	void deleteUser(UserEntity userEntity);

	List<UserEntity> getAllUser();

	UserEntity getUserById(long id);
	
	UserEntity getValidatedUser(String userEmail,String password);
	
	void saveUserWithRole(String roleName,UserEntity userEntity);
	
	UserEntity getUserByUserId( Long id);
	
	UserEntity updateUserPassword( Long id,String newPassword);
	
	UserEntity getUserByName(String userName);
	
	Blob getDisplayPic( Long userId);
    
	
	
	
	
	

}
