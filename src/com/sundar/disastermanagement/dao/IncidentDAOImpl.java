package com.sundar.disastermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		int id = 0;
		try{
			dbUtil=DBUtil.getDBUtil();
			c=dbUtil.getConnection();
			
			PreparedStatement ps=c.prepareStatement("INSERT INTO INCIDENT"
					+ "(NAME,MOBILE,DESCRIPTION,INCIDENT_TYPE_ID,LOCATION_ID,MESSAGE_STATUS,TIME)"
					+ " VALUES(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, incident.getName());
			ps.setString(2, incident.getMobile());
			ps.setString(3, incident.getDescription());
			ps.setInt(4, incident.getIncidentType().getIncidentTypeID());
			ps.setInt(5, incident.getLocation().getLocationID());
			ps.setBoolean(6, false);
			Timestamp time=new Timestamp(incident.getDate().getTime());
			ps.setTimestamp(7,time );
			int n=ps.executeUpdate();
			if(n==0)
				System.out.println("record is not inserted");
			else
				{
				System.out.println("record is sucessfully inserted");
				

			    rs = ps.getGeneratedKeys();
			    
			    if (rs.next()) {
			    	id=rs.getInt(1);
			    } else {
			    	System.out.println("its not worked");
			    	return incident;
			    }
			    rs.close();
			    System.out.println("Key returned from getGeneratedKeys():"
			        + id);
				}
			String refId=21+incident.getTaluk()+incident.getLocation().getLocationID()+id;
			long referenceId=Long.parseLong(refId);
			PreparedStatement ps1=c.prepareStatement("UPDATE INCIDENT "
					+ " SET REFERENCE_NO=? "
					+ " WHERE ID=?");
			ps1.setLong(1,referenceId);
			ps1.setInt(2,id);
			ps1.executeUpdate();
			incident.setUserId(id);
			incident.setReferenceId(referenceId);
			ps1.close();
			ps.close();
			c.close();
			return incident;
		}catch (Exception e){
			System.out.println(e);
			return incident;
		}	
	}
	public void updateMessageStatus(int userID)
	{
		DBUtil dbUtil;
		Connection c;
		try{
			dbUtil=DBUtil.getDBUtil();
			c=dbUtil.getConnection();
			
			PreparedStatement ps=c.prepareStatement("UPDATE INCIDENT " + 
					" SET MESSAGE_STATUS=? " + 
					" WHERE ID=? ");
			ps.setBoolean(1,true);
			ps.setInt(2,userID);
			ps.executeUpdate();
			ps.close();
			c.close();
		}catch (Exception e){
			System.out.println(e);
		}
	}

	public Map<String,Object> getIncidentById(long userID) {
		// TODO Auto-generated method stub
		Map<String,Object>map =new HashMap<String,Object>();
		StatusVO statusVO=new StatusVO();
		IncidentVO incidentVO=new IncidentVO();
		LocationVO locationVO=new LocationVO();
		IncidentTypeVO incidentTypeVO=new IncidentTypeVO();
		incidentVO.setF(false);
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT * FROM Incident WHERE REFERENCE_NO=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setLong(1,userID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				incidentVO.setUserId(rs.getInt("ID"));
				incidentVO.setName(rs.getString("NAME"));
				incidentVO.setMobile(rs.getString("MOBILE"));
				incidentVO.setDescription(rs.getString("DESCRIPTION"));
				incidentTypeVO.setIncidentTypeID(rs.getInt("INCIDENT_TYPE_ID"));
				incidentVO.setIncidentType(incidentTypeVO);
				locationVO.setLocationID(rs.getInt("LOCATION_ID"));
				incidentVO.setLocation(locationVO);
				incidentVO.setDate(rs.getTimestamp("TIME"));
				incidentVO.setMsgStatus(rs.getBoolean("MESSAGE_STATUS"));
				incidentVO.setAction(rs.getString("ACTION"));
				incidentVO.setF(true);
			}
			if(incidentVO.isF())
			{
				statusVO.setStatusCode("*");
				statusVO.setStatusMsg("");
			}
			else
			{
				statusVO.setStatusCode("Invalid");
				statusVO.setStatusMsg("Given id is the Invalid reference number");
			}
			
			map.put("incident", incidentVO);
			map.put("statusVO", statusVO);
			rs.close();
			ps.close();
			c.close();
			return map;
		}catch (Exception e){
			
		statusVO.setStatusCode("Problem");
		statusVO.setStatusMsg("connection not found");
		map.put("incident", incidentVO);
		map.put("statusVO", statusVO);
		return map;
		}
		
	}
	public List<LocationVO> getVillagesByTalukId(int talukId) {
		List<LocationVO> list=new ArrayList<LocationVO>();
		try{
			DBUtil dbUtil=DBUtil.getDBUtil();
			Connection c=dbUtil.getConnection();
			String sql="SELECT village_code,village_tname,village_name FROM LOCATION WHERE taluk_code=?";
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setInt(1,talukId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				LocationVO locationVO=new LocationVO();
				locationVO.setLocationID(rs.getInt("village_code"));
				locationVO.setVillageName(rs.getString("village_name"));
				locationVO.setVillageTamilName(rs.getString("village_tname"));
				list.add(locationVO);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
}
