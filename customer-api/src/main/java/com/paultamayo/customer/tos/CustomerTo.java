package com.paultamayo.customer.tos;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerTo implements Serializable {

	private static final long serialVersionUID = 8332389212831057443L;

	private String address;

	private String fullname;

	private Long id;

	private String phoneNumber;

}
