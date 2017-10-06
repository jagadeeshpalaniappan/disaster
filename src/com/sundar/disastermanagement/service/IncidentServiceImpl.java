package com.sundar.disastermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sundar.disastermanagement.dao.IncidentDAOImpl;
import com.sundar.disastermanagement.dao.IncidentMappingDAO;
import com.sundar.disastermanagement.vo.IncidentInchargeVO;
import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.LocationVO;
import com.sundar.disastermanagement.vo.StatusVO;

public class IncidentServiceImpl implements IncidentServiceInf{
	private static IncidentServiceImpl incidentService=new IncidentServiceImpl();
	
	private IncidentServiceImpl(){}
	
	public static IncidentServiceImpl getIncidentService(){
		return incidentService;
	}
	

	public  StatusVO createIncident(IncidentVO incidentVO)
	{
		StatusVO statusVO = new StatusVO();
		IncidentDAOImpl incidentDAO=IncidentDAOImpl.getIncidentDAO();
		incidentVO=(incidentDAO.createIncident(incidentVO));
		if(incidentVO.getUserId()!=-1)
		{
		statusVO.setUserId(incidentVO.getUserId());
		IncidentMappingDAO dao=new IncidentMappingDAO();
		List<IncidentInchargeVO> list=new ArrayList<IncidentInchargeVO>();
		list=dao.getIncidentInchargeById(incidentVO);
		
		MailService mailService=new MailService();
		MessageService messageService=new MessageService();
		messageService.sendMsg(list,incidentVO);
		mailService.send(incidentVO);
		statusVO.setStatusCode("Success");
		statusVO.setStatusMsg("your incident is reported successfully");
		return statusVO;
		}
		else{
			statusVO.setStatusCode("Problem");
			statusVO.setStatusMsg("your incident is not reported");
			return statusVO;
		}
	}
	
	
	public Map<String,Object> getIncidentById(int userId) {
		// TODO Auto-generated method stub
		IncidentDAOImpl incidentDAO=IncidentDAOImpl.getIncidentDAO();
		Map<String,Object> map=incidentDAO.getIncidentById(userId);
		return map;
	}
	public  List<LocationVO> getVillagesByTalukId(int talukID)
	{
		IncidentDAOImpl incidentDAO=IncidentDAOImpl.getIncidentDAO();
		List<LocationVO> list=incidentDAO.getVillagesByTalukId(talukID);
		return list;
	}
}
