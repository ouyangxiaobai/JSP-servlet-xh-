package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_PRODUCT_CATEGORY;

public class EASYBUY_PRODUCT_CATEGORYDao {
	
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectAll(){
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"),
										rs.getString("EPC_NAME"), 
										rs.getInt("EPC_PARENT_ID"));
				list.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 根据id查询单个
	 * @param id
	 * @return
	 */
	public static EASYBUY_PRODUCT_CATEGORY selectById(int id){
		EASYBUY_PRODUCT_CATEGORY pc = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"),
						rs.getString("EPC_NAME"), 
						rs.getInt("EPC_PARENT_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return pc;
	}
	
	public static int insert(EASYBUY_PRODUCT_CATEGORY pc){
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,?)";
		Object[] params = {pc.getEPC_NAME(),
							pc.getEPC_PARENT_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int insertOnFather(EASYBUY_PRODUCT_CATEGORY pc){
		String sql = "insert into EASYBUY_PRODUCT_CATEGORY values(null,?,0)";
		Object[] params = {pc.getEPC_NAME()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int update(EASYBUY_PRODUCT_CATEGORY pc){
		String sql = "update EASYBUY_PRODUCT_CATEGORY set EPC_NAME=?," +
											"EPC_PARENT_ID=?" +
											" where EPC_ID=?";
		Object[] params = {pc.getEPC_NAME(),
							pc.getEPC_PARENT_ID(),
							pc.getEPC_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int del(int id){
		String sql = "delete from EASYBUY_PRODUCT_CATEGORY where EPC_ID=?";
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
	}
	/**
	 * 查询父分类
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectFather(){
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_PARENT_ID = 0");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"),
										rs.getString("EPC_NAME"), 
										rs.getInt("EPC_PARENT_ID"));
				list.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 查询子分类
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT_CATEGORY> selectChild(){
		ArrayList<EASYBUY_PRODUCT_CATEGORY> list = new ArrayList<EASYBUY_PRODUCT_CATEGORY>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT_CATEGORY where EPC_ID!=EPC_PARENT_ID");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT_CATEGORY pc = new EASYBUY_PRODUCT_CATEGORY(rs.getInt("EPC_ID"),
										rs.getString("EPC_NAME"), 
										rs.getInt("EPC_PARENT_ID"));
				list.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
}
