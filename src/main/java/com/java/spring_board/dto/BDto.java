package com.java.spring_board.dto;

public class BDto {

	int bNum;
	String bId;
	String bTitle;
	String bContent;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BDto(int bNum, String bId, String bTitle, String bContent) {
		// TODO Auto-generated constructor stub
		this.bNum = bNum;
		this.bId = bId;
		this.bTitle = bTitle;
		this.bContent = bContent;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	
}