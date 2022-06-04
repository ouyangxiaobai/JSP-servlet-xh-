package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_NEWS;


public class EASYBUY_NEWSDao {
	public static ArrayList<EASYBUY_NEWS> selectAll(){
		ArrayList<EASYBUY_NEWS> list=new ArrayList<EASYBUY_NEWS>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from EASYBUY_NEWS");
			rs=ps.executeQuery();
			while (rs.next()) {
				EASYBUY_NEWS c=new EASYBUY_NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}

	public static EASYBUY_NEWS selectById(int id){
		EASYBUY_NEWS c=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from EASYBUY_NEWS where EN_ID=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				c=new EASYBUY_NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return c;
	}
	/**
	 * 分页查询
	 */
	public static ArrayList<EASYBUY_NEWS> selectAll(int cpage,int count){
		ArrayList<EASYBUY_NEWS> list=new ArrayList<EASYBUY_NEWS>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_NEWS order by EN_ID desc limit ?, ?");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2,count);
			rs=ps.executeQuery();
			while (rs.next()) {
				EASYBUY_NEWS c=new EASYBUY_NEWS(rs.getInt("EN_ID"),rs.getString("EN_TITLE") , rs.getString("EN_CONTENT"),rs.getString("EN_CREATE_TIME") );
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	/**
	 * 分页管理
	 * @param n
	 * @return
	 */
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from EASYBUY_NEWS");
			rs=ps.executeQuery();
			while(rs.next()){
				int sum=rs.getInt(1);
				if(sum%count==0){
					tpage=sum/count;
				}else{
					tpage=sum/count+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	public static int insert(EASYBUY_NEWS n){
		String sql="insert into EASYBUY_NEWS values(null,?,?,NOW())";
		Object[] params={n.getEN_TITLE(),n.getEN_CONTENT()};
		return Basedao.exectuIUD(sql, params);
	}

	public static int update(EASYBUY_NEWS n){
		String sql="update EASYBUY_NEWS set EN_TITLE=?,EN_CONTENT=? where EN_ID=?";
		Object[] params={n.getEN_TITLE(),n.getEN_CONTENT(),n.getEN_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id){
		String sql="delete from EASYBUY_NEWS where EN_ID=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}
