package com.mobiquity.snack.repository;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mobiquity.snack.api.jpa.SurveyJpaRepository;
import com.mobiquity.snack.model.RoleEntity;

@MappedSuperclass
public interface RoleRepository extends
		SurveyJpaRepository<RoleEntity, Long> {
	
	@Query("select rl from RoleEntity rl order by rl.roleName")
	List<RoleEntity> getAllRole();
	
	@Query("select rl from RoleEntity rl where rl.roleName = :roleName")
	RoleEntity findRoleByName(@Param("roleName")String roleName);
}
