package com.sundar.disastermanagement.servlet;
import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sundar.disastermanagement.service.IncidentServiceImpl;
import com.sundar.disastermanagement.vo.IncidentVO;
import com.sundar.disastermanagement.vo.StatusVO;


/**
 * Servlet implementation class ViewStudentServlet
 */
public class ViewIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewIncidentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
				System.out.println("sundar");
				int userId=Integer.parseInt(request.getParameter("userId"));
				System.out.println(userId);
					IncidentServiceImpl impl=IncidentServiceImpl.getIncidentService();
					Map<String, Object> map = impl.getIncidentById(userId);
					IncidentVO incidentVO=new IncidentVO();
					incidentVO=(IncidentVO) map.get("incident");
					StatusVO statusVO=(StatusVO) map.get("statusVO");
					if (incidentVO.isF()) {
						request.setAttribute("incident", incidentVO);
						request.setAttribute("status", statusVO);
					}
					else
						request.setAttribute("status", statusVO);
				ServletContext context = getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/jsp/incident/viewIncident.jsp");
				rd.forward(request, response);

	}	
}
