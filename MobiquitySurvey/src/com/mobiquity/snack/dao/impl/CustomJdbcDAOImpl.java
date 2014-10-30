package com.mobiquity.snack.dao.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mobiquity.snack.model.AppUser;
import com.mobiquity.snack.model.RoleEntity;
import com.mobiquity.snack.model.UserEntity;
import com.mobiquity.snack.repository.UserRepository;

public class CustomJdbcDAOImpl implements UserDetailsService {

    @Autowired private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserByUserName(userName);
        
        if(userEntity == null) {
            return null;
        }

        String name = userEntity.getUserName();
        String password = userEntity.getPassword();

        List<GrantedAuthority> authorizeList = populateUserAuthority(userEntity);

        AppUser user = null;
        if (authorizeList != null && authorizeList.size() > 0) {
            user = new AppUser(name, password, true, true,
                    true, true, authorizeList);
        } else {
            user = new AppUser(name, password, true, true,
                    true, true, AuthorityUtils.NO_AUTHORITIES);
        }

        user.setUserId(userEntity.getUserId());
        user.setPassword(userEntity.getPassword());
        user.setSalt(userEntity.getSalt());
        

        return user;
    }

    private List<GrantedAuthority> populateUserAuthority(UserEntity userEntity) {

        Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

        List<GrantedAuthority> dbAuthorizeList = new ArrayList<GrantedAuthority>(
                dbAuthsSet);
        loadUserPermission(dbAuthorizeList, userEntity);

        return dbAuthorizeList;
    }

    private void loadUserPermission(List<GrantedAuthority> dbAuths, UserEntity userEntity) {

        if (userEntity != null) {
            RoleEntity userRole = userEntity.getUserRole();

            StringBuilder permissionName = new StringBuilder();

            permissionName.append(userRole.getRoleName().toUpperCase());

            dbAuths.add(new SimpleGrantedAuthority(
                    permissionName.toString()));

        }

    }

}
