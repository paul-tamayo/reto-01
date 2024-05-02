package com.paultamayo.transaction.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.paultamayo.transaction.domains.AccountingMovement;
import com.paultamayo.transaction.to.AccountingMovementTo;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountingMovementMapper {

	AccountingMovementTo convertTo(AccountingMovement movement);

	@Mapping(source = "accountNumber", target = "accountNumber")
	List<AccountingMovementTo> convertToList(List<AccountingMovement> customers);
}
