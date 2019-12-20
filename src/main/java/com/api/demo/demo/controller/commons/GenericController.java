package com.api.demo.demo.controller.commons;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface GenericController<Entity, ID> {

  public JpaRepository<Entity, ID> getRepository();

}
