package com.mobiquity.snack.repository;

import java.sql.Blob;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.ContactDetailEntity;
import com.mobiquity.snack.model.UserEntity;


@MappedSuperclass
public interface ContactDetailRepository extends SurveyJpaRepository<ContactDetailEntity, Long> {
	@Query("select cd from ContactDetailEntity cd where cd.userId = :userId ")
	ContactDetailEntity getContactByUserId(@Param("userId") UserEntity userId);
	
	
	

}
