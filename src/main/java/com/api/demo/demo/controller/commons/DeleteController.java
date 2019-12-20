package com.api.demo.demo.controller.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public interface DeleteController<Entity, ID> extends GenericController<Entity, ID> {

  @DeleteMapping(path = "/{id}")
  public default void delete(@PathVariable("id") ID id) {
    getRepository().deleteById(id);
  }

}
