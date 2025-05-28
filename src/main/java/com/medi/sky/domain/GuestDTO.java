package com.medi.sky.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestDTO {
	private Integer gno;
	private String g_email;
	private String g_password;
	private Date reg_date;
}
