package com.sundar.disastermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sundar.disastermanagement.util.DBUtil;
import com.sundar.disastermanagement.vo.IncidentInchargeVO;
import com.sundar.disastermanagement.vo.IncidentVO;

public class IncidentMappingDAO {
	
	
	
	public List<IncidentInchargeVO> getIncidentInchargeById(IncidentVO incidentVO) {
		// TODO Auto-generated method stub
		List<IncidentInchargeVO> list=new ArrayList<IncidentInchargeVO>();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT * FROM INCIDENT_INCHARGE WHERE INCHARGE_ID IN "
					+ "(SELECT INCHARGE_ID FROM INCIDENT_MAPPING WHERE "
					+ "INCIDENT_TYPE_ID=? AND LOCATION_ID=?)";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1,incidentVO.getIncidentType().getIncidentTypeID());
			ps.setInt(2, incidentVO.getLocation().getLocationID());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				IncidentInchargeVO inchargeVO=new IncidentInchargeVO();
				inchargeVO.setInchargeID(rs.getInt("INCHARGE_ID"));
				inchargeVO.setName(rs.getString("NAME"));
				inchargeVO.setMobile(rs.getString("MOBILE"));
				list.add(inchargeVO);
				System.out.println(inchargeVO.getMobile()+"   "+inchargeVO.getName());
			}
			rs.close();
			ps.close();
			c.close();
		}catch (Exception e){
		}
		return list;
	}
}
