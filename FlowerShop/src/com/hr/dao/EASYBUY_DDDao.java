package com.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hr.entity.EASYBUY_DD;

public class EASYBUY_DDDao {
	public static ArrayList<EASYBUY_DD> selectById(int id){
		ArrayList<EASYBUY_DD> dd=new ArrayList<EASYBUY_DD>();
		Connection conn=Basedao.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from EASYBUY_ORDER eo,EASYBUY_ORDER_DETAIL eod,EASYBUY_PRODUCT ep where eo.eo_id=? and eod.eo_id=eo.eo_id and eod.ep_id= ep.ep_id");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				EASYBUY_DD d=new EASYBUY_DD(rs.getString("EP_NAME"), rs.getString("EP_FILE_NAME"), rs.getInt("EP_PRICE"), rs.getInt("EOD_QUANTITY"), rs.getInt("EP_STOCK"));
				dd.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		return dd;
	}
}
