package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_USER;

public class EASYBUY_USERDao {
	/**
	 * 分页查询
	 */
	public static ArrayList<EASYBUY_USER> selectAll(int cpage,int count){
		ArrayList<EASYBUY_USER> list = new ArrayList<EASYBUY_USER>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_USER order by EU_BIRTHDAY desc"+
					" limit ?, ?");
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_USER u = new EASYBUY_USER(rs.getString("EU_USER_ID"),
										rs.getString("EU_USER_NAME"), 
										rs.getString("EU_PASSWORD"),
										rs.getString("EU_SEX"),
										rs.getString("EU_BIRTHDAY"),
										rs.getString("EU_IDENTITY_CODE"),
										rs.getString("EU_EMAIL"),
										rs.getString("EU_MOBILE"),
										rs.getString("EU_ADDRESS"),
										rs.getInt("EU_STATUS"));
				list.add(u);
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
	 * 查询所有
	 * @return
	 */
	public static ArrayList<EASYBUY_USER> selectAll(){
		ArrayList<EASYBUY_USER> list = new ArrayList<EASYBUY_USER>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_USER");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_USER u = new EASYBUY_USER(rs.getString("EU_USER_ID"),
										rs.getString("EU_USER_NAME"), 
										rs.getString("EU_PASSWORD"),
										rs.getString("EU_SEX"),
										rs.getString("EU_BIRTHDAY"),
										rs.getString("EU_IDENTITY_CODE"),
										rs.getString("EU_EMAIL"),
										rs.getString("EU_MOBILE"),
										rs.getString("EU_ADDRESS"),
										rs.getInt("EU_STATUS"));
				list.add(u);
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
	public static EASYBUY_USER selectById(String id){
		EASYBUY_USER u = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select m.*,DATE_FORMAT(m.eu_birthday,'%Y-%m-%d')birthday from EASYBUY_USER m where EU_USER_ID=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				u = new EASYBUY_USER(rs.getString("EU_USER_ID"),
						rs.getString("EU_USER_NAME"), 
						rs.getString("EU_PASSWORD"),
						rs.getString("EU_SEX"),
						rs.getString("birthday"),
						rs.getString("EU_IDENTITY_CODE"),
						rs.getString("EU_EMAIL"),
						rs.getString("EU_MOBILE"),
						rs.getString("EU_ADDRESS"),
						rs.getInt("EU_STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	/**
	 * 查看是否有此人
	 * @param id
	 * @return
	 */
	public static int selectByName(String id){
		int count=0;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_USER where EU_USER_ID=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	/**
	 * 看用户名和密码对不对
	 */
	public static int selectByNM(String name,String pwd){
		int count=0;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_USER where EU_USER_ID=? and EU_PASSWORD=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return count;
	}
	/**
	 * 判断是普通用户还是管理员
	 * @param name
	 * @param pwd
	 * @return
	 */
	public static EASYBUY_USER selectAdmin(String name,String pwd){
		EASYBUY_USER user=null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_USER where EU_USER_ID=? and EU_PASSWORD=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new EASYBUY_USER(rs.getString("EU_USER_ID"),
						rs.getString("EU_USER_NAME"), 
						rs.getString("EU_PASSWORD"),
						rs.getString("EU_SEX"),
						rs.getString("EU_BIRTHDAY"),
						rs.getString("EU_IDENTITY_CODE"),
						rs.getString("EU_EMAIL"),
						rs.getString("EU_MOBILE"),
						rs.getString("EU_ADDRESS"),
						rs.getInt("EU_STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return user;
	}
	/**
	 * 分页管理
	 * @param u
	 * @return
	 */
	public static int totalPage(int count){
		int tpage=1;
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select count(*) from EASYBUY_USER");
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
	public static int insert(EASYBUY_USER u){
		String sql = "insert into EASYBUY_USER values(?,?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)";
		Object[] params = {u.getEU_USER_ID(),
							u.getEU_USER_NAME(),
							u.getEU_PASSWORD(),
							u.getEU_SEX(),
							u.getEU_BIRTHDAY(),
							u.getEU_IDENTITY_CODE(),
							u.getEU_EMAIL(),
							u.getEU_MOBILE(),
							u.getEU_ADDRESS(),
							u.getEU_STATUS()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int update(EASYBUY_USER u){
		String sql = "update EASYBUY_USER set EU_USER_NAME=?," +
											"EU_PASSWORD=?," +
											"EU_SEX=?," +
											"EU_BIRTHDAY=DATE_FORMAT(?,'%Y-%m-%d')," +
											"EU_IDENTITY_CODE=?," +
											"EU_EMAIL=?," +
											"EU_MOBILE=?," +
											"EU_ADDRESS=?," +
											"EU_STATUS=? " +
											"where EU_USER_ID=?";
		Object[] params = {u.getEU_USER_NAME(),
							u.getEU_PASSWORD(),
							u.getEU_SEX(),
							u.getEU_BIRTHDAY(),
							u.getEU_IDENTITY_CODE(),
							u.getEU_EMAIL(),
							u.getEU_MOBILE(),
							u.getEU_ADDRESS(),
							u.getEU_STATUS(),
							u.getEU_USER_ID()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int del(String id){
		String sql = "delete from EASYBUY_USER where EU_USER_ID=? and EU_USER_ID!='admin'";
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
	}
}
