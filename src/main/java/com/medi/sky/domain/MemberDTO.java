package com.medi.sky.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
	private int mno;
	private String username;
	private String password;
	private String name;
	private Date birth_date;
	private String phone;
	private String email;
	private Date regidate;
	private char is_deleted;
}
