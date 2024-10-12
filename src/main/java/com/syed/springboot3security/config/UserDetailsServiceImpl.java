package com.syed.springboot3security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.syed.springboot3security.entity.UserInfoEntity;
import com.syed.springboot3security.repository.UserInfoEntityRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserInfoEntityRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfoEntity> userInfoEntity = repository.findByName(username);
        return userInfoEntity.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));

    }
    
}