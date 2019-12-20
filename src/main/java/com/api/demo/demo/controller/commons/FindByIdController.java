package com.api.demo.demo.controller.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public interface FindByIdController<Entity, ID> extends GenericController<Entity, ID> {

  @GetMapping(path = "/{id}")
  public default Entity findById(@PathVariable("id") ID id) {
    return getRepository().findById(id).orElse(null);
  }

}
