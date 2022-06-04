package com.hr.entity;

public class eb_shop {
	//购物车id
	public int es_id;
	//商品图片名称
	public String es_ep_file_name;
	//商品名称
	public String es_ep_name;
	//商品单价
	public int es_ep_price;
	//购买数量
	public int es_eod_quantity;
	//商品库存
	public int es_ep_stock;
	//商品id
	public int es_ep_id;
	//用户id
	public String es_EU_USER_ID;
	//是否结账
	public int ea_valid;
	
	
	public eb_shop(int esId, String esEpFileName, String esEpName,
			int esEpPrice, int esEodQuantity, int esEpStock, int esEpId,
			String esEUUSERID, int eaValid) {
		super();
		es_id = esId;
		es_ep_file_name = esEpFileName;
		es_ep_name = esEpName;
		es_ep_price = esEpPrice;
		es_eod_quantity = esEodQuantity;
		es_ep_stock = esEpStock;
		es_ep_id = esEpId;
		es_EU_USER_ID = esEUUSERID;
		ea_valid = eaValid;
	}
	public int getEs_id() {
		return es_id;
	}
	public void setEs_id(int esId) {
		es_id = esId;
	}
	public String getEs_ep_file_name() {
		return es_ep_file_name;
	}
	public void setEs_ep_file_name(String esEpFileName) {
		es_ep_file_name = esEpFileName;
	}
	public String getEs_ep_name() {
		return es_ep_name;
	}
	public void setEs_ep_name(String esEpName) {
		es_ep_name = esEpName;
	}
	public int getEs_ep_price() {
		return es_ep_price;
	}
	public void setEs_ep_price(int esEpPrice) {
		es_ep_price = esEpPrice;
	}
	public int getEs_eod_quantity() {
		return es_eod_quantity;
	}
	public void setEs_eod_quantity(int esEodQuantity) {
		es_eod_quantity = esEodQuantity;
	}
	public int getEs_ep_stock() {
		return es_ep_stock;
	}
	public void setEs_ep_stock(int esEpStock) {
		es_ep_stock = esEpStock;
	}
	public int getEs_ep_id() {
		return es_ep_id;
	}
	public void setEs_ep_id(int esEpId) {
		es_ep_id = esEpId;
	}
	public String getEs_EU_USER_ID() {
		return es_EU_USER_ID;
	}
	public void setEs_EU_USER_ID(String esEUUSERID) {
		es_EU_USER_ID = esEUUSERID;
	}
	public int getEa_valid() {
		return ea_valid;
	}
	public void setEa_valid(int eaValid) {
		ea_valid = eaValid;
	}
	
	
}
