package com.api.demo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.demo.demo.controller.commons.CrudController;
import com.api.demo.demo.entity.Usuario;
import com.api.demo.demo.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController implements CrudController<Usuario, Long> {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public JpaRepository<Usuario, Long> getRepository() {
    return this.usuarioRepository;
  }

}
