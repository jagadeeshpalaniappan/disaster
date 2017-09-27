package com.sundar.disastermanagement.service;


import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.StatusVO;

public interface IncidentServiceInf {
	public  StatusVO createIncident(IncidentVO incidentVO);
	public  IncidentVO getIncidentById(int userId);
}
