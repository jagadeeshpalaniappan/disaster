package com.sundar.disastermanagement.service;


import java.util.Map;

import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.StatusVO;

public interface IncidentServiceInf {
	public  StatusVO createIncident(IncidentVO incidentVO);
	public  Map<String,Object> getIncidentById(int userId);
}
