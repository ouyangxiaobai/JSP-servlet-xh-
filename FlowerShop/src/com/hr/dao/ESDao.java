package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_ORDER_DETAIL;
import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;
import com.hr.entity.EASYBUY_USER;
import com.hr.entity.eb_shop;

public class ESDao {
	/**
	 * 两张表联查做购物车
	 */
	public static ArrayList<eb_shop> getShop(String id){
		ArrayList<eb_shop> list=new ArrayList<eb_shop>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
			try {
				ps=conn.prepareStatement("select * from EASYBUY_SHOP where es_EU_USER_ID=? and ES_VALID=1 order by es_id desc");
				ps.setString(1,id);
				rs=ps.executeQuery();
				while(rs.next()){
					eb_shop es=new eb_shop(
							rs.getInt("es_id"),
							rs.getString("es_ep_file_name"),
							rs.getString("es_ep_name"),
							rs.getInt("es_ep_price"),
							rs.getInt("es_eod_quantity"),
							rs.getInt("es_ep_stock"),
							rs.getInt("es_ep_id"),
							rs.getString("es_EU_USER_ID"),
							rs.getInt("es_valid")
								);
					list.add(es);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Basedao.closeall(rs, ps, conn);
				
			}
			return list;
	}
	/*
	 * 
	 *修改订单数量 加
	 */
	public static int updateJia(int id){
		String sql="update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity+1 where es_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	
	/*
	 * 
	 *修改订单数量 减
	 */
	public static int updateJian(int id){
		String sql="update EASYBUY_SHOP set es_eod_quantity=es_eod_quantity-1 where es_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 
	 * 修改订单数量，自己输入
	 */
	public static int updateClose(eb_shop es){
		String sql="update EASYBUY_SHOP set es_eod_quantity=? where es_id=?";
		Object [] params={es.es_eod_quantity,es.es_id};
		return Basedao.exectuIUD(sql, params);
	}
	/**
	 * 修改订单为2
	 * @param id
	 * @return
	 */
	public static int getDelete(int id){
		String sql="update EASYBUY_SHOP set es_vaild=2 where es_id=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 
	 * 订单表的添加
	 * 
	 */
	public static int insertDD(String id,String name,String address,int price){
		String sql="insert into EASYBUY_ORDER values(null,?,?,?,now(),?,1,1)";
		Object [] params={id,name,address,price};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 得到序列
	 */
	public static int getSequenceId(){
		int id = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select EO_ID from easybuy_order order by EO_ID desc limit 0,1");
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return id;
	}
	/*
	 * 
	 * 订单详细表的添加
	 */
	public static int eodInsert(EASYBUY_ORDER_DETAIL eod){
		String sql="insert into EASYBUY_ORDER_DETAIL values(null,?,?,?,?)";
		Object [] params={eod.getEO_ID(),eod.getEP_ID(),eod.getEOD_QUANTITY(),eod.getEOD_COST()};
		return Basedao.exectuIUD(sql, params);
	}
	/*
	 * 
	 * 购物单的修改
	 */
	public static int esdelete(int id){
		String sql="update  EASYBUY_SHOP set es_valid=2 where es_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
	//kucun
	public static int updateStock(int stock,int id){
		String sql="update EASYBUY_PRODUCT set ep_stock=ep_stock-? where ep_id=?";
		Object [] params={stock,id};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int insert(eb_shop sp){
		String sql = "insert into easybuy_shop values(null,?,?,?,?,?,?,?,1)";
		Object[] params = {sp.getEs_ep_file_name(),
							sp.getEs_ep_name(),
							sp.getEs_ep_price(),
							sp.getEs_eod_quantity(),
							sp.getEs_ep_stock(),
							sp.getEs_ep_id(),
							sp.getEs_EU_USER_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static  int getDeleteDD(int id){
		String sql="delete from easybuy_shop where es_id=?";
		Object [] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}
