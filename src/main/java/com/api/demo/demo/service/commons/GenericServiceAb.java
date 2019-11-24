package com.api.demo.demo.service.commons;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.api.demo.demo.service.commons.interfaces.GenericService;
import com.api.demo.demo.utils.GenericUtils;

public abstract class GenericServiceAb<Entity extends Object, ID extends Serializable>
		implements GenericService<Entity, ID> {

	@Override
	@Transactional
	public Object save(Entity e) {
		e = getRepository().save(e);
		getRepository().flush();
		return e;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional
	public Object update(Entity e, ID id) {
		Optional<Object> op = (Optional) getRepository().findById(id);
		if (!op.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		Entity ob = (Entity) findAnyEntityById(id);
		if (GenericUtils.isNotEmpytOrNotNull(e)) {
			BeanUtils.copyProperties(e, ob, "id");
			ob = getRepository().save(ob);
			getRepository().flush();
		} else {
			throw new EmptyResultDataAccessException(1);
		}
		return ob;
	}

	@Override
	@Transactional
	public void delete(Entity e) {
		getRepository().delete(e);
		getRepository().flush();
	}

	@Override
	@Transactional
	public void deleteById(ID id) {
		getRepository().deleteById(id);
		getRepository().flush();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(readOnly = true)
	public Optional<Entity> findById(ID id) {
		return (Optional) getRepository().findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Entity> findAll() {
		return getRepository().findAll();
	}

	@SuppressWarnings({"unchecked","rawtypes"})
	@Transactional(readOnly = true)
	public Object findAnyEntityById(ID id) {
		Optional<Object> op = (Optional) getRepository().findById(id);
		if (!op.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return op.get();
	}
}
