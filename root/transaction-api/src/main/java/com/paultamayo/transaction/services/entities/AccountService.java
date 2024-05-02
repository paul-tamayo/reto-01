package com.paultamayo.transaction.services.entities;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paultamayo.commons.exception.ServiceException;
import com.paultamayo.commons.services.BaseService;
import com.paultamayo.transaction.domains.Account;
import com.paultamayo.transaction.repositories.AccountRepository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService extends BaseService<Account, Long> {

	private static final long serialVersionUID = 3423075780800560329L;

	@Getter(value = AccessLevel.PROTECTED)
	private final AccountRepository repository;

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Account> findByCustomerId(Long customerId) {
		return repository.findByCustomerId(customerId);
	}

	@Transactional(propagation = Propagation.MANDATORY, rollbackFor = ServiceException.class)
	public int updateBalance(Long numberAccount, BigDecimal newBalance) throws ServiceException {
		try {
			int rows = repository.updateBalance(numberAccount, newBalance);

			if (rows == 0) {
				throw new ServiceException("NO SE HA PODIDO ACTUALIZAR LA CUENTA %s.", numberAccount);
			}

			return rows;
		} catch (Exception ex) {
			throw new ServiceException(ex.getMessage(), ex);
		}
	}

}
