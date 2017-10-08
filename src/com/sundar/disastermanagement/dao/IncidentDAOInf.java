package com.sundar.disastermanagement.dao;


import java.util.List;
import java.util.Map;

import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.LocationVO;

public interface IncidentDAOInf {
	public  IncidentVO createIncident(IncidentVO incident);
	public  Map<String,Object> getIncidentById(long userID);
	public  List<LocationVO> getVillagesByTalukId(int talukID);
	public void updateMessageStatus(int userID);
}
