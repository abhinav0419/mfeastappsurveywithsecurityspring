package com.mobiquity.snack.service.impl;

import java.security.SecureRandom;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiquity.snack.model.RoleEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.repository.RoleRepository;
import com.mobiquity.snack.repository.UserRepository;
import com.mobiquity.snack.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	private static final SecureRandom SECURE_RANDOM = new SecureRandom();

	@Transactional
	public List<UserEntity> getAllUser() {
	    
		 List<UserEntity> userList = userRepository.getAllUser();
		 return userList;
	}

	@Transactional
	public void createUser(UserEntity userEntity) {
	    
	   
	    userRepository.save(userEntity);
	}

	@Transactional
	public void deleteUser(UserEntity userEntity) {
	    
		userRepository.delete(userEntity);
	}

	@Transactional
	public UserEntity getUserById(long id) {
		
	    UserEntity userEntity = userRepository.getUserByUserId(id);
	    
		return userEntity;
	}

	@Transactional
	public UserEntity getValidatedUser(String userEmail,String password) {
		
	    UserEntity userEntity= userRepository.getValidatedUser(userEmail,password);
		return userEntity;
	}
	
	@Transactional
	public void saveUserWithRole(String roleName,UserEntity userEntity) {
	
	RoleEntity role = roleRepository.findRoleByName(roleName);
	userEntity.setUserRole(role);
	
	String salt = generatePasswordSalt();
	userEntity.setSalt(salt);
    String encodedPassword = passwordEncoder.encodePassword(userEntity.getPassword(), salt);
    userEntity.setPassword(encodedPassword);
    
    userRepository.save(userEntity);
	}

	@Transactional
	public UserEntity getUserByUserId(Long id) {
		UserEntity userEntity = userRepository.getUserByUserId(id);
		return userEntity;
	}

	@Transactional
	public UserEntity updateUserPassword(Long id,String newPassword) {
		System.out.println("---------------------------------------user password " + newPassword);
		UserEntity userEntity = userRepository.getUserByUserId(id);
		userEntity.setUserId(id);
		userEntity.setPassword(newPassword);
		userRepository.save(userEntity);
		return userEntity;
		
	}

    @Override
    public UserEntity getUserByName(String userName) {
      UserEntity userEntity =  userRepository.getUserByUserName(userName);
        return userEntity;
    }
    
    @Transactional
    public Blob getDisplayPic(Long userId) {
       
        Blob blob = userRepository.getDisplayPic(userId);
        return blob;
    }
    
    private String generatePasswordSalt() {
        
        byte randomBytes[] = new byte[32];
        SECURE_RANDOM.nextBytes(randomBytes);
        return new String(Base64.encode(randomBytes)).replaceAll("[\\+/=]", "").substring(0, 10);
    }

 



	

	


}
