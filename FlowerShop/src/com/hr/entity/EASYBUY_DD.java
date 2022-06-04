package com.hr.entity;

public class EASYBUY_DD {
private String EP_NAME;
private String EP_FILE_NAME;
private int EP_PRICE;
private int EOD_QUANTITY;
private int EP_STOCK;

public EASYBUY_DD(String ePNAME, String ePFILENAME, int ePPRICE,
		int eODQUANTITY, int ePSTOCK) {
	EP_NAME = ePNAME;
	EP_FILE_NAME = ePFILENAME;
	EP_PRICE = ePPRICE;
	EOD_QUANTITY = eODQUANTITY;
	EP_STOCK = ePSTOCK;
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
