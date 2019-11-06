package com.api.demo.demo.controller.commons;

import java.util.Collections;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.api.demo.demo.exception.NotFoundRequestException;
import com.api.demo.demo.infra.RestGenericFunction;

@Controller
public abstract class GenericController<Entity, ID> {

  @GetMapping
  public List<Entity> findAll() {
    this.validFunction(RestGenericFunction.FIND_ALL);
    return getRepository().findAll();
  }

  @GetMapping(path = "/{id}")
  public Entity findById(@PathVariable("id") ID id) {
    this.validFunction(RestGenericFunction.FIND_BY_ID);
    return getRepository().findById(id).orElse(null);
  }

  @PostMapping
  public Entity create(@RequestBody Entity entity) {
    this.validFunction(RestGenericFunction.SAVE);
    return getRepository().save(entity);
  }

  @PutMapping
  public Entity alter(@RequestBody Entity entity) {
    this.validFunction(RestGenericFunction.ALTER);
    return getRepository().save(entity);
  }

  @DeleteMapping(path = "/{id}")
  public void delete(@PathVariable("id") ID id) {
    this.validFunction(RestGenericFunction.DELETE);
    getRepository().deleteById(id);
  }

  private void validFunction(final RestGenericFunction function) {
    if (ignoreResourcePath().contains(function))
      throw new NotFoundRequestException("Resource not found");
  }

  public abstract JpaRepository<Entity, ID> getRepository();
  
  public List<RestGenericFunction> ignoreResourcePath() {
    return Collections.emptyList();
  }

}
