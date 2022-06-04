package com.hr.entity;

//订单详细
public class EASYBUY_ORDER_DETAIL {
	private int EOD_ID;
	private int EO_ID;
	private int EP_ID;
	private int EOD_QUANTITY;
	private int EOD_COST;
	public EASYBUY_ORDER_DETAIL(int eODID, int eOID, int ePID, int eODQUANTITY,
			int eODCOST) {
		//super();
		EOD_ID = eODID;
		EO_ID = eOID;
		EP_ID = ePID;
		EOD_QUANTITY = eODQUANTITY;
		EOD_COST = eODCOST;
	}
	public int getEOD_ID() {
		return EOD_ID;
	}
	public void setEOD_ID(int eODID) {
		EOD_ID = eODID;
	}
	public int getEO_ID() {
		return EO_ID;
	}
	public void setEO_ID(int eOID) {
		EO_ID = eOID;
	}
	public int getEP_ID() {
		return EP_ID;
	}
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}
	public int getEOD_QUANTITY() {
		return EOD_QUANTITY;
	}
	public void setEOD_QUANTITY(int eODQUANTITY) {
		EOD_QUANTITY = eODQUANTITY;
	}
	public int getEOD_COST() {
		return EOD_COST;
	}
	public void setEOD_COST(int eODCOST) {
		EOD_COST = eODCOST;
	}
}
