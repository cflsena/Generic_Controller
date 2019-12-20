package com.api.demo.demo.controller.commons;

import org.springframework.stereotype.Controller;

@Controller
public interface CrudController<Entity, ID> extends SaveController<Entity, ID>,
    FindAllController<Entity, ID>, FindByIdController<Entity, ID>, DeleteController<Entity, ID> {

}
