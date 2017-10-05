package com.sundar.disastermanagement.dao;


import java.util.Map;

import com.sundar.disastermanagement.vo.IncidentVO;

public interface IncidentDAOInf {
	public  IncidentVO createIncident(IncidentVO incident);
	public  Map<String,Object> getIncidentById(int userID);
}
