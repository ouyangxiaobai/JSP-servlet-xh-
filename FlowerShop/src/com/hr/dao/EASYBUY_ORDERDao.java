package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_NEWS;
import com.hr.entity.EASYBUY_ORDER;


public class EASYBUY_ORDERDao {
	
	public static ArrayList<EASYBUY_ORDER> selectAll(){
		ArrayList<EASYBUY_ORDER> list=new ArrayList<EASYBUY_ORDER>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from EASYBUY_ORDER");
			rs=ps.executeQuery();
			while (rs.next()) {
				EASYBUY_ORDER c=new EASYBUY_ORDER(rs.getInt("EO_ID"),rs.getString("EO_USER_ID"),rs.getString("EO_USER_NAME"),rs.getString("EO_USER_ADDRESS"),rs.getString("EO_CREATE_TIME"),rs.getInt("EO_COST"),rs.getInt("EO_STATUS"),rs.getInt("EO_TYPE"));
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

	public static EASYBUY_ORDER selectById(int id){
		EASYBUY_ORDER c=null;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from EASYBUY_ORDER where EO_ID=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				c=new EASYBUY_ORDER(rs.getInt("EO_ID"),rs.getString("EO_USER_ID"),rs.getString("EO_USER_NAME"),rs.getString("EO_USER_ADDRESS"),rs.getString("EO_CREATE_TIME"),rs.getInt("EO_COST"),rs.getInt("EO_STATUS"),rs.getInt("EO_TYPE"));
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
	 * @param o
	 * @return
	 */
	public static int totalPage(int count,String id,String name){
		int tpage=1;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String sql = "select count(*) from EASYBUY_ORDER where 1=1 ";
			ArrayList params = new ArrayList();
			if(id!=null && !"".equals(id)){
				sql += " and EO_ID=?";
				params.add(id);
			}
			if(name!=null && !"".equals(name)){
				sql += " and EO_USER_NAME like ? ";
				params.add("%"+name+"%");
			}
			ps=conn.prepareStatement(sql);
			for(int i=0;i<params.size();i++){
				ps.setObject(i+1, params.get(i));
			}
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
	/**
	 * 分页查询
	 */
	public static ArrayList<EASYBUY_ORDER> selectAll(int cpage,int count,String id,String name){
		ArrayList<EASYBUY_ORDER> list=new ArrayList<EASYBUY_ORDER>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ArrayList params = new ArrayList();
			String query_sql = "select * from EASYBUY_ORDER where 1=1 ";
			if(id!=null && !"".equals(id)){
				query_sql += " and EO_ID=?";
				params.add(id);
			}
			if(name!=null && !"".equals(name)){
				query_sql += " and EO_USER_NAME like ? ";
				params.add("%"+name+"%");
			}
			query_sql+=" order by EO_ID desc limit ?,?";
			String sql ="select * from("+
			"select rownum rn,a.* from("+
			query_sql+
			")a)b where b.rn between ? and ?";
			params.add(count*(cpage-1));
			params.add(count);
			ps=conn.prepareStatement(query_sql);
			for(int i=0;i<params.size();i++){
				ps.setObject(i+1, params.get(i));
			}
			rs=ps.executeQuery();
			while (rs.next()) {
				EASYBUY_ORDER c=new EASYBUY_ORDER(rs.getInt("EO_ID"),rs.getString("EO_USER_ID"),rs.getString("EO_USER_NAME"),rs.getString("EO_USER_ADDRESS"),rs.getString("EO_CREATE_TIME"),rs.getInt("EO_COST"),rs.getInt("EO_STATUS"),rs.getInt("EO_TYPE"));
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
	public static int insert(EASYBUY_ORDER o){
		String sql="insert into EASYBUY_ORDER values(null,?,?,?,?,?,?)";
		Object[] params={o.getEO_USER_ID(),o.getEO_USER_NAME(),o.getEO_USER_ADDRESS(),o.getEO_CREATE_TIME(),o.getEO_COST(),o.getEO_STATUS(),o.getEO_TYPE()};
		return Basedao.exectuIUD(sql, params);
	}

	public static int update(EASYBUY_ORDER o){
		String sql="update EASYBUY_ORDER set EO_USER_NAME=?,EO_USER_ADDRESS=?,EO_COST=?,EO_STATUS=? where EO_ID=?";
		Object[] params={o.getEO_USER_NAME(),o.getEO_USER_ADDRESS(),o.getEO_COST(),o.getEO_STATUS(),o.getEO_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	public static int del(int id){
		String sql="delete from EASYBUY_ORDER where EO_ID=?";
		Object[] params={id};
		return Basedao.exectuIUD(sql, params);
	}
}
