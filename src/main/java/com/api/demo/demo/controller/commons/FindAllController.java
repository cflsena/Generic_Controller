package com.api.demo.demo.controller.commons;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public interface FindAllController<Entity, ID> extends GenericController<Entity, ID> {

  @GetMapping
  public default List<Entity> findAll() {
    return getRepository().findAll();
  }

}
