package com.mobiquity.snack.service;

import java.util.List;

import com.mobiquity.snack.model.RoleEntity;

public interface RoleEntityService {
	List<RoleEntity> getAllRole();
	RoleEntity findRoleByName(String roleName);
}
