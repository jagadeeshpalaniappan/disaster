package com.sundar.disastermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.sundar.disastermanagement.util.DBUtil;
import com.sundar.disastermanagement.vo.IncidentTypeVO;
import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.LocationVO;
import com.sundar.disastermanagement.vo.StatusVO;


public class IncidentDAOImpl implements IncidentDAOInf{
	private static IncidentDAOImpl incidentDAO=new IncidentDAOImpl();
	
	private IncidentDAOImpl(){}
	
	public static IncidentDAOImpl getIncidentDAO(){
		return incidentDAO;
	}
	public  IncidentVO createIncident(IncidentVO incident)
	{
		DBUtil dbUtil;
		Connection c;
		ResultSet rs;
		try{
			dbUtil=DBUtil.getDBUtil();
			c=dbUtil.getConnection();
			
			PreparedStatement ps=c.prepareStatement("INSERT INTO INCIDENT"
					+ "(NAME,MOBILE,DESCRIPTION,INCIDENT_TYPE_ID,LOCATION_ID,MESSAGE_STATUS,MAIL_STATUS,TIME)"
					+ " VALUES(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, incident.getName());
			ps.setString(2, incident.getMobile());
			ps.setString(3, incident.getDescription());
			ps.setInt(4, incident.getIncidentType().getIncidentTypeID());
			ps.setInt(5, incident.getLocation().getLocationID());
			ps.setBoolean(6, false);
			ps.setBoolean(7, false);
			Timestamp time=new Timestamp(incident.getDate().getTime());
			ps.setTimestamp(8,time );
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				{
				System.out.println("record is sucessfully inserted");
				

			    rs = ps.getGeneratedKeys();
			    if (rs.next()) {
			    	incident.setUserId(rs.getInt(1));
			    } else {
			    	System.out.println("its not worked");
			    	return incident;
			    }
			    rs.close();
			    System.out.println("Key returned from getGeneratedKeys():"
			        + incident.getUserId());
				}
			ps.close();
			c.close();
			return incident;
		}catch (Exception e){
			System.out.println(e);
			return incident;
		}	
	}

	public Map<String,Object> getIncidentById(int userID) {
		// TODO Auto-generated method stub
		Map<String,Object>map =new HashMap<String,Object>();
		StatusVO statusVO=new StatusVO();
		IncidentVO incidentVO=new IncidentVO();
		LocationVO locationVO=new LocationVO();
		IncidentTypeVO incidentTypeVO=new IncidentTypeVO();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT * FROM Incident WHERE USER_ID=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1,userID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				incidentVO.setUserId(rs.getInt("USER_ID"));
				incidentVO.setName(rs.getString("NAME"));
				incidentVO.setMobile(rs.getString("MOBILE"));
				incidentVO.setDescription(rs.getString("DESCRIPTION"));
				incidentTypeVO.setIncidentTypeID(rs.getInt("INCIDENT_TYPE_ID"));
				incidentVO.setIncidentType(incidentTypeVO);
				locationVO.setLocationID(rs.getInt("LOCATION_ID"));
				incidentVO.setLocation(locationVO);
				incidentVO.setDate(rs.getTimestamp("TIME"));
				incidentVO.setMailStatus(rs.getBoolean("MAIL_STATUS"));
				incidentVO.setMsgStatus(rs.getBoolean("MESSAGE_STATUS"));
				incidentVO.setF(true);
			}
			statusVO.setStatusCode("*");
			statusVO.setStatusMsg("");
			map.put("incident", incidentVO);
			map.put("statusVO", statusVO);
			rs.close();
			ps.close();
			c.close();
			return map;
		}catch (Exception e){
		statusVO.setStatusCode("Problem");
		statusVO.setStatusMsg("connection not found");
		map.put("StatusVO", statusVO);
		return map;
		}
		
	}
	
}
