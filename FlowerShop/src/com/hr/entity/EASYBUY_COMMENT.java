package com.hr.entity;

//留言
public class EASYBUY_COMMENT {
	private int EC_ID;
	private String EC_CONTENT;
	private String EC_CREATE_TIME;
	private String EC_REPLY;
	private String EC_REPLY_TIME;
	private String EC_NICK_NAME;
	public EASYBUY_COMMENT(int eCID, String eCCONTENT, String eCCREATETIME,
			String eCREPLY, String eCREPLYTIME, String eCNICKNAME) {
		//super();
		EC_ID = eCID;
		EC_CONTENT = eCCONTENT;
		EC_CREATE_TIME = eCCREATETIME;
		EC_REPLY = eCREPLY;
		EC_REPLY_TIME = eCREPLYTIME;
		EC_NICK_NAME = eCNICKNAME;
	}
	public EASYBUY_COMMENT() {
	}
	public int getEC_ID() {
		return EC_ID;
	}
	public void setEC_ID(int eCID) {
		EC_ID = eCID;
	}
	public String getEC_CONTENT() {
		return EC_CONTENT;
	}
	public void setEC_CONTENT(String eCCONTENT) {
		EC_CONTENT = eCCONTENT;
	}
	public String getEC_CREATE_TIME() {
		return EC_CREATE_TIME;
	}
	public void setEC_CREATE_TIME(String eCCREATETIME) {
		EC_CREATE_TIME = eCCREATETIME;
	}
	public String getEC_REPLY() {
		return EC_REPLY;
	}
	public void setEC_REPLY(String eCREPLY) {
		EC_REPLY = eCREPLY;
	}
	public String getEC_REPLY_TIME() {
		return EC_REPLY_TIME;
	}
	public void setEC_REPLY_TIME(String eCREPLYTIME) {
		EC_REPLY_TIME = eCREPLYTIME;
	}
	public String getEC_NICK_NAME() {
		return EC_NICK_NAME;
	}
	public void setEC_NICK_NAME(String eCNICKNAME) {
		EC_NICK_NAME = eCNICKNAME;
	}
}
