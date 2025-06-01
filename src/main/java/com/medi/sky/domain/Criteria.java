package com.medi.sky.domain;

import lombok.Data;

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	
	private Integer mno; // 회원 번호
    private Integer gno; // 비회원 번호
	
	//검색관련
	private String type;
	private String keyword;
	
	
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;	
 	}
	
	// 처음 글 번호
	public int getStartRow() {
        return (pageNum - 1) * amount;
    }
	
	// 마지막 글 번호
	public int getEndRow() {
        return pageNum * amount;
    }
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
