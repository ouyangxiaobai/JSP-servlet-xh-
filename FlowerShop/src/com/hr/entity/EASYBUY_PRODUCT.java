package com.hr.entity;

//商品
public class EASYBUY_PRODUCT {
	private int EP_ID;
	private String EP_NAME;
	private String EP_DESCRIPTION;
	private int EP_PRICE;
	private int EP_STOCK;
	private int EPC_ID;
	private int EPC_CHILD_ID;
	private String EP_FILE_NAME;
	public EASYBUY_PRODUCT(int ePID, String ePNAME, String ePDESCRIPTION,
			int ePPRICE, int ePSTOCK, int ePCID, int ePCCHILDID,
			String ePFILENAME) {
		//super();
		EP_ID = ePID;
		EP_NAME = ePNAME;
		EP_DESCRIPTION = ePDESCRIPTION;
		EP_PRICE = ePPRICE;
		EP_STOCK = ePSTOCK;
		EPC_ID = ePCID;
		EPC_CHILD_ID = ePCCHILDID;
		EP_FILE_NAME = ePFILENAME;
	}
	public int getEP_ID() {
		return EP_ID;
	}
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}
	public String getEP_NAME() {
		return EP_NAME;
	}
	public void setEP_NAME(String ePNAME) {
		EP_NAME = ePNAME;
	}
	public String getEP_DESCRIPTION() {
		return EP_DESCRIPTION;
	}
	public void setEP_DESCRIPTION(String ePDESCRIPTION) {
		EP_DESCRIPTION = ePDESCRIPTION;
	}
	public int getEP_PRICE() {
		return EP_PRICE;
	}
	public void setEP_PRICE(int ePPRICE) {
		EP_PRICE = ePPRICE;
	}
	public int getEP_STOCK() {
		return EP_STOCK;
	}
	public void setEP_STOCK(int ePSTOCK) {
		EP_STOCK = ePSTOCK;
	}
	public int getEPC_ID() {
		return EPC_ID;
	}
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}
	public int getEPC_CHILD_ID() {
		return EPC_CHILD_ID;
	}
	public void setEPC_CHILD_ID(int ePCCHILDID) {
		EPC_CHILD_ID = ePCCHILDID;
	}
	public String getEP_FILE_NAME() {
		return EP_FILE_NAME;
	}
	public void setEP_FILE_NAME(String ePFILENAME) {
		EP_FILE_NAME = ePFILENAME;
	}
}
