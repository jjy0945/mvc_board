package com.java.spring_board.dto;

public class LDto {

	String MEMBERID;
	String MEMBERPW;
	String MEMBERNAME;
	String MEMBERADDRESS;
	String MEMBERPHONE;
	
	public LDto() {
		// TODO Auto-generated constructor stub
	}
	
	public LDto(String MEMBERID, String MEMBERPW, String MEMBERNAME, String MEMBERADDRESS, String MEMBERPHONE) {
		// TODO Auto-generated constructor stub
		this.MEMBERID = MEMBERID;
		this.MEMBERPW = MEMBERPW;
		this.MEMBERNAME = MEMBERNAME;
		this.MEMBERADDRESS = MEMBERADDRESS;
		this.MEMBERPHONE = MEMBERPHONE;
	}

	public String getMEMBERID() {
		return MEMBERID;
	}

	public void setMEMBERID(String mEMBERID) {
		MEMBERID = mEMBERID;
	}

	public String getMEMBERPW() {
		return MEMBERPW;
	}

	public void setMEMBERPW(String mEMBERPW) {
		MEMBERPW = mEMBERPW;
	}

	public String getMEMBERNAME() {
		return MEMBERNAME;
	}

	public void setMEMBERNAME(String mEMBERNAME) {
		MEMBERNAME = mEMBERNAME;
	}

	public String getMEMBERADDRESS() {
		return MEMBERADDRESS;
	}

	public void setMEMBERADDRESS(String mEMBERADDRESS) {
		MEMBERADDRESS = mEMBERADDRESS;
	}

	public String getMEMBERPHONE() {
		return MEMBERPHONE;
	}

	public void setMEMBERPHONE(String mEMBERPHONE) {
		MEMBERPHONE = mEMBERPHONE;
	}

}
