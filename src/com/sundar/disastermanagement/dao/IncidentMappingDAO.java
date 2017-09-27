package com.sundar.disastermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sundar.disastermanagement.util.DBUtil;
import com.sundar.disastermanagement.vo.IncidentInchargeVO;

public class IncidentMappingDAO {
	
	
	
	public List<IncidentInchargeVO> getIncidentInchargeById(int locationID) {
		// TODO Auto-generated method stub
		IncidentInchargeVO inchargeVO=new IncidentInchargeVO();
		List<IncidentInchargeVO> list=new ArrayList<IncidentInchargeVO>();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT * FROM INCIDENT_INCHARGE WHERE INCHARGE_ID IN "
					+ "(SELECT INCHARGE_ID FROM INCIDENT_MAPPING WHERE LOCATION_ID=?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1,locationID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				inchargeVO.setInchargeID(rs.getInt("INCHARGE_ID"));
				inchargeVO.setName(rs.getString("NAME"));
				inchargeVO.setMobile(rs.getString("MOBILE"));
				inchargeVO.setEmail(rs.getString("EMAIL"));
				inchargeVO.setDesignation(rs.getString("DESIGNATION"));
				list.add(inchargeVO);
				System.out.println(inchargeVO.getInchargeID()+inchargeVO.getName());
			}
			for(IncidentInchargeVO inchargeVO1:list)
			{
				System.out.println(inchargeVO1.getEmail()+inchargeVO1.getName());
			}
			rs.close();
			ps.close();
			c.close();
		}catch (Exception e){
		}
		return list;
	}
}
