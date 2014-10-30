package com.mobiquity.snack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobiquity.snack.model.RoleEntity;
import com.mobiquity.snack.repository.RoleRepository;
import com.mobiquity.snack.service.RoleEntityService;
@Service
public class RoleEntityServiceImpl implements RoleEntityService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public List<RoleEntity> getAllRole() {
		List<RoleEntity> allRowList = roleRepository.getAllRole();
		return allRowList;
	}

	@Transactional
	public RoleEntity findRoleByName(String roleName) {
		RoleEntity roleEntity =roleRepository.findRoleByName(roleName);
		return roleEntity;
	}

}
