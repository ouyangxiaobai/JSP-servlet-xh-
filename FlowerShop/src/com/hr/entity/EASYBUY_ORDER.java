package com.hr.entity;

//订单
public class EASYBUY_ORDER {
	private int EO_ID;
	private String EO_USER_ID;
	private String EO_USER_NAME;
	private String EO_USER_ADDRESS;
	private String EO_CREATE_TIME;
	private int EO_COST;
	private int EO_STATUS;
	private int EO_TYPE;
	
	public String getOrderStatusStr(){
		if(this.EO_STATUS==1){
			return "待审核";
		}else if(this.EO_STATUS==2){
			return "审核通过";
		}else if(this.EO_STATUS==3){
			return "配货";
		}else if(this.EO_STATUS==4){
			return "发货";
		}else{
			return "确认收货";
		}
	}
	
	public EASYBUY_ORDER(int eOID, String eOUSERID, String eOUSERNAME,
			String eOUSERADDRESS, String eOCREATETIME, int eOCOST,
			int eOSTATUS, int eOTYPE) {
		//super();
		EO_ID = eOID;
		EO_USER_ID = eOUSERID;
		EO_USER_NAME = eOUSERNAME;
		EO_USER_ADDRESS = eOUSERADDRESS;
		EO_CREATE_TIME = eOCREATETIME;
		EO_COST = eOCOST;
		EO_STATUS = eOSTATUS;
		EO_TYPE = eOTYPE;
	}
	public int getEO_ID() {
		return EO_ID;
	}
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}
	public String getEO_USER_ID() {
		return EO_USER_ID;
	}
	public void setEO_USER_ID(String eOUSERID) {
		EO_USER_ID = eOUSERID;
	}
	public String getEO_USER_NAME() {
		return EO_USER_NAME;
	}
	public void setEO_USER_NAME(String eOUSERNAME) {
		EO_USER_NAME = eOUSERNAME;
	}
	public String getEO_USER_ADDRESS() {
		return EO_USER_ADDRESS;
	}
	public void setEO_USER_ADDRESS(String eOUSERADDRESS) {
		EO_USER_ADDRESS = eOUSERADDRESS;
	}
	public String getEO_CREATE_TIME() {
		return EO_CREATE_TIME;
	}
	public void setEO_CREATE_TIME(String eOCREATETIME) {
		EO_CREATE_TIME = eOCREATETIME;
	}
	public int getEO_COST() {
		return EO_COST;
	}
	public void setEO_COST(int eOCOST) {
		EO_COST = eOCOST;
	}
	public int getEO_STATUS() {
		return EO_STATUS;
	}
	public void setEO_STATUS(int eOSTATUS) {
		EO_STATUS = eOSTATUS;
	}
	public int getEO_TYPE() {
		return EO_TYPE;
	}
	public void setEO_TYPE(int eOTYPE) {
		EO_TYPE = eOTYPE;
	}
}
