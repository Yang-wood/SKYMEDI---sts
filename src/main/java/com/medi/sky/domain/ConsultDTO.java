package com.medi.sky.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultDTO {
	private Integer cno;
	private Integer mno;
	private Integer gno;
	private String username;
	private String g_email;
	private String title;
	private String content;
	private Date reg_date;
	private String status;
	
	private int userSeq;
	
}
