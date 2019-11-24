package com.api.demo.demo.service.commons.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenericService<Entity extends Object, ID extends Serializable> {
	
	JpaRepository<Entity, ID> getRepository();

	Object save(Entity e);

	Object update(Entity e, ID id);

	void delete(Entity e);

	void deleteById(ID e);

	Optional<Entity> findById(ID id);

	List<Entity> findAll();
}
