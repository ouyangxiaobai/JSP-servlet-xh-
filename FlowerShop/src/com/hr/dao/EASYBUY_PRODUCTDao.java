package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_PRODUCT;

public class EASYBUY_PRODUCTDao {
	
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAll(){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
										rs.getString("EP_NAME"), 
										rs.getString("EP_DESCRIPTION"),
										rs.getInt("EP_PRICE"),
										rs.getInt("EP_STOCK"),
										rs.getInt("EPC_ID"),
										rs.getInt("EPC_CHILD_ID"),
										rs.getString("EP_FILE_NAME"));
				list.add(p);
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
	 * 名字模糊查询
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByName(String name){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_NAME like ?");
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
										rs.getString("EP_NAME"), 
										rs.getString("EP_DESCRIPTION"),
										rs.getInt("EP_PRICE"),
										rs.getInt("EP_STOCK"),
										rs.getInt("EPC_ID"),
										rs.getInt("EPC_CHILD_ID"),
										rs.getString("EP_FILE_NAME"));
				list.add(p);
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
	public static EASYBUY_PRODUCT selectById(int id){
		EASYBUY_PRODUCT p = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return p;
	}
	
	/**
	 * 根据fid查询所有
	 * @param fid
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(int fid){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_ID=?");
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
										rs.getString("EP_NAME"), 
										rs.getString("EP_DESCRIPTION"),
										rs.getInt("EP_PRICE"),
										rs.getInt("EP_STOCK"),
										rs.getInt("EPC_ID"),
										rs.getInt("EPC_CHILD_ID"),
										rs.getString("EP_FILE_NAME"));
				list.add(p);
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
	 * 根据cid查询所有
	 * @param fid
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cid){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			while(rs.next()){
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
										rs.getString("EP_NAME"), 
										rs.getString("EP_DESCRIPTION"),
										rs.getInt("EP_PRICE"),
										rs.getInt("EP_STOCK"),
										rs.getInt("EPC_ID"),
										rs.getInt("EPC_CHILD_ID"),
										rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return list;
	}
	
	public static int insert(EASYBUY_PRODUCT p){
		String sql = "insert into EASYBUY_PRODUCT values(null,?,?,?,?,?,?,?)";
		Object[] params = {p.getEP_NAME(),
							p.getEP_DESCRIPTION(),
							p.getEP_PRICE(),
							p.getEP_STOCK(),
							p.getEPC_ID(),
							p.getEPC_CHILD_ID(),
							p.getEP_FILE_NAME()};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int update(EASYBUY_PRODUCT p){
		if(!p.getEP_FILE_NAME().equals("")){
			String sql = "update EASYBUY_PRODUCT set EP_NAME=?," +
											"EP_DESCRIPTION=?," +
											"EP_PRICE=?," +
											"EP_STOCK=?," +
											"EPC_ID=?," +
											"EPC_CHILD_ID=?," +
											"EP_FILE_NAME=? " +
											" where EP_ID=?";
		 
		 Object[] params = {p.getEP_NAME(),
					p.getEP_DESCRIPTION(),
					p.getEP_PRICE(),
					p.getEP_STOCK(),
					p.getEPC_ID(),
					p.getEPC_CHILD_ID(),
					p.getEP_FILE_NAME(),
					p.getEP_ID()};
		 return Basedao.exectuIUD(sql, params);
		}else{
			String	 sql = "update EASYBUY_PRODUCT set EP_NAME=?," +
												"EP_DESCRIPTION=?," +
												"EP_PRICE=?," +
												"EP_STOCK=?," +
												"EPC_ID=?," +
												"EPC_CHILD_ID=? " +
												" where EP_ID=?";
			 Object[] params = {p.getEP_NAME(),
						p.getEP_DESCRIPTION(),
						p.getEP_PRICE(),
						p.getEP_STOCK(),
						p.getEPC_ID(),
						p.getEPC_CHILD_ID(),
						p.getEP_ID()};
			 return Basedao.exectuIUD(sql, params);
		}
		
		
	}
	
	public static int del(int id){
		String sql = "delete from EASYBUY_PRODUCT where EP_ID=?";
		Object[] params = {id};
		return Basedao.exectuIUD(sql, params);
	}
	
	public static int totalPage(int count){
		int tpage = 1;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT");
			rs = ps.executeQuery();
			if(rs.next()){
				int sum = rs.getInt(1);//获得表的总行数
				if(sum%count==0){
					tpage = sum/count;//总行数是每页行数的整倍数
				}else {
					tpage = sum/count+1;//不是整倍数要加一
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	
	public static int totalPageByFid(int count,int fid){
		int tpage = 1;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_ID=?");
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			if(rs.next()){
				int sum = rs.getInt(1);//获得表的总行数
				if(sum%count==0){
					tpage = sum/count;//总行数是每页行数的整倍数
				}else {
					tpage = sum/count+1;//不是整倍数要加一
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	
	public static int totalPageByCid(int count,int cid){
		int tpage = 1;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EPC_CHILD_ID=?");
			ps.setInt(1, cid);
			rs = ps.executeQuery();
			if(rs.next()){
				int sum = rs.getInt(1);//获得表的总行数
				if(sum%count==0){
					tpage = sum/count;//总行数是每页行数的整倍数
				}else {
					tpage = sum/count+1;//不是整倍数要加一
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	
	public static int totalPageByName(int count,String name){
		int tpage = 1;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) from EASYBUY_PRODUCT where EP_NAME like ?");
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				int sum = rs.getInt(1);//获得表的总行数
				if(sum%count==0){
					tpage = sum/count;//总行数是每页行数的整倍数
				}else {
					tpage = sum/count+1;//不是整倍数要加一
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		return tpage;
	}
	/**
	 * 分页查询
	 * @param cpage
	 * @param count
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAll(int cpage,int count){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		Connection conn =Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from EASYBUY_PRODUCT order by EP_ID desc limit ?,? ";
		try {
			ps = conn.prepareStatement(sql);
			//设置数据区间
			ps.setInt(1, count*(cpage-1));
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while(rs.next()) {
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	/**
	 * fid分页查询
	 * @param cpage
	 * @param count
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByFid(int cpage,int count,int fid){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		Connection conn =Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from EASYBUY_PRODUCT where EPC_ID = ? order by EP_ID desc limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			//设置数据区间
			ps.setInt(1, fid);
			ps.setInt(2, count*(cpage-1));
			ps.setInt(3, count);
			rs = ps.executeQuery();
			while(rs.next()) {
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	/**
	 * cid分页查询
	 * @param cpage
	 * @param count
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByCid(int cpage,int count,int cid){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		Connection conn =Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from EASYBUY_PRODUCT where EPC_CHILD_ID = ? order by EP_ID desc limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			//设置数据区间
			ps.setInt(1, cid);
			ps.setInt(2, count*(cpage-1));
			ps.setInt(3, count);
			rs = ps.executeQuery();
			while(rs.next()) {
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	/**
	 * 根据id数组查询单个，并放入集合
	 * @param id
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectById(ArrayList<Integer> ids){
		ArrayList<EASYBUY_PRODUCT> lastlylist = new ArrayList<EASYBUY_PRODUCT>();
		EASYBUY_PRODUCT p = null;
		ResultSet rs = null;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		try {
			for(int i=0;i<ids.size();i++){
				ps = conn.prepareStatement("select * from EASYBUY_PRODUCT where EP_ID=?");
				ps.setInt(1, ids.get(i));
				rs = ps.executeQuery();
				while(rs.next()){
					p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
							rs.getString("EP_NAME"), 
							rs.getString("EP_DESCRIPTION"),
							rs.getInt("EP_PRICE"),
							rs.getInt("EP_STOCK"),
							rs.getInt("EPC_ID"),
							rs.getInt("EPC_CHILD_ID"),
							rs.getString("EP_FILE_NAME"));
					lastlylist.add(p);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return lastlylist;
	}
	
	/**
	 * 查询特价商品
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByT(){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		Connection conn =Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from EASYBUY_PRODUCT order by EP_PRICE asc limit 0,9";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
	
	/**
	 * 查询热卖商品
	 * @return
	 */
	public static ArrayList<EASYBUY_PRODUCT> selectAllByHot(){
		ArrayList<EASYBUY_PRODUCT> list = new ArrayList<EASYBUY_PRODUCT>();
		Connection conn =Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from ( select tab1.* from  (  select * from easybuy_product a,  (select ep_id eod_ep_id,sum(EOD_QUANTITY) buysum from EASYBUY_ORDER_DETAIL  group by EP_id order by sum(EOD_QUANTITY) desc) b  where a.ep_id=b.eod_ep_id order by buysum desc  ) tab1) tab2 limit 0,8";
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				EASYBUY_PRODUCT p = new EASYBUY_PRODUCT(rs.getInt("EP_ID"),
						rs.getString("EP_NAME"), 
						rs.getString("EP_DESCRIPTION"),
						rs.getInt("EP_PRICE"),
						rs.getInt("EP_STOCK"),
						rs.getInt("EPC_ID"),
						rs.getInt("EPC_CHILD_ID"),
						rs.getString("EP_FILE_NAME"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return list;
	}
}
