package com.bankop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccontModel {

	private String account_no;
	private Double balance;
	private String account_type;
	private String last_updated_date;

}
