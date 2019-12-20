package com.api.demo.demo.controller.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public interface SaveController<Entity, ID> extends GenericController<Entity, ID> {

  @PostMapping
  public default Entity create(@RequestBody Entity entity) {
    return getRepository().save(entity);
  }

  @PutMapping
  public default Entity update(@RequestBody Entity entity) {
    return getRepository().save(entity);
  }

}
