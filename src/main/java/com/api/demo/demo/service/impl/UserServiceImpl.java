package com.api.demo.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.api.demo.demo.entity.UserEntity;
import com.api.demo.demo.repository.UserRepository;
import com.api.demo.demo.service.UserService;
import com.api.demo.demo.service.commons.GenericServiceAb;

@Service
public class UserServiceImpl extends GenericServiceAb<UserEntity, Long> implements UserService {

	@Autowired
	private UserRepository usuarioRepository;

	@Override
	public JpaRepository<UserEntity, Long> getRepository() {
		return this.usuarioRepository;
	}

}
