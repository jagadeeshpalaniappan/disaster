package com.sundar.disastermanagement.dao;


import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.StatusVO;

public interface IncidentDAOInf {
	public  StatusVO createIncident(IncidentVO incident);
	public  IncidentVO getIncidentById(int userID);
}
