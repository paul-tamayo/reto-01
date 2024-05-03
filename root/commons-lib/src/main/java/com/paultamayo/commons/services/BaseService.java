package com.paultamayo.commons.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paultamayo.commons.exception.ServiceException;

public abstract class BaseService<T, K> implements Serializable {

	private static final long serialVersionUID = -2705223468958090729L;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public K deleteById(K id) throws ServiceException {
		try {
			if (getRepository().existsById(id)) {
				getRepository().deleteById(id);
			} else {
				throw new ServiceException("No existe un registro para eliminar.");
			}

			return id;
		} catch (Exception ex) {
			throw new ServiceException(ex, ex.getMessage());
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = ServiceException.class)
	public K deleteMandatoryById(K id) throws ServiceException {
		try {
			if (getRepository().existsById(id)) {
				getRepository().deleteById(id);
			} else {
				throw new ServiceException("No existe un registro para eliminar.");
			}

			return id;
		} catch (Exception ex) {
			throw new ServiceException(ex, ex.getMessage());
		}
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean existsById(K k) {
		return getRepository().existsById(k);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<T> findAll() {
		return getRepository().findAll();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<T> findAllById(List<K> k) throws ServiceException {
		List<T> t = getRepository().findAllById(k);

		if (t.isEmpty()) {
			throw new ServiceException("No se ha podido encontrar registros asociados al identificador: " + k);
		}

		return t;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public T findById(K k) throws ServiceException {
		Optional<T> optional = getRepository().findById(k);

		if (optional.isEmpty()) {
			throw new ServiceException("No se ha podido encontrar registros asociados al identificador: " + k);
		}

		return optional.get();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Optional<T> findOptionalById(K k) {
		return getRepository().findById(k);
	}

	protected abstract JpaRepository<T, K> getRepository();

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = ServiceException.class)
	public T save(T t) throws ServiceException {
		try {
			return getRepository().save(t);
		} catch (Exception ex) {
			throw new ServiceException(ex, ex.getMessage());
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = ServiceException.class)
	public T saveMandatory(T t) throws ServiceException {
		try {
			return getRepository().save(t);
		} catch (Exception ex) {
			throw new ServiceException(ex, ex.getMessage());
		}
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = ServiceException.class)
	public List<T> saveMandatoryAll(Iterable<T> entities) throws ServiceException {
		try {
			return getRepository().saveAll(entities);
		} catch (Exception ex) {
			throw new ServiceException(ex, ex.getMessage());
		}
	}

}
