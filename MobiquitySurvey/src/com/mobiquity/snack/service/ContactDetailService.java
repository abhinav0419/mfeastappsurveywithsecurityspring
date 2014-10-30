package com.mobiquity.snack.service;

import java.sql.Blob;

import com.mobiquity.snack.model.ContactDetailEntity;
import com.mobiquity.snack.model.UserEntity;

public interface ContactDetailService {
	void addContactDetail(ContactDetailEntity contactDetailEntity);
	
	ContactDetailEntity getContactByUserId(UserEntity userId);
	
	
	
	void addUserToContactDetail (UserEntity id, ContactDetailEntity contactDetailEntity);
}
