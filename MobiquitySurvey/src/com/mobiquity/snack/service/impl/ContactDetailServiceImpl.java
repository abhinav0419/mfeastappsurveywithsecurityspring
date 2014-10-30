package com.mobiquity.snack.service.impl;

import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiquity.snack.model.ContactDetailEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.repository.ContactDetailRepository;
import com.mobiquity.snack.repository.UserRepository;
import com.mobiquity.snack.service.ContactDetailService;

@Service
public class ContactDetailServiceImpl implements ContactDetailService {
	
	@Autowired
	private ContactDetailRepository contactDetailRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void addContactDetail(ContactDetailEntity contactDetailEntity) {
		contactDetailRepository.save(contactDetailEntity);
		
	}

	

	@Transactional
	public ContactDetailEntity getContactByUserId(UserEntity userId) {
		ContactDetailEntity contactDetailEntity = contactDetailRepository.getContactByUserId(userId);
		//userRepository.save(userId);
		return contactDetailEntity;
	}






	@Transactional
	public void addUserToContactDetail(UserEntity userEntity,
			ContactDetailEntity contactDetailEntity) {
	    
		UserEntity entity = userRepository.getUserByUserId(userEntity.getUserId());
		try {
			if(userEntity.getDisplayPic() != null && userEntity.getDisplayPic().length() != 0){
			    entity.setDisplayPic(userEntity.getDisplayPic());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		userRepository.save(userEntity);
		contactDetailEntity.setUserId(entity);
		contactDetailRepository.save(contactDetailEntity);
		
	}



	

}
