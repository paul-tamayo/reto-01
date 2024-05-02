package com.paultamayo.commons.utils;

import org.slf4j.Logger;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.function.ThrowingSupplier;

import com.paultamayo.commons.helpers.ApiModel;
import com.paultamayo.commons.helpers.StatusRequestEnum;

import lombok.AccessLevel;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Generated
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ControllerUtil {

	public static final <T> ResponseEntity<ApiModel<T>> response(Logger log, ThrowingSupplier<T> supplier) {
		ResponseEntity<ApiModel<T>> response = null;

		try {
			response = new ResponseEntity<>(
					ApiModel.<T>builder().data(supplier.get()).status(StatusRequestEnum.OK).build(),
					HttpStatusCode.valueOf(200));
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);

			response = new ResponseEntity<>(
					ApiModel.<T>builder().message(ex.getMessage()).status(StatusRequestEnum.OK).build(),
					HttpStatusCode.valueOf(500));
		}

		return response;
	}

}
