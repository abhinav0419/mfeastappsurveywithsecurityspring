package com.mobiquity.snack.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mobiquity.snack.validation.PhoneNumberValidator;

	@Entity
	@Table(name = "CONTACT_DETAIL")
	public class ContactDetailEntity {

		@Id
		@GeneratedValue
		@Column(name = "CONTACT_ID")
		private Long contactId;
		
		@PhoneNumberValidator(message="")
		@Column(name = "mobile_number")
		private long mobileNumber;

		@Column(name = "permenant_address")
		private String permenantAddress;

		@Column(name = "temporary_address")
		private String temporaryAddress;
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="USER_ID")
		private UserEntity userId;
		
	

		public Long getContactId() {
			return contactId;
		}

		public void setContactId(Long contactId) {
			this.contactId = contactId;
		}

		public long getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getPermenantAddress() {
			return permenantAddress;
		}

		public void setPermenantAddress(String permenantAddress) {
			this.permenantAddress = permenantAddress;
		}

		public String getTemporaryAddress() {
			return temporaryAddress;
		}

		public void setTemporaryAddress(String temporaryAddress) {
			this.temporaryAddress = temporaryAddress;
		}

		public UserEntity getUserId() {
			return userId;
		}
	
		public void setUserId(UserEntity userId) {
			this.userId = userId;
		}

	

	}

