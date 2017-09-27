package com.sundar.disastermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public  StatusVO createIncident(IncidentVO incident)
	{
		StatusVO statusVO=new StatusVO();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			PreparedStatement ps=c.prepareStatement("INSERT INTO INCIDENT(NAME,MOBILE,EMAIL,DESCRIPTION,INCIDENT_TYPE_ID,LOCATION_ID,MESSAGE_STATUS)"
					+ " VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, incident.getName());
			ps.setString(2, incident.getMobile());
			ps.setString(3, incident.getEmail());
			ps.setString(4, incident.getDescription());
			ps.setInt(5, incident.getIncidentType().getIncidentTypeID());
			ps.setInt(6, incident.getLocation().getLocationID());
			ps.setBoolean(7, false);
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				{
				System.out.println("record is sucessfully inserted");
				statusVO.setStatusCode("Success");
				statusVO.setStatusMsg("your incident is reported successfully");
				}
			ps.close();
			c.close();
			return statusVO;
		}catch (Exception e){
			System.out.println(e);
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("your incident is not reported ,try again");
			return statusVO;
		}
	}

	public IncidentVO getIncidentById(int userID) {
		// TODO Auto-generated method stub
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
				incidentVO.setEmail(rs.getString("EMAIL"));
				incidentVO.setDescription(rs.getString("DESCRIPTION"));
				incidentTypeVO.setIncidentTypeID(rs.getInt("INCIDENT_TYPE_ID"));
				incidentVO.setIncidentType(incidentTypeVO);
				locationVO.setLocationID(rs.getInt("LOCATION_ID"));
				incidentVO.setLocation(locationVO);
				incidentVO.setStatus(rs.getString("MESSAGE_STATUS"));
				incidentVO.setF(true);
			}
			statusVO.setStatusCode("*");
			statusVO.setStatusMsg("");
			rs.close();
			ps.close();
			c.close();
		}catch (Exception e){
		statusVO.setStatusCode("Problem");
		statusVO.setStatusMsg("connection not found");
		}
		return incidentVO;
	}
	
}
