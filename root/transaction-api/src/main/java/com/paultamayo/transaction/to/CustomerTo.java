package com.paultamayo.transaction.to;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class CustomerTo implements Serializable {

	private static final long serialVersionUID = -2563887473646992210L;

	private String address;

	private boolean enabled;

	private String fullname;

	private Long id;

	private String phoneNumber;
}
