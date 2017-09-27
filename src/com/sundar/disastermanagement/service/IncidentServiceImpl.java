package com.sundar.disastermanagement.service;

import java.util.ArrayList;
import java.util.List;

import com.sundar.disastermanagement.dao.IncidentDAOImpl;
import com.sundar.disastermanagement.dao.IncidentMappingDAO;
import com.sundar.disastermanagement.vo.IncidentInchargeVO;
import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.StatusVO;

public class IncidentServiceImpl implements IncidentServiceInf{
	private static IncidentServiceImpl incidentService=new IncidentServiceImpl();
	
	private IncidentServiceImpl(){}
	
	public static IncidentServiceImpl getIncidentService(){
		return incidentService;
	}
	

	public  StatusVO createIncident(IncidentVO incidentVO)
	{
		int locationId=incidentVO.getLocation().getLocationID();
		String description=incidentVO.getDescription();
		IncidentDAOImpl incidentDAO=IncidentDAOImpl.getIncidentDAO();
		StatusVO statusVO=incidentDAO.createIncident(incidentVO);
		IncidentMappingDAO dao=new IncidentMappingDAO();
		List<IncidentInchargeVO> list=new ArrayList<IncidentInchargeVO>();
		list=dao.getIncidentInchargeById(locationId);
		MailService mailService=new MailService();
		for(IncidentInchargeVO inchargeVO:list)
		{
			System.out.println(inchargeVO.getEmail()+inchargeVO.getName()+list);
		mailService.send(inchargeVO.getEmail(),"Flood" ,description);
		}
		return statusVO;
	}
	
	
	public IncidentVO getIncidentById(int userId) {
		// TODO Auto-generated method stub
		IncidentDAOImpl incidentDAO=IncidentDAOImpl.getIncidentDAO();
		IncidentVO incidentVO=new IncidentVO();
		incidentVO=incidentDAO.getIncidentById(userId);
		return incidentVO;
	}
}
