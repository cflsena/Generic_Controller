package com.api.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.demo.controller.commons.GenericController;
import com.api.demo.demo.entity.UserEntity;
import com.api.demo.demo.service.UserService;
import com.api.demo.demo.service.commons.interfaces.GenericService;

@RestController
@RequestMapping("/usuarios")
public class UserController extends GenericController<UserEntity, Long> {

	@Autowired
	private UserService usuarioService;

	@Override
	protected GenericService<UserEntity, Long> getService() {
		return this.usuarioService;
	}
}
