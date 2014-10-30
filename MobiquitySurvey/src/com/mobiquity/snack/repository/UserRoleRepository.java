package com.mobiquity.snack.repository;

import javax.persistence.MappedSuperclass;

import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.UserRoleEntity;

@MappedSuperclass
public interface UserRoleRepository extends SurveyJpaRepository<UserRoleEntity, Long> {

}
