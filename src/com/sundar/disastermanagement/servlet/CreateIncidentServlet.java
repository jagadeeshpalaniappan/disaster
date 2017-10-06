package com.sundar.disastermanagement.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sundar.disastermanagement.service.IncidentServiceImpl;
import com.sundar.disastermanagement.vo.IncidentTypeVO;
import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.LocationVO;
import com.sundar.disastermanagement.vo.StatusVO;


/**
 * Servlet implementation class CreateIncidentServlet
 */
public class CreateIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateIncidentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("HELLO: ");
		
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/jsp/student/createStudent.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		IncidentVO incidentVO=new IncidentVO();
		LocationVO locationVO =new LocationVO();
		IncidentTypeVO incidentTypeVO=new IncidentTypeVO();
		incidentVO.setUserId(-1);
		incidentVO.setName(request.getParameter("name"));
		incidentVO.setMobile(request.getParameter("mobile"));
		incidentVO.setDescription(request.getParameter("description"));
		int locationId=Integer.parseInt(request.getParameter("village"));
		incidentVO.setTaluk(request.getParameter("taluk"));
		locationVO.setLocationID(locationId);
		incidentVO.setLocation(locationVO);
		incidentTypeVO.setIncidentTypeID(Integer.parseInt(request.getParameter("incidentType")));
		incidentVO.setIncidentType(incidentTypeVO);
		incidentVO.setDate(Calendar.getInstance().getTime());
		IncidentServiceImpl s=IncidentServiceImpl.getIncidentService();
		StatusVO statusVO=s.createIncident(incidentVO);
		//System.out.println(incidentVO.getDate());
		request.setAttribute("status", statusVO);
		ServletContext context= getServletContext();
		RequestDispatcher rd= context.getRequestDispatcher("/jsp/incident/confrim.jsp");
		rd.forward(request, response);
		System.out.println("hi da shiva");
	}
}

