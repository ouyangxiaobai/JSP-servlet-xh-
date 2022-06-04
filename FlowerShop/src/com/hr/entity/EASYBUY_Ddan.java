package com.hr.entity;

public class EASYBUY_Ddan {
	private int EO_ID;
	private String  EO_USER_ID;
	private String EP_NAME;
	private String EP_FILE_NAME;
	private int EP_PRICE;
	private int EOD_QUANTITY;
	private int EP_STOCK;
	
	
	public EASYBUY_Ddan(int eOID, String eOUSERID, String ePNAME,
			String ePFILENAME, int ePPRICE, int eODQUANTITY, int ePSTOCK) {
		EO_ID = eOID;
		EO_USER_ID = eOUSERID;
		EP_NAME = ePNAME;
		EP_FILE_NAME = ePFILENAME;
		EP_PRICE = ePPRICE;
		EOD_QUANTITY = eODQUANTITY;
		EP_STOCK = ePSTOCK;
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
	public String getEP_NAME() {
		return EP_NAME;
	}
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}
	public int getEP_PRICE() {
		return EP_PRICE;
	}
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}
	public int getEP_STOCK() {
		return EP_STOCK;
	}
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}
}
