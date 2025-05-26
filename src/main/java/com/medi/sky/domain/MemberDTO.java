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
	private String email;
	private Date reg_date;
	private Date del_date;
	private char is_deleted;
	private char share_agree;
	private Date share_date;
}
