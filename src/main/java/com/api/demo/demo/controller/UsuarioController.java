package com.api.demo.demo.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.demo.demo.controller.commons.GenericController;
import com.api.demo.demo.entity.Usuario;
import com.api.demo.demo.infra.RestGenericFunction;
import com.api.demo.demo.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends GenericController<Usuario, Long> {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public JpaRepository<Usuario, Long> getRepository() {
    return this.usuarioRepository;
  }

  @Override
  public List<RestGenericFunction> ignoreResourcePath() {
    return Arrays.asList(RestGenericFunction.DELETE);
  }

}
